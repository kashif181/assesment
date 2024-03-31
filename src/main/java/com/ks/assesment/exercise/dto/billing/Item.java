package com.ks.assesment.exercise.dto.billing;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
	private String name;
    private double price;
    private int quantity;
    private ItemCategory category;
}
