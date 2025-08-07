--Activity1 -create salesman table
CREATE TABLE salesman (salesman_id int PRIMARY KEY, salesman_name varchar(20), salesman_city varchar(20), commission int);
DESCRIBE salesman;

--Activity 2- Insert data in table
INSERT ALL
		INTO salesman values(5001,'James Hoog', 'New york', 11)
		INTO salesman values(5002,'Paul', 'Paris', 13)
		INTO salesman values(5005,'Nik Sheldon', 'London', 14)
		INTO salesman values(5006,'Mykon', 'Paris', 15)
		INTO salesman values(5003,'Lauson Hen', 'San Jose', 12)
Select 1 FROM DUAL;

--Activity3 -retrieve data from table
SELECT * FROM salesman;

SELECT salesman_id FROM salesman WHERE salesman_city ='Paris'

SELECT salesman_id,commission FROM salesman WHERE salesman_name ='Paul Adam';

--Activity4 -alter and update
ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade = 100;

SELECT * FROM salesman;

--Activity5 -update data

--Update the grade score of salesmen from London to 200
UPDATE salesman SET grade = 200 WHERE salesman_city = 'London';
--Update the grade score of James Hoog to 300.
UPDATE salesman SET grade = 300 WHERE salesman_name = 'James Hoog';
--Update the name Mykon to Piere.
UPDATE salesman SET salesman_name = 'Piere' WHERE salesman_name = 'Mykon';
--Display modified data
SELECT * FROM salesman;


