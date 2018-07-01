package Individuals;

import Goods.*;
import Orders.Order;
import Orders.OrderActivity;
import Orders.PayType;

import java.util.ArrayList;

public class Warehouse {

    private String name;
    private ArrayList<Good> inventory;
    private ArrayList<Alcohol> alcoholInventory;
    private ArrayList<SoftDrink> softDrinkInventory;
    private ArrayList<Food> foodsInventory;
    private ArrayList<Domestic> domesticProductsInventory;
    private ArrayList<Order> warehouseOrders;
    //private ArrayList<Customer> customers;


    public Warehouse(String name){
        this.name = name;
        this.inventory = new ArrayList<>();
        this.alcoholInventory = new ArrayList<>();
        this.softDrinkInventory = new ArrayList<>();
        this.foodsInventory = new ArrayList<>();
        this.domesticProductsInventory = new ArrayList<>();
        this.warehouseOrders = new ArrayList<>();
        //this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }




    public void showCatalog(){              // pokazva ni katalog ot nalichnite produkti v sklada
        for (Good good:inventory) {
            good.showProduct();
            System.out.println();
        }
    }

    public void showOrders(){                   // pokazva ni poruchkite v sklada i tqhnata aktivnost
        for (Order order:warehouseOrders) {
            order.showOrder();
        }
    }


    public void addAlcohol(String name, double priceWarehouse, int quantity, String expDate, String productInfo, GoodType goodType,
                           double alcoholContaining, AlcoholType alcoholType , PackageType packageType){
        Alcohol alcohol = new Alcohol(name, priceWarehouse, quantity,expDate, productInfo,
                goodType, alcoholContaining, alcoholType, packageType);
        inventory.add(alcohol);
        alcoholInventory.add(alcohol);
        alcohol.setTotalQuantity(alcohol.getTotalQuantity() + quantity);
    }

    public void addSoftDrink(String name, double priceWarehouse, int quantity, String expDate, String productInfo,
                             GoodType goodType, SoftDrinkType softDrinkType){
        SoftDrink softDrink = new SoftDrink(name, priceWarehouse, quantity,expDate, productInfo, goodType,softDrinkType);
        inventory.add(softDrink);
        softDrinkInventory.add(softDrink);
        softDrink.setTotalQuantity(softDrink.getTotalQuantity() + quantity);
    }


    public void addFood(String name, double priceWarehouse, int quantity,String expDate, String productInfo, FoodType foodType, GoodType goodType){
        Food food = new Food(name, priceWarehouse, quantity, expDate, productInfo, foodType, goodType);
        inventory.add(food);
        foodsInventory.add(food);
        food.setTotalQuantity(food.getTotalQuantity() + quantity);
    }

    public void addDomesticProducts(String name, double priceWarehouse, int quantity,
                                    String expDate, String productInfo, DomesticType domesticType, GoodType goodType){
        Domestic domesticP = new Domestic(name, priceWarehouse, quantity, expDate, productInfo, domesticType, goodType);
        inventory.add(domesticP);
        domesticProductsInventory.add(domesticP);
        domesticP.setTotalQuantity(domesticP.getTotalQuantity() + quantity);
    }


    public void searchInWarehouse(Customer customer, Administrator admin, int quantity, GoodType goodType, String productName){
        customer.searchableProduct(productName, quantity, goodType);  //customera kazva turseniq produkt
                 // proverka dali go imame nalichno
        for (Good good:inventory) {
            if(good.getTotalQuantity()>=quantity && good.getName().equalsIgnoreCase(productName) && good.getGoodType()==goodType){
                System.out.printf("- You are a lucky guy! Yes, we have \"%s\" %s available.\n",productName, goodType);
                //constructOrder(); !!!!!!!!!!
                break;
            }else if(good.getName().equalsIgnoreCase(productName) && good.getGoodType()==goodType){
                System.out.printf("- Sorry! We have only %s quantity of %s available.\n" +
                        "Please try again in some time! Have a nice day!\n",good.getTotalQuantity(), productName);
            }else if(goodType==GoodType.OTHER){
                System.out.println("Sorry! This product does not appear in our warehouse catalog.");
            }
        }
    }


    public void constructOrder(Customer customer, String productName, GoodType goodType, int quantity){
        double orderValue = 0;
        for (Good good:inventory) {
            if(good.getName().equalsIgnoreCase(productName) && good.getTotalQuantity() >= quantity) {
                orderValue = good.getPriceWarehouse() * quantity;
                customer.order(goodType, quantity, orderValue, productName);
                break;
            }
        }
    }


        //warehouse.constructOrder();
        //customer.cancelOrder();   predi da e finaliziral i podpisal


    public void finalizeOrder(Customer customer, Administrator admin, Casse casse,PayType payType){
        System.out.printf("- %s wants to proceed and sign a Order contract for the orders!\n", customer.getName());

        // tuk dobavqme poruchkite na edin klient v obshtite poruchki na sklada
        double contractAmount = 0;       //tova e cenata na celiq dogovor koqto trqbva da opredelim

        for (int i = 0; i < customer.getCustomerOrders().size(); i++) {   // slujat za namalqvane na stokata v sklada sled poruchkata
            for (int j = 0; j < inventory.size(); j++) {
                if(customer.getCustomerOrders().get(i).getOrderActivity()==OrderActivity.ACTIVE
                        && customer.getCustomerOrders().get(i).getProductName().equalsIgnoreCase(inventory.get(j).getName())){
                    contractAmount += customer.getCustomerOrders().get(i).getTotalAmount();   // presmqtame cenata na vsichki poruchki po dogovora
                    customer.getCustomerOrders().get(i).setOrderActivity(OrderActivity.FINISHED);
                    inventory.get(j).setTotalQuantity(inventory.get(j).getTotalQuantity() -
                            customer.getCustomerOrders().get(i).getQuantity());    // namalqvame obshtoto kolichestvo v sklada na poruchaniq produkt
                    warehouseOrders.add(customer.getCustomerOrders().get(i));        // dobavqme poruchkite v tezi na sklada samo ako ne sa cancelled
                }
            }
        }

        // proverka dali budgeta na klienta e dostatuchen da plati poruchkata
        if(customer.getBudget() >= contractAmount){
            // ako budgeta e dostatuchen
            System.out.printf("- The order is processed! Order made from [%s] customer: %s, %s.\n" +
                    "- Now the contract is signed, the invoice was made and you must pay, total amount (%.2f) lv, please.\n", customer.getCustomerType(),
                    customer.getName(), customer.getPersonalType(), contractAmount);

            // customera trqbva da plati
            customer.pay(payType, contractAmount);
            customer.setBudget(customer.getBudget() - contractAmount);       // namalqvame budgeta na customera
            admin.sell(casse, contractAmount);  //administratora prodava i uvelichava income na sklada
        }else{   // ako budgeta ne dostiga
            System.out.printf("- The order is processed! Sorry , but you don't have enough budget to finish the order! Deficit [%.2f]\n",
                    contractAmount - customer.getBudget());
        }
    }


    public void searchInProducer(){

    }

    public void orderInProducer(){

    }
}
