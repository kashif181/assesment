package com.ks.assesment.exercise.dto.billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ks.assesment.exercise.dto.user.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bill {
    private List<Item> items;
    private User user;
    private double netAmount;
    private double discount;
    private double payableAmount;

    public double getNetAmount() {
        double totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        this.netAmount = totalAmount;
        return netAmount;
    }
    
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
    
    public void setItems(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
