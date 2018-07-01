package Individuals;

import Goods.GoodType;
import Orders.OrderType;
import Orders.Orderers;
import Orders.PayType;

public class Administrator extends Stuff implements Orderers, Seller, Searching{

    public Administrator(String name, PersonalType personalType, String nationality, String personalInfo, double salary, double bankAccount) {
        super(name, personalType, nationality, personalInfo, salary, bankAccount);
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

//    @Override
//    public void searchProduct() {
//        //
//    }

    @Override
    public void searchProduct(int quantity, GoodType goodType) {

    }
}
