package com.ks.assesment.exercise.dto.billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ks.assesment.exercise.dto.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(500)
        .append("\n=====================================\nBill\n=====================================\n")
        .append("User: ").append(user.getUserId()).append('\n')
        .append("-------------------------------------\n")
        .append("Items:\n");
        for (Item item : items) {
            sb.append(item.getName()).append("\t\t").append(item.getPrice()).append("\t\t").append(item.getQuantity()).append('\n');
        }
        sb.append("-------------------------------------\n")
        .append("Net Amount:\t\t").append(netAmount).append('\n')
        .append("Discount:\t\t").append(discount).append('\n')
        .append("Payable Amount:\t\t").append(payableAmount).append('\n')
        .append("=====================================\n");
        return sb.toString();
    }
}
