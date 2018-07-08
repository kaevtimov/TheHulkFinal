package Individuals;

import Goods.GoodType;
import Orders.Order;
import Orders.OrderActivity;
import Orders.Orderable;
import Orders.PayType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Customer extends Individual implements Orderable, Searchable, Payable {

    private CustomerType customerType;
    private double budget;
    private ArrayList<Order> customerOrders;   // da go napravq na customerRequests

    private static int counterOrderNumberCustomer = 1;           // nomera na porednata poruchka
    private static final double DISCOUNT_10 = 0.1;     // otstupka za nad 10 quantity
    private static final double DISCOUNT_25 = 0.25;     // otstupka za nad 25 quantity
    private static final double DELIVERY_PRICE_10 = 0.05;       // cena za dostavka pri nad 10 quantity
    private static final double DELIVERY_PRICE_25 = 0.1;      // cena za dostavka pri nad 25 quantity


    public Customer(String name, double budget, PersonalType personalType, String nationality, String personalInfo, CustomerType customerType) {
        super(name, personalType, nationality, personalInfo);
        this.customerType = customerType;
        this.customerOrders = new ArrayList<>();
        this.budget = budget;
    }

    public static int getCounterOrderNumberCustomer() {
        return counterOrderNumberCustomer;
    }

    public static void setCounterOrderNumberCustomer(int counterOrderNumberCustomer) {
        Customer.counterOrderNumberCustomer = counterOrderNumberCustomer;
    }


    public double getBudget() {
        return budget;
    }

    void setBudget(double budget) {
        this.budget = budget;
    }

    CustomerType getCustomerType() {
        return customerType;
    }

    ArrayList<Order> getCustomerOrders() {
        return customerOrders;
    }


    @Override
    public void searchProduct(String productName, int quantity, GoodType goodType) {
        System.out.printf("-The customer is looking for %d of %s- \"%s\".\n", quantity, goodType, productName);
    }

    @Override
    public void order(GoodType goodType, int quantity, double orderValue, String productName) {
        if(quantity > 10){                                         // cenata na poruchkata ako kolichestvoto e nad 10
            orderValue = orderValue - (DISCOUNT_10*orderValue);
            orderValue = orderValue + (DELIVERY_PRICE_10*orderValue);
        }else if(quantity > 25){                                   // cenata na poruchkata ako kolichestvoto e nad 25
            orderValue -= DISCOUNT_25*orderValue;
            orderValue += DELIVERY_PRICE_25*orderValue;
        }
        Order order = new Order(goodType,productName, orderValue, counterOrderNumberCustomer, quantity, PersonalType.CUSTOMER);
        customerOrders.add(order);
        System.out.printf("- Request add to customer order. Product: %s - \"%s\", quantity: %d. Order type: %s.\n",
                goodType, productName, quantity, order.getOrderActivity());
        counterOrderNumberCustomer++;
    }


    public void checkRequests(){                     // vuzmojnost za klienta da si proveri info za vsichkite poruchki
        if(!customerOrders.isEmpty()){
            for (Order order:customerOrders) {
                order.showOrder();
            }
        }else{
            System.out.println("No active requests..");
        }
    }

    private void checkDigit(int digit)throws MyCustomException {   // dobaveno
        if(digit < 0){
            throw new MyCustomException("You must enter a valid Integer!!!");   // za chislata pri cancel
        }
    }

    public void cancelRequest(){    // da moje da otkazva poruchki po tehniq poreden nomer samo predi da e signed contracta
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Customer wants to remove a request from list of requests...");
        if(!getCustomerOrders().isEmpty()){         // dobaveno (samo ako ima zaqvki)
            System.out.println("Which request you want to remove from order list?");
            int requestNumber = 0;
            try{
                requestNumber = scanner.nextInt();
                checkDigit(requestNumber);
            }catch (MyCustomException mce){
                System.out.println("Enter a positive number!");
                //scanner.nextLine();
            }catch (InputMismatchException ime){
                System.out.println("Enter a positive number!");
                //scanner.nextLine();
            }
            boolean hasNumber = false;
            for (Order order:customerOrders) {
                if(order.getNumber()==requestNumber){
                    order.setOrderActivity(OrderActivity.CANCELLED);      // setvame aktivnostta na poruchkata da e cancelled
                    counterOrderNumberCustomer--;
                    hasNumber = true;
                }
            }
            if(hasNumber==false){
                System.out.println("No such number!");
                cancelRequest();
            }else{
                System.out.printf("Request number [%d] cancelled.\n", requestNumber);
            }
        }
    }

    @Override
    public void pay(PayType payType, double amount, PersonalType personalType) {
        System.out.printf("-[%s]Thank you for the fast process! You are amazing! Definitely I am going to come again!\n" +
                "Now I want to pay the bill [%.2f] by %s.\n", personalType, amount, payType);

    }

    @Override
    public String toString(){
        return String.format("[%s] Name: %s, budget: %.2f, info: %s, nationality: %s.",
                getPersonalType(), getName(), getBudget(), getPersonalInfo(), getNationality());
    }
}
