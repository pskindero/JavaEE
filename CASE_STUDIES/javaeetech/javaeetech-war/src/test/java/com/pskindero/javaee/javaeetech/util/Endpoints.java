package com.pskindero.javaee.javaeetech.util;

public class Endpoints {
	
	private static final String BASE_URL = "http://localhost:8080/javaeetech-war-0.0.2-SNAPSHOT";
	
	public static final String GET_ALL_EMPLOYEES_URL = BASE_URL + "/serv/employees";
	public static final String GET_FIRST_EMPLOYEE_URL = GET_ALL_EMPLOYEES_URL + "/1";
	

	public static final String GET_ALL_DEPARTMENTS_URL = BASE_URL + "/serv/departments";
	public static final String GET_DUPA_DEPARTMENT_URL = GET_ALL_DEPARTMENTS_URL + "/DUPA";

	public static final String GET_ALL_MANAGERS_URL = BASE_URL + "/serv/managers";
	public static final String GET_FIRST_MANAGER_URL = GET_ALL_MANAGERS_URL + "/1";

}
