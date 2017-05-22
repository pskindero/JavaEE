package com.pskindero.javaee.javaeetech.jpa.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dept_managers")
@PrimaryKeyJoinColumn(name = "employee_id", referencedColumnName = "id")
public class Manager extends Employee{
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id", referencedColumnName="id")
	private Department department;
	
	@Embedded
	private EmploymentPeriod employmentPeriod;

	public EmploymentPeriod getEmploymentPeriod() {
		return employmentPeriod;
	}

	public void setEmploymentPeriod(EmploymentPeriod employmentPeriod) {
		this.employmentPeriod = employmentPeriod;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Manager [department=" + department + ", employmentPeriod=" + employmentPeriod + "]";
	}
}
