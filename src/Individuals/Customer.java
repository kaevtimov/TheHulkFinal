package Individuals;

import Goods.GoodType;
import Orders.Order;
import Orders.OrderActivity;
import Orders.Orderable;
import Orders.PayType;

import java.util.ArrayList;


public class Customer extends Individual implements Orderable, Searchable {

    private CustomerType customerType;
    private double budget;
    private ArrayList<Order> customerOrders;
    public static int counterOrderNumber = 1;           // nomera na porednata poruchka
    private static final double DISCOUNT_10 = 0.1;     // otstupka za nad 10 quantity
    private static final double DISCOUNT_25 = 0.25;     // otstupka za nad 25 quantity
    private static final double DELIVERY_PRICE_10 = 0.05;       // cena za dostavka pri nad 10 quantity
    private static final double DELIVERY_PRICE_25 = 0.1;      // cena za dostavka pri nad 25 quantity


    public Customer(String name, double budget, PersonalType personalType, String nationality, String personalInfo, CustomerType customerType) {
        super(name, personalType, nationality, personalInfo);
        this.customerType = customerType;
        this.customerOrders = new ArrayList<>();
        this.budget = budget;
    }


    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }



    public CustomerType getCustomerType() {
        return customerType;
    }

    public ArrayList<Order> getCustomerOrders() {
        return customerOrders;
    }


    @Override
    public void order(GoodType goodType, int quantity, double orderValue, String productName) {
        if(quantity > 10){                                         // cenata na poruchkata ako kolichestvoto e nad 10
            orderValue = orderValue - (DISCOUNT_10*orderValue);
            orderValue = orderValue + (DELIVERY_PRICE_10*orderValue);
        }else if(quantity > 25){                                   // cenata na poruchkata ako kolichestvoto e nad 25
            orderValue -= DISCOUNT_25*orderValue;
            orderValue += DELIVERY_PRICE_25*orderValue;
        }
        Order order = new Order(goodType,productName, orderValue, counterOrderNumber, quantity);
        customerOrders.add(order);
        System.out.printf("- Order add to customers request. Product: %s - \"%s\", quantity: %d. Order type: %s.\n",
                goodType, productName, quantity, order.getOrderActivity());
        counterOrderNumber++;
    }

    @Override
    public void pay(PayType payType, double amount) {
        System.out.printf("- Thank you for the fast process! You are amazing! Definitely I am going to come again!\n" +
                "Now I want to pay the bill [%.2f] by %s.\n", amount, payType);

    }

    public void checkOrder(){                     // vuzmojnost za klienta da si proveri info za vsichkite poruchki
        for (Order order:customerOrders) {
            order.showOrder();
        }
    }
    
    public void updateOrder(String productName, int quantity){
        //
    }

    public void cancelOrder(int orderNumber){    // da moje da otkazva poruchki po tehniq poreden nomer samo predi da e signed contracta
        boolean hasNumber = false;
        for (Order order:customerOrders) {
            if(order.getNumber()==orderNumber){
                order.setOrderActivity(OrderActivity.CANCELLED);      // setvame aktivnostta na poruchkata da e cancelled
                hasNumber = true;
            }
        }
        if(hasNumber==false){
            System.out.println("No such number!");
        }else{
            System.out.printf("Order number [%d] cancelled.\n", orderNumber);
        }
    }

    @Override
    public void searchableProduct(String name, int quantity, GoodType goodType) {
        System.out.printf("-The customer is looking for %d of %s- \"%s\".\n", quantity, goodType, name);
    }
}
