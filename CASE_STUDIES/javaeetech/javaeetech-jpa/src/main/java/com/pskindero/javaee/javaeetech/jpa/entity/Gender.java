package com.pskindero.javaee.javaeetech.jpa.entity;

public enum Gender {
	MALE('M'),
	FEMALE('F');
	
	private char value;
	
	private Gender(char value) {
		this.value = value;
	}
	
	public static Gender getEnum(String value) {
		if (value.equals(MALE.toString()))
			return MALE;
		else if (value.equals(FEMALE.toString()))
			return FEMALE;
		else
			throw new IllegalArgumentException("Wrong enum value - " + value);
	}
	
	public String toString() {
		return Character.toString(value);
	}
}