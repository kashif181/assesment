package com.ks.assesment.exercise.discount;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ks.assesment.exercise.dto.billing.Bill;
import com.ks.assesment.exercise.dto.user.Customer;
import com.ks.assesment.exercise.dto.user.UserType;

@Component
public class CustomerDiscountStrategy implements DiscountStrategy {
    private static final double DISCOUNT_PERCENTAGE = 5.0;

    @Override
    public double calculateDiscount(Bill bill) {
        
    	Customer customer = (Customer)bill.getUser();
    	
        if (customer.getRegistrationDate() != null && customer.getRegistrationDate() .isBefore(LocalDate.now().minusYears(2))) {
        	return (DISCOUNT_PERCENTAGE / 100) * bill.getNetAmount();
        }
        return 0;
    }

    @Override
    public boolean supports(UserType userType) {
        return userType == UserType.CUSTOMER;
    }
}