package com.pskindero.javaee.bean_validation.custom_annotation.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class EmailAddressValidator implements ConstraintValidator<EmailAddress, String>  {

	private List<String> availableDomains;
	
	public EmailAddressValidator() {
		this.availableDomains = new ArrayList<String>();
	}

	public void initialize(EmailAddress constraintAnnotation) {
		this.availableDomains.add("google.com");
		this.availableDomains.add("gmail.com");
		this.availableDomains.add("amazon.com");
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("Validating: " + value);
		if (!value.contains("@"))
			return false;
		for (String domain : this.availableDomains) {
			if (value.matches("[a-zA-Z0-9]" + domain)) {
				return true;
			}
		}
		return false;
	}

}
