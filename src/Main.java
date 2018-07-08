import Goods.*;
import Individuals.*;
import Orders.PayType;

public class Main {

    public static void main(String[] args) throws MyCustomException {


        //pravim si BOSS, sklad, case, admins, customer, supplier

        Boss boss = new Boss("Ivan Ivanov", PersonalType.BOSS, "BG", "info");
        Administrator admin = new Administrator("Stefcho", 2500, PersonalType.ADMINISTRATOR, "BG", "info");
        Customer customer = new Customer("Pencho Tenev", 600, PersonalType.CUSTOMER, "BG", "adress", CustomerType.LONGTIME);
        Customer customer2 = new Customer("Harry Kane", 6000, PersonalType.CUSTOMER, "BG", "adress", CustomerType.PARTTIME);
        Supplier supplier = new Supplier(PersonalType.SUPPLIER);

        Warehouse warehouse = new Warehouse("TheHulk");            // KE
        Case warehouseCase = new Case(2500000,0);        // KE

        boss.investWarehouseAndCase();

//        System.out.println(customer);
//        System.out.println(customer2);
//        System.out.println(admin);
//        System.out.println(boss);


        warehouseCase.checkBalance();

        //podrejdame kataloga
        boss.setUpCatalog(warehouse);


        // zarejdame sklada s produkti
        warehouse.checkProductsQuantity(admin, supplier, warehouseCase);
        System.out.println();
//        warehouse.checkProductsQuantity(admin, supplier, warehouseCase);
//        System.out.println();
        warehouseCase.checkBalance();
//        System.out.println();
        //System.out.println(warehouseCase.getOutcome());



        // customera otiva i kazva kakvo tursi, a admina proverqva po ime i po nalichnost dali ima v sklada
        // posle customera constructCustomerRequests();   kato si adva v zaqvkata
        warehouse.searchInWarehouse(customer, admin, warehouseCase);     // chisloto  e za broq na poruchkite
        System.out.println();
//        warehouse.searchInWarehouse(customer2, admin, warehouseCase);   // probvame s vtori customer
//        System.out.println();


        // sled podpisvaneto na dogovora proverqvame
//        System.out.println(customer.getBudget());
//        System.out.println(customer2.getBudget());
//        warehouseCase.checkBalance();
//        warehouse.showOrders();
//        warehouse.showCatalog();


    }
}
