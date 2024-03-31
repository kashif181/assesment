package com.ks.assesment.exercise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ks.assesment.exercise.discount.DiscountStrategy;
import com.ks.assesment.exercise.dto.billing.Bill;
import com.ks.assesment.exercise.dto.billing.ItemCategory;

@Service
public class DiscountCalculationService {

	private static final double BULK_DISCOUNT_AMOUNT = 5;
	
	private static final double BULK_DISCOUNT_THRESHOLD = 100;

	private final List<DiscountStrategy> discountStrategies;

	public DiscountCalculationService(List<DiscountStrategy> discountStrategies) {
		this.discountStrategies = discountStrategies;
	}

	public void calculateNetPayableAmount(Bill bill) {

		validateBill(bill);
		
		double discount = 0.0;

		if (!isAllGroceryItems(bill)) {
			discount = calculateUserTypeDiscount(bill);
		}

		discount += calculateBulkDiscount(bill.getNetAmount());

		double netPayableAmount = Math.max(bill.getNetAmount() - discount, 0);
		
		bill.setDiscount(discount);

		bill.setPayableAmount(netPayableAmount);
	}

	public double calculateUserTypeDiscount(Bill bill) {
		return discountStrategies.stream().filter(strategy -> strategy.supports(bill.getUser().getUserType()))
				.findFirst().map(discountStrategy -> discountStrategy.calculateDiscount(bill)).orElse(0.0);
	}

	public void validateBill(Bill bill) {
		if (bill == null) {
			throw new IllegalArgumentException("Bill cannot be null");
		}

		if (bill.getUser() == null) {
			throw new IllegalArgumentException("User in bill cannot be null");
		}
	}

	public double calculateBulkDiscount(double billAmount) {
		return (int) (billAmount / BULK_DISCOUNT_THRESHOLD) * BULK_DISCOUNT_AMOUNT;
	}

	public boolean isAllGroceryItems(final Bill bill) {
		return bill.getItems().stream().allMatch(item -> item.getCategory() == ItemCategory.GROCERY);
	}
}
