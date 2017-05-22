package com.pskindero.javaee.javaeetech.jpa.entity;

import javax.persistence.AttributeConverter;

public class GenderConverter implements AttributeConverter<Gender, String>{

	@Override
	public String convertToDatabaseColumn(Gender attribute) {
		return attribute.toString();
	}

	@Override
	public Gender convertToEntityAttribute(String dbData) {
		return Gender.getEnum(dbData);
	}

}
