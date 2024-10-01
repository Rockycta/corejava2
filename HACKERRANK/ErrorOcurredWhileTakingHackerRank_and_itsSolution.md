Actual output is <br>
Total Amount: 319 <br>
Expensive Category Discount: 131<br>
Order-4 (1 items)<br>
Order-3 (1 items)<br>
Order-6 (1 items)<br>
Order-5 (1 items)<br>
Order-2 (1 items)<br>
Order-1 (1 items)<br>
Order-8 (1 items)<br>
Order-7 (1 items)<br>
Order-9 (1 items)<br>

but expected output is 
Actual output is<br>
Total Amount: 319<br>
Expensive Category Discount: 131<br>
Order-4 (1 items)<br>
Order-3 (1 items)<br>
Order-6 (1 items)<br>
Order-5 (1 items)<br>
Order-2 (1 items)<br>
Order-1 (1 items)<br>
Order-8 (1 items)<br>
Order-7 (1 items)<br>
Order-9 (1 items)<br>

What modification required in the code to get the above output?


To achieve the desired output where the cart items are printed in the same order they were added, you'll need to adjust how the cartItems() method is implemented in the OrderSystem class. Currently, the method uses Java Streams, which may not preserve the order of insertion, especially since we're grouping by name.

Suggested Modifications
Change the cartItems() Method: Modify the cartItems() method to maintain the insertion order while counting item occurrences.
Here's the updated implementation of the OrderSystem class with the modified cartItems() method:

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

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
        Map<String, List<IOrder>> groupedByCategory = new HashMap<>();

        for (IOrder order : cart) {
            String category = getCategory(Integer.parseInt(order.getPrice()));
            groupedByCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(order);
        }

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

**    @Override
    public Map<String, Integer> cartItems() {
        Map<String, Integer> itemCountMap = new LinkedHashMap<>();
        for (IOrder order : cart) {
            String name = order.getName();
            itemCountMap.put(name, itemCountMap.getOrDefault(name, 0) + 1);
        }
        return itemCountMap;
    }
**
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
```

Key Changes
Use of LinkedHashMap in cartItems():

The cartItems() method now uses a LinkedHashMap to maintain the order of insertion. This preserves the order of items as they were added to the cart.
Manual Counting Logic:

Instead of using Java Streams, I used a simple loop to increment the count of each order by name, which also preserves the order of items as they are processed.

Test the Code
After making these changes, the output for the provided input should match your expected output:

Total Amount: 319<br>
Expensive Category Discount: 131<br>
Order-4 (1 items)<br>
Order-3 (1 items)<br>
Order-6 (1 items)<br>
Order-5 (1 items)<br>
Order-2 (1 items)<br>
Order-1 (1 items)<br>
Order-8 (1 items)<br>
Order-7 (1 items)<br>
Order-9 (1 items)<br>
Conclusion
By utilizing a LinkedHashMap and manually counting items in the order they are added, you can ensure that the output will match the expected format.