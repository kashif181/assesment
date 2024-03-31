package com.ks.assesment.exercise.discount;

import org.springframework.stereotype.Component;

import com.ks.assesment.exercise.dto.billing.Bill;
import com.ks.assesment.exercise.dto.user.UserType;

@Component
public class AffiliateDiscountStrategy implements DiscountStrategy {
    private static final double DISCOUNT_PERCENTAGE = 10.0;

    @Override
    public double calculateDiscount(Bill bill) {
        return (DISCOUNT_PERCENTAGE / 100) * bill.getNetAmount();
    }
    
    @Override
    public boolean supports(UserType userType) {
        return userType == UserType.AFFILIATE;
    }
}
