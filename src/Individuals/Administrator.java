package Individuals;

import Goods.GoodType;
import Orders.Order;
import Orders.Orderable;
import Orders.PayType;

import java.util.ArrayList;

public class Administrator extends Individual implements Orderable, Sellable, Searchable, Payable {

    private double salary;
    private static int counterOrderNumberWarehouse = 1;           // nomera na porednata poruchka
    private ArrayList<Order> adminOrders;

    public Administrator(String name, double salary, PersonalType personalType, String nationality, String personalInfo) {
        super(name, personalType, nationality, personalInfo);
        adminOrders = new ArrayList<>();
        setSalary(salary);
    }

    public Administrator(PersonalType personalType){
        super(personalType);

    }

    public ArrayList<Order> getAdminOrders() {
        return adminOrders;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    // RP rewrite
    @Override
    public void searchProduct(String productName, int quantity, GoodType goodType) {
        System.out.printf("Product to reload - %s, quantity: %d. Contact with %s suppliers.\n",
                productName, quantity, goodType);
    }

    // RP rewrite
    @Override
    public void order(GoodType goodType, int quantity, double orderValue, String productName) {
        Order order = new Order(goodType, productName, orderValue, counterOrderNumberWarehouse, quantity, PersonalType.ADMINISTRATOR);
        adminOrders.add(order);
        System.out.printf("Add order to admin daily orders. Product: \"%s\" [%s], quantity: %d. Total amount: %.2f lv. Order type: %s. \n",
                productName, goodType, quantity, orderValue, order.getOrderActivity());
        counterOrderNumberWarehouse++;
        System.out.println();
    }

    // RP rewrite
    @Override
    public void pay(PayType payType, double amount, PersonalType personalType) {
        System.out.printf("%s has paid the supply order amount of %.2f by %s.\n", personalType, amount, payType);
    }

    // RP rewrite
    @Override
    public void sell(Case casse, double contractAmount) {
        casse.setIncome(casse.getIncome() + contractAmount);             // uvelichavame income na sklada
        System.out.println("Payment accept! Welcome again!");
    }

    @Override
    public String toString(){
        return String.format("[%s] Name: %s, salary: %.2f, info: %s, nationality: %s.",
                getPersonalType(), getName(), getSalary(), getPersonalInfo(), getNationality());
    }
}
