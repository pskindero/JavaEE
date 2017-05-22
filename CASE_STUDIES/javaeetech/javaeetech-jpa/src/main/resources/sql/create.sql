--Schema https://github.com/datacharmer/test_db/blob/master/employees.sql

CREATE TABLE IF NOT EXISTS employees (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
	first_name VARCHAR(20) NOT NULL, 
	last_name VARCHAR(40) NOT NULL,
	email varchar(60) NOT NULL UNIQUE,
	gender ENUM('M', 'F') NOT NULL,
	hire_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS departments (
	id CHAR(4) PRIMARY KEY NOT NULL,
	name varchar(40) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS dept_managers (
	employee_id INT NOT NULL, 
	department_id CHAR(4) NOT NULL,
	from_date DATE NOT NULL,
	to_date DATE,
	FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE,
	FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE CASCADE
);
