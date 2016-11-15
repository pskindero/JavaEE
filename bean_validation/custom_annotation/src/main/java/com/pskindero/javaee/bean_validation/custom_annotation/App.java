package com.pskindero.javaee.bean_validation.custom_annotation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.pskindero.javaee.bean_validation.custom_annotation.model.Person;

public class App {

	private final Validator validator;

	public App() {
		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public static void main(String[] args) {
		App app = new App();
		Person p = new Person("John", "Smith", 33, "john@gmail.com");

		final Set<ConstraintViolation<Person>> violations = app.validator.validate(p);
		for (final ConstraintViolation<Person> violation : violations) {
			System.out.println("\t" + violation.getPropertyPath() + " " + violation.getMessage());	
		}
	}
}
