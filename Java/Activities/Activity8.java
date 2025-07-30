package Activities;

// Custom exception class
class CustomException extends Exception {
    private static final long serialVersionUID = 1L;  // Added to remove warning
    private String message = null;

    public CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

// Main class with exception test
public class Activity8 {
    public static void main(String[] args) {
        try {
            // Method call with correct input
            Activity8.exceptionTest("Will print to console");

            // Method call with incorrect input (null)
            Activity8.exceptionTest(null); // Exception is thrown here

            // This line won't execute because exception was already thrown
            Activity8.exceptionTest("Won't execute");

        } catch (CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }

    static void exceptionTest(String str) throws CustomException {
        if (str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }
}