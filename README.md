# Assign4Q1COMP3005

**SpringBoot Set up:**

Install JAVA 17 or higher
in application.properties set datasoure url to whatever port your psql server runs on
using your IDE run the application you can go to file A4Q1Application.java to run it

**Database setup:** 

login as postgres or  any user and create a database school (CREATE DATABASE school;)
give access to this database to the user you are currently using (GRANT ALL PRIVILEGES ON DATABASE "school" TO [user])

DDL:
CREATE TABLE students
	(
		student_id		SERIAL PRIMARY KEY, 
		first_name		VARCHAR(255) NOT NULL, 
		last_name		VARCHAR(255) NOT NULL, 
		email			VARCHAR(255) UNIQUE NOT NULL,
		enrollment_date		DATE
	);

Sample Data:
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

**Front End:**

download node package manager
open terminal and do npm install -g @angular/cli
open front end folder: student-management-system
and run npm install in this directory 
after which it can be started by running ng serve --port [port]

**Video**
Video Link: https://youtu.be/vV_Qo5ttCDQ
