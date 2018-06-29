package Individuals;

import Goods.*;
import Orders.Order;

import java.util.ArrayList;

public class Warehouse {

    private String name;
    private String workTime;
    private double bankAccount;
    private ArrayList<Good> inventory;
    private ArrayList<Alcohol> alcoholInventory;
    private ArrayList<Food> foodsInventory;
    private ArrayList<Domestic> domesticProductsInventory;
    private ArrayList<Order> customerOrders;
    private ArrayList<Customer> customers;

    public Warehouse(String name, String workTime){
        this.name = name;
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }



    public void addAlcohol(String name, double price, double taxes, int quantity, double deliveryPrice,
                           String expDate, String productInfo, int productNumber, int numberOfPurchases,
                           int alcoholContaining, AlcoholType alcoholType , PackageType packageType){
        Alcohol alcohol = new Alcohol(name, price, taxes, quantity, deliveryPrice, expDate, productInfo, productNumber, numberOfPurchases,
                                      alcoholContaining, alcoholType, packageType);
        inventory.add(alcohol);
        alcoholInventory.add(alcohol);
        alcohol.setTotalQuantity(alcohol.getTotalQuantity() + quantity);
    }


    public void addFood(String name, double price, double taxes, int quantity, double deliveryPrice,
                        String expDate, String productInfo, int productNumber, int numberOfPurchases, FoodType foodType){
        Food food = new Food(name, price, taxes, quantity, deliveryPrice, expDate, productInfo, productNumber, numberOfPurchases, foodType);
        inventory.add(food);
        foodsInventory.add(food);
        food.setTotalQuantity(food.getTotalQuantity() + quantity);
    }

    public void addDomesticProducts(String name, double price, double taxes, int quantity, double deliveryPrice,
                                    String expDate, String productInfo, int productNumber, int numberOfPurchases, DomesticType domesticType){
        Domestic domesticP = new Domestic(name, price, taxes, quantity, deliveryPrice, expDate,
                productInfo, productNumber, numberOfPurchases, domesticType);
        inventory.add(domesticP);
        domesticProductsInventory.add(domesticP);
        domesticP.setTotalQuantity(domesticP.getTotalQuantity() + quantity);
    }

    public void order(){

    }
}
