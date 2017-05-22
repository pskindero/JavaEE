--Employee
INSERT INTO employees (first_name, last_name, email, gender, hire_date) 
	values ('Patryk', 'Rozporek', 'prozpor@gacie.com', 'M', '2010-02-13');
INSERT INTO employees (first_name, last_name, email, gender, hire_date) 
	values ('Janina', 'Klawisina', 'jan890@wp.pl', 'F', '2020-04-13');

--Departments
INSERT INTO departments (id, name) values ('DUPA', 'Digital Unit Program Area');
INSERT INTO departments (id, name) values ('BOSA', 'Buissness Operation Support Area');
INSERT INTO departments (id, name) values ('DUMA', 'Digital Unit Management Area');

--Managers
INSERT INTO dept_managers (employee_id, department_id, from_date, to_date)
	values (2, 'DUPA', '2011-01-01', '2014-02-20');
