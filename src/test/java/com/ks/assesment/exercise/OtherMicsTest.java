package com.ks.assesment.exercise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ks.assesment.exercise.discount.EmployeeDiscountStrategy;
import com.ks.assesment.exercise.dto.user.UserType;;

@SpringBootTest
class OtherMicsTest {

	@Autowired
	private EmployeeDiscountStrategy employeeDiscountStrategy;

	@Test
	void testSupports() {
		UserType userTypeEmployee = UserType.EMPLOYEE;
		UserType userTypeCustomer = UserType.CUSTOMER;
		assertTrue(employeeDiscountStrategy.supports(userTypeEmployee));
		assertFalse(employeeDiscountStrategy.supports(userTypeCustomer));
	}
}