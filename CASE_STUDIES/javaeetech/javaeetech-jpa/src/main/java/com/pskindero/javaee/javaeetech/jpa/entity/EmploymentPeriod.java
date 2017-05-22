package com.pskindero.javaee.javaeetech.jpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmploymentPeriod {

	@Column(name="from_date", nullable=false)
	private Date fromDate; 
	
	@Column(name="to_date", nullable=true)
	private Date toDate;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "EmploymentPeriod [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
}
