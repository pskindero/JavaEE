package com.pskindero.javaee.bean.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.pskindero.javaee.javaeetech.jpa.entity.Department;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "name"})
public class DepartmentTO {

	private String id;
	
	private String name;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static DepartmentTO convert(Department department) {
		DepartmentTO result = new DepartmentTO();
		result.id = department.getId();
		result.name = department.getName();
		return result;
	}
}
