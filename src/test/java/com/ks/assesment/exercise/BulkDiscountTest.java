package com.ks.assesment.exercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ks.assesment.exercise.service.DiscountCalculationService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BulkDiscountTest {

    @Autowired
    private DiscountCalculationService discountCalculationService;

    @Test
    void testCalculateBulkDiscountBelow_100() {
        double billAmount = 50.0;
        double discount = discountCalculationService.calculateBulkDiscount(billAmount);
        assertEquals(0, discount);
    }

    @Test
    void testCalculateBulkDiscountOver_100() {
        double billAmount = 200.0;
        double discount = discountCalculationService.calculateBulkDiscount(billAmount);
        assertEquals(10.0, discount);
    }
}
