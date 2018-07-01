package Individuals;

import Goods.GoodType;
import Orders.OrderType;
import Orders.Orderers;
import Orders.PayType;

public class Customer extends Individual implements Orderers, Searching{

    private CustomerType customerType;
    private double budjet;


    public Customer(String name, PersonalType personalType, String nationality, String personalInfo, CustomerType customerType, double budjet) {
        super(name, personalType, nationality, personalInfo);
        this.customerType = customerType;
        this.budjet = budjet;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public double getBudjet() { return budjet; }

    public void setBudjet(double budjet) { this.budjet = budjet; }

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
