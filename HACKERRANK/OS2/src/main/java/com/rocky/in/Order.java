package com.rocky.in;

/*
public class Order {
}
*/

public class Order implements IOrder {
    private  String name;
    private  int price;

    public Order(){
        super();
    }
    public Order(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPrice() {
        return String.valueOf(price);
    }
}
