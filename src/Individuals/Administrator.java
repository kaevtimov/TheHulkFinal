package Individuals;

import Goods.GoodType;
import Orders.Orderable;
import Orders.PayType;

public class Administrator extends Individual implements Orderable, Sellable, Searchable {

    //

    public Administrator(String name,PersonalType personalType, String nationality, String personalInfo) {
        super(name, personalType, nationality, personalInfo);
    }


    @Override
    public void order(GoodType goodType, int quantity, double orderValue, String productName) {
        System.out.printf("Order made from administrator: %s, %s.\n", getName(), getPersonalType()); //da dovursha
    }

    @Override
    public void pay(PayType payType, double amount) {
        //
    }

    @Override
    public void sell(Casse casse, double contractAmount) {
        casse.setIncome(casse.getIncome() + contractAmount);             // uvelichavame income na sklada
        System.out.println("- Payment accept! Congrats! Hope we are going to see you again !");
    }


    public void removeProduct(){       // da premahva produkti s iztekul srok
        //
    }


    @Override
    public void searchableProduct(String name, int quantity, GoodType goodType) {
        //
    }
}
