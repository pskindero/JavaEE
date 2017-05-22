package com.pskindero.javaee.javaeetech.jpa.base;

import java.lang.reflect.Field;

import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.fail;

public class JpaUnitTest {

	private long startTime;

	@BeforeClass
	public void startTime() {
		this.startTime = System.currentTimeMillis();
	}

	@AfterClass
	public void stopTime() {
		System.out.println("Execution time: " + (System.currentTimeMillis() - this.startTime));
	}

	@BeforeMethod
	public void injectMocks() {
		MockitoAnnotations.initMocks(this);
	}

	protected void inject(final Object target, final String fieldName, final Object injectedObject) {
		try {
			Class<?> c = target.getClass();
			while (c != Object.class) {
				for (Field field : c.getDeclaredFields()) {
					if (!field.isSynthetic()) {
						field.setAccessible(true);
						if (field.equals(fieldName)) {
							field.set(target, injectedObject);
						}
					}
				}
				c = c.getSuperclass();
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			fail("Injection problem: " + e.getMessage());
		}
	}

}
