package com.ks.assesment.exercise.dto.billing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
	private String name;
    private double price;
    private int quantity;
    private ItemCategory category;
}
