package com.pskindero.javaee.bean_validation.custom_annotation.model;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Documented
@Target({ ElementType.ANNOTATION_TYPE,
    ElementType.METHOD,
    ElementType.FIELD,
    ElementType.CONSTRUCTOR,
    ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailAddressValidator.class)
@Size(min = 5, message = "{com.pskindero.javaee.bean_validation.custom_annotation.model.EmailAddress min_size}")
@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
@NotNull(message = "{com.pskindero.javaee.bean_validation.custom_annotation.model.EmailAddress cannot be_null}")
public @interface EmailAddress {

	String message() default "{com.pskindero.javaee.bean_validation.custom_annotation.model.EmailAddress}";

	Class<?>[] groups() default {};
    
	Class<? extends Payload>[] payload() default {};

}
