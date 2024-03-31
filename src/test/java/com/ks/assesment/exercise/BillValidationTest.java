package com.ks.assesment.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ks.assesment.exercise.dto.billing.Bill;
import com.ks.assesment.exercise.dto.user.User;
import com.ks.assesment.exercise.dto.user.UserType;
import com.ks.assesment.exercise.service.DiscountCalculationService;

@SpringBootTest
public class BillValidationTest {

    @Autowired
    private DiscountCalculationService discountCalculationService;

    @Test
    public void testValidateBill_NullBill() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            discountCalculationService.validateBill(null);
        });

        assertEquals("Bill cannot be null", exception.getMessage());
    }

    @Test
    public void testValidateBill_NullUser() {
        Bill billWithNullUser = Bill.builder().user(null).build();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            discountCalculationService.validateBill(billWithNullUser);
        });

        assertEquals("User in bill cannot be null", exception.getMessage());
    }

    @Test
    public void testValidateBill_ValidBill() {
        User user = User.builder().userId("1").userType(UserType.CUSTOMER).build();
        Bill validBill = Bill.builder().user(user).build();
        assertDoesNotThrow(() -> discountCalculationService.validateBill(validBill));
    }
}