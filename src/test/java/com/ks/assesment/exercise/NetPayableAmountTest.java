package com.ks.assesment.exercise;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ks.assesment.exercise.dto.billing.Bill;
import com.ks.assesment.exercise.dto.billing.Item;
import com.ks.assesment.exercise.dto.billing.ItemCategory;
import com.ks.assesment.exercise.dto.user.Customer;
import com.ks.assesment.exercise.dto.user.User;
import com.ks.assesment.exercise.dto.user.UserType;
import com.ks.assesment.exercise.service.DiscountCalculationService;

@SpringBootTest
class NetPayableAmountTest {

    @Autowired
    private DiscountCalculationService discountCalculationService;

    @Test
    void testCalculateNetPayableAmount_AllGroceryItems() {
        Bill bill = createGroceryBill(UserType.CUSTOMER);
        discountCalculationService.calculateNetPayableAmount(bill);
        assertEquals(bill.getNetAmount(), bill.getPayableAmount());
    }

    @Test
    void testCalculateNetPayableAmount_NotGroceryItemsEmployee() {
        User user = User.builder().userId("1").userType(UserType.EMPLOYEE).build();
        Bill bill = createNonGroceryBill(user);
        discountCalculationService.calculateNetPayableAmount(bill);
        assertEquals(100.0, bill.getPayableAmount());
    }
    
    @Test
    void testCalculateNetPayableAmount_NotGroceryItemsAffiliate() {
    	User user = User.builder().userId("1").userType(UserType.AFFILIATE).build();
        Bill bill = createNonGroceryBill(user);
        discountCalculationService.calculateNetPayableAmount(bill);
        assertEquals(130.0, bill.getPayableAmount());
    }
    
    @Test
    void testCalculateNetPayableAmount_NotGroceryItemsCustomer() {
    	Customer cutomer = Customer.builder().userId("1").userType(UserType.CUSTOMER).registrationDate(LocalDate.now().minusYears(3)).build();
        Bill bill = createNonGroceryBill(cutomer);
        discountCalculationService.calculateNetPayableAmount(bill);
        assertEquals(137.5, bill.getPayableAmount());
    }
    
    @Test
    void testCalculateNetPayableAmount_NotGroceryItemsNewCustomer() {
    	Customer cutomer = Customer.builder().userId("1").userType(UserType.CUSTOMER).registrationDate(LocalDate.now().minusYears(1)).build();
        Bill bill = createNonGroceryBill(cutomer);
        discountCalculationService.calculateNetPayableAmount(bill);
        assertEquals(145.0, bill.getPayableAmount());
    }
    
    @Test
    void testCalculateNetPayableAmount_NotGroceryItemsCustomerNoRegistration() {
    	Customer cutomer = Customer.builder().userId("1").userType(UserType.CUSTOMER).build();
        Bill bill = createNonGroceryBill(cutomer);
        discountCalculationService.calculateNetPayableAmount(bill);
        assertEquals(145.0, bill.getPayableAmount());
    }

    private Bill createNonGroceryBill(User user) {
        Item item1 = Item.builder().name("Air Condition").price(10).quantity(5).category(ItemCategory.ELECTRONICS).build();
        Item item2 = Item.builder().name("Vaccum Cleaner").price(20).quantity(5).category(ItemCategory.ELECTRONICS).build();
        return Bill.builder().items(List.of(item1, item2)).user(user).build();
    }

    private Bill createGroceryBill(UserType userType) {
        User user = User.builder().userId("1").userType(userType).build();
        Item item1 = Item.builder().name("Rice").price(10).quantity(5).category(ItemCategory.GROCERY).build();
        Item item2 = Item.builder().name("Bread").price(20).quantity(5).category(ItemCategory.GROCERY).build();
        return Bill.builder().items(List.of(item1, item2)).user(user).build();
    }
}
