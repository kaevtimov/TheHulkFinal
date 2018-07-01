import Goods.*;
import Individuals.*;
import Orders.OrderActivity;
import Orders.PayType;

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD


        //pravim si sklad, customer, admin, kasa

        Warehouse warehouse = new Warehouse("TheHulk");
        Casse warehouseCasse = new Casse(2500, 0);
        Administrator admin = new Administrator("Stefcho Pavlov", PersonalType.PERSON, "BG", "Employer");
        Customer customer = new Customer("Danny Garcia", 60, PersonalType.PERSON, "BG", "adress", CustomerType.LONGTIME);

        // zarejdame sklada s produkti

        warehouse.addAlcohol("Shumensko", 1.00, 50, "28.05.2018", "By special bulgarian reciepe...",
                GoodType.ALCOHOL, 4.6, AlcoholType.BEER, PackageType.BOTTLED);
        warehouse.addSoftDrink("Pepsi", 1.20, 65, "07.05.2019", "Coca-Cola forever!", GoodType.SOFTDRINK,
                SoftDrinkType.FIZZY);
        warehouse.addFood("potatoe", 2.50, 15, "27.02.2018", "potatoes info", FoodType.BIO, GoodType.FOOD);
        warehouse.addDomesticProducts("table", 25.59, 25, "28.05.2035", "tables info", DomesticType.FURNITURE,
                GoodType.DOMESTIC);

        // proverqvame kakvo ima v sklada
        warehouse.showCatalog();

        // customera otiva i kazva kakvo tursi, a admina proverqva po ime i po nalichnost dali ima v sklada
        warehouse.searchInWarehouse(customer, admin, 25, GoodType.SOFTDRINK, "pepsi");
        warehouse.searchInWarehouse(customer, admin, 25, GoodType.FOOD, "Potatoe");


        // customura zapochva da konstruira poruchki i da podgotvq zaqvka predi da skliuchi dogovora
        warehouse.constructOrder(customer, "pepsi", GoodType.SOFTDRINK, 25);
        warehouse.constructOrder(customer, "Potatoe", GoodType.FOOD, 5);
        System.out.println();
//
//        //proverqva si poruchkite predi da gi zaqvi
        customer.checkOrder();
        System.out.println();
//
//        // customera se otkazva ot poruchkata predi da podpishe, t.e. maha gi ot zaqvkata si
        customer.cancelOrder(1);
        customer.checkOrder();
        System.out.println();
//
//        // finaliziraneto na poruchkite i podpisvaneto na dogovora po napravenata zaqvka!
        warehouse.finalizeOrder(customer, admin, warehouseCasse, PayType.CASH);
        System.out.println(customer.getBudget());
        warehouseCasse.checkBalance();
        warehouse.showOrders();
        warehouse.showCatalog();


=======
        System.out.println();
>>>>>>> 302536758b0bfc6171b586eb7e098e54e2e59ac4
    }
}
