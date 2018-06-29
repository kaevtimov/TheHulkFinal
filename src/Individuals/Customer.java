package Individuals;

import Goods.GoodType;
import Orders.OrderType;
import Orders.Orderers;
import Orders.PayType;

public class Customer extends Individual implements Orderers, Searching{

    private CustomerType customerType;


    public Customer(String name, double budget, PersonalType personalType, String nationality, String personalInfo, CustomerType customerType) {
        super(name, budget, personalType, nationality, personalInfo);
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


    @Override
    public void makeOrder(String deadline, OrderType orderType) {
        System.out.printf("Order made from [%s] customer: %s, %s. Order type: %s, with deadline till: %s", getCustomerType(), getName(),
                                                                                                   getPersonalType(), orderType, deadline);

    }

    @Override
    public void pay(PayType payType, String bankAccNumber) {
        //
    }

    public void checkOrder(){
        //
    }
    
    public void updateOrder(){
        //
    }

    @Override
    public void searchProduct(int quantity, GoodType goodType) {
        //
    }
}
