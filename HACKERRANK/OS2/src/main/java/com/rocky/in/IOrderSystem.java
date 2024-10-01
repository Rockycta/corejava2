package com.rocky.in;

/*public interface IOrderSystem {

}*/

import java.util.Map;

public interface IOrderSystem {
    void addToCart(IOrder order);
    void removeFromCart(IOrder order);
    int calculateTotalAmount();
    Map<String, Integer> categoryDiscounts();
    Map<String, Integer> cartItems();
}
