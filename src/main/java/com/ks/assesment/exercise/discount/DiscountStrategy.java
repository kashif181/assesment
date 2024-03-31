package com.ks.assesment.exercise.discount;

import com.ks.assesment.exercise.dto.billing.Bill;
import com.ks.assesment.exercise.dto.user.UserType;

public interface DiscountStrategy {
    double calculateDiscount(Bill bill);
    boolean supports(UserType userType);
}