package Individuals;

import Orders.OrderType;
import Orders.Orderers;
import Orders.PayType;

public class Administrator extends Individual implements Orderers, Seller, Searching{

    //

    public Administrator(String name, double budget, PersonalType personalType, String nationality, String personalInfo) {
        super(name, budget, personalType, nationality, personalInfo);
    }


    @Override
    public void makeOrder(String deadline, OrderType orderType) {
        System.out.printf("Order made from administrator: %s, %s. Deadline till : %s .", getName(), getPersonalType(), deadline);
    }

    @Override
    public void pay(PayType payType, String bankAccNumber) {
        //
    }

    @Override
    public void sell() {
        //
    }

    public void updateProductInfo(){
        //
    }

    public void removeProduct(){
        //
    }

    public void checkCatalog(){
        //
    }

    @Override
    public void searchProduct() {
        //
    }
}
