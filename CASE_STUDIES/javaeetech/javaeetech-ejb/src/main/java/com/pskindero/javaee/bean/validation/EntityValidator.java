package com.pskindero.javaee.bean.validation;

import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class EntityValidator<T> {

	private final Validator validator;

	public EntityValidator() {
		final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	public boolean validate(T entity) {
		final Set<ConstraintViolation<T>> violations = validator.validate(entity);
		return violations.size() == 0;
	}
	
	public boolean validate(Collection<T> entities) {
		long noEntitiesWithConstraintViolation = 
				entities.stream().filter(e -> {return validator.validate(e).size() != 0;}).count();
		return noEntitiesWithConstraintViolation == 0;
	}
}
