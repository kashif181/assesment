package com.ks.assesment.exercise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ks.assesment.exercise.dto.billing.Bill;
import com.ks.assesment.exercise.dto.billing.Item;
import com.ks.assesment.exercise.dto.billing.ItemCategory;
import com.ks.assesment.exercise.dto.user.User;
import com.ks.assesment.exercise.dto.user.UserType;
import com.ks.assesment.exercise.service.DiscountCalculationService;

@SpringBootTest
public class GroceryItemTest {

    @Autowired
    private DiscountCalculationService discountCalculationService;

    @Test
    public void testIsAllGroceryItems_AllGroceries() {
        Bill bill = createGroceryBill(UserType.CUSTOMER);
        assertTrue(discountCalculationService.isAllGroceryItems(bill));
    }

    @Test
    public void testIsAllGroceryItems_NotAllGroceries() {
        Bill bill = createNonGroceryBill(UserType.CUSTOMER);
        assertFalse(discountCalculationService.isAllGroceryItems(bill));
    }

    private Bill createNonGroceryBill(UserType userType) {
        User user = User.builder().userId("1").userType(userType).build();
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