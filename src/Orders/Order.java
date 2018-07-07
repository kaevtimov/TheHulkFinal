package Orders;

import Goods.GoodType;

public class Order {

    private GoodType goodType;//
    private String productName;//
    private double totalAmount;
    private int number;
    private int quantity;
    private OrderActivity orderActivity;


    public Order(GoodType goodType, String productName, double totalAmount, int number, int quantity) {
        this.productName = productName;
        this.goodType = goodType;
        this.totalAmount = totalAmount;
        this.number = number;
        this.quantity = quantity;
        this.orderActivity = OrderActivity.ACTIVE;
    }

    public void showOrder(){      // za da si proverqva customera poruchkite
        System.out.printf("Order number[%d][%s]: %s-\"%s\", quantity: %d. Total amount: %.2f \n",
                getNumber(), orderActivity, getGoodType(), getProductName(), getQuantity(), getTotalAmount());
    }


    public GoodType getGoodType() {
        return goodType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }


    public int getNumber() {
        return number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderActivity getOrderActivity() {
        return orderActivity;
    }

    public void setOrderActivity(OrderActivity orderActivity) {
        this.orderActivity = orderActivity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
