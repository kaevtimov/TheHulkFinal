package Orders;

import Goods.Good;

public class Order {

    private Good good;
    private String orderInfo;
    private double totalAmount;
    private int number;
    private int quantity;


    public Order(Good good, String orderInfo, double totalAmount, int number, int quantity) {
        this.good = good;
        this.orderInfo = orderInfo;
        this.totalAmount = totalAmount;
        this.number = number;
        this.quantity = quantity;
    }


    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
