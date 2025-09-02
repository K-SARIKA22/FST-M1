package Activities;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RESTAssuredAPIProject {

    RequestSpecification requestSpec;
    String sshKey = "ssh-YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY";  
    int keyId;

    @BeforeClass
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "token ghp_zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz") 
                .build();
    }

    @Test(priority = 1)
    public void addSSHKey() {
        String requestBody = "{\n" +
                "    \"title\": \"TestAPIKey\",\n" +
                "    \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/user/keys");

        keyId = response.then().extract().path("id");

        Reporter.log("POST Response: " + response.asString(), true);
        Reporter.log("Extracted key ID: " + keyId, true);

        Assert.assertEquals(response.getStatusCode(), 201, "Status code should be 201 for POST");
    }

    @Test(priority = 2, dependsOnMethods = {"addSSHKey"})
    public void getSSHKey() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .get("/user/keys/{keyId}");

        Reporter.log("GET Response: " + response.asString(), true);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 for GET");
        Assert.assertTrue(response.asString().contains("TestAPIKey"));
    }

    @Test(priority = 3, dependsOnMethods = {"getSSHKey"})
    public void deleteSSHKey() {
        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .delete("/user/keys/{keyId}");

        Reporter.log("DELETE Response Status: " + response.getStatusCode(), true);

        Assert.assertEquals(response.getStatusCode(), 204, "Status code should be 204 for DELETE");
    }
}
