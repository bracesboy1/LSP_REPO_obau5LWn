package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {

    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    public void addItem(String itemName, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        items.put(itemName, price);
    }

    public void removeItem(String itemName) {
        if (!items.containsKey(itemName)) {
            throw new IllegalArgumentException("Item does not exist in the cart.");
        }
        items.remove(itemName);
    }

    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public int getCartSize() {
        return items.size();
    }
}


