package com.rocky.in;

import java.util.*;
import java.util.stream.Collectors;

public class OrderSystem implements IOrderSystem {
    private final List<IOrder> cart;

    public OrderSystem() {
        this.cart = new ArrayList<>();
    }

    @Override
    public void addToCart(IOrder order) {
        cart.add(order);
    }

    @Override
    public void removeFromCart(IOrder order) {
        cart.remove(order);
    }

    @Override
    public int calculateTotalAmount() {
        int total = 0;
        for (IOrder order : cart) {
            int price = Integer.parseInt(order.getPrice());
            int discount = getDiscountRate(price);
            int discountedPrice = price - ((price * discount) / 100);
            total += discountedPrice;
        }
        return total;
    }

    @Override
    public Map<String, Integer> categoryDiscounts() {
        Map<String, Integer> categoryDiscountMap = new HashMap<>();
        Map<String, List<IOrder>> groupedByCategory = cart.stream()
                .collect(Collectors.groupingBy(order -> getCategory(Integer.parseInt(order.getPrice()))));

        for (Map.Entry<String, List<IOrder>> entry : groupedByCategory.entrySet()) {
            String category = entry.getKey();
            List<IOrder> orders = entry.getValue();
            int categoryDiscount = 0;

            for (IOrder order : orders) {
                int price = Integer.parseInt(order.getPrice());
                int discount = getDiscountRate(price);
                int discountAmount = (price * discount) / 100;
                categoryDiscount += discountAmount;
            }

            categoryDiscountMap.put(category, categoryDiscount);
        }

        return categoryDiscountMap;
    }

    @Override
    public Map<String, Integer> cartItems() {
        Map<String, Integer> itemCountMap = new LinkedHashMap<>();
        for (IOrder order : cart) {
            String name = order.getName();
            itemCountMap.put(name, itemCountMap.getOrDefault(name, 0) + 1);
        }
        return itemCountMap;
    }

    private String getCategory(int price) {
        if (price <= 10) {
            return "Cheap";
        } else if (price <= 20) {
            return "Moderate";
        } else {
            return "Expensive";
        }
    }

    private int getDiscountRate(int price) {
        String category = getCategory(price);
        switch (category) {
            case "Cheap":
                return 10;
            case "Moderate":
                return 20;
            case "Expensive":
                return 30;
            default:
                return 0;
        }
    }
}
