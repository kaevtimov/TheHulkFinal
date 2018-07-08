package Individuals;

import Goods.*;
import Orders.Order;
import Orders.OrderActivity;
import Orders.PayType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Warehouse {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private ArrayList<Good> inventory;
    private ArrayList<Alcohol> alcoholInventory;         
    private ArrayList<SoftDrink> softDrinkInventory;      
    private ArrayList<Food> foodsInventory;           
    private ArrayList<Domestic> domesticProductsInventory;  
    private ArrayList<Order> warehouseOrders;
    private ArrayList<Good> toBeReload;               // tova e AL za kakvo da se porucha ot suppliera


    public Warehouse(String name){
        this.name = name;
        this.inventory = new ArrayList<>();
        this.alcoholInventory = new ArrayList<>();
        this.softDrinkInventory = new ArrayList<>();
        this.foodsInventory = new ArrayList<>();
        this.domesticProductsInventory = new ArrayList<>();
        this.warehouseOrders = new ArrayList<>();
        this.toBeReload = new ArrayList<>();
    }

    public String getName() {
        return name;
    }




    // RP prenapisan e, za da se pokazvat vsi4ki poleta na produktite
    public void showCatalog(){              // pokazva ni katalog ot nalichnite produkti v sklada
        System.out.println("-----------------------------");
        System.out.println("WAREHOUSE PRODUCT CATALOGUE: ");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();
        for (Good good: alcoholInventory) {
            good.showProduct();
        }
        for (Good good: softDrinkInventory) {
            good.showProduct();
        }
        for (Good good: foodsInventory) {
            good.showProduct();
        }
        for (Good good: domesticProductsInventory) {
            good.showProduct();
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public void toBeReload(){                 // proverka na spisuka s produkti za zarejdane
        for (Good good:toBeReload) {
            System.out.printf("Product: %s - %s with quantity: %d, must be reloaded.\n", good.getName(), good.getGoodType(), good.getTotalQuantity());
        }
    }

    public void showOrders(){                   // pokazva ni poruchkite v sklada i tqhnata aktivnost
        for (Order order:warehouseOrders) {
            order.showOrder();
        }  // moje tuk exception
    }

    // addvame produktite puvo v cataloga s quantity 0, i posle gi zarejdame ot proizvoditelite
    void addAlcohol(String name, double priceWarehouse, int totalQuantity, GoodType goodType,
                    double alcoholContaining, AlcoholType alcoholType , PackageType packageType){
        Alcohol alcohol = new Alcohol(name, priceWarehouse, totalQuantity, goodType, alcoholContaining, alcoholType, packageType);
        inventory.add(alcohol);
        alcoholInventory.add(alcohol);
        //toBeReload.add(alcohol);        // da gi vkarame napravo za zarejdane zashtoto nali sa s quantity 0
    }

    void addSoftDrink(String name, double priceWarehouse, int totalQuantity, GoodType goodType, SoftDrinkType softDrinkType,
                      PackageType packageType){
        SoftDrink softDrink = new SoftDrink(name, priceWarehouse, totalQuantity, goodType, softDrinkType, packageType);
        inventory.add(softDrink);
        softDrinkInventory.add(softDrink);
    }


    void addFood(String name, double priceWarehouse, int totalQuantity, GoodType goodType, FoodType foodType, PackageType packageType){
        Food food = new Food(name, priceWarehouse, totalQuantity, goodType, foodType, packageType);
        inventory.add(food);
        foodsInventory.add(food);
    }

    void addDomesticProducts(String name, double priceWarehouse, int totalQuantity, GoodType goodType, DomesticType domesticType){
        Domestic domesticP = new Domestic(name, priceWarehouse, totalQuantity, goodType, domesticType);
        inventory.add(domesticP);
        domesticProductsInventory.add(domesticP);
    }


    private void checkDigit(int digit)throws MyCustomException {  
        if(digit <= 0){
            throw new MyCustomException("You must enter a integer bigger than 0!!!");   // za chislata s enumeraciite
        if(digit < 0){
            throw new MyCustomException("You must enter a valid Integer!!!");   // za chislata s enumeraciite
        }
    }


    public void searchInWarehouse(Customer customer, Administrator admin, Case casse) throws MyCustomException {     //throws MyCustomException
        // dobavil sum custom exception ako se vuvedut otricatelni chisla
        System.out.printf("Hello, %s!\n", customer.getName());
        while (true) {  
            //избор на типа продукт

            GoodType goodType = GoodType.valueOf(choosingGoodType());

            //избор на марка на продукт

            String productName = "";
            switch (goodType) {
                case ALCOHOL:
                    productName = choiceOfAlcoholInventory();
                    break;
                case FOOD:
                    productName = choiceOfFoodInventory();
                    break;
                case DOMESTIC:
                    productName = choiceOfDomesticInventory();
                    break;
                case SOFTDRINK:
                    productName = choiceOfSoftDrinkInventory();
                    break;
                case OTHER:
                    System.out.println("We do not offer other products.");
                    productName = "OTHER";
                    break;
                default:
                    break;
            }

            if (productName.equals("OTHER") || productName.equals("")) {
                System.out.println("The product doesn't appear in our catalog. Try again!");
                continue;
            }

            scanner.nextLine();

            int quantity = 0;
            boolean inputCorrectQuantity = false;
            while(!inputCorrectQuantity) {               // dokato ne vuvede INTEGER go karame da pishe   :D
                try{                          //MyCustomException
                    System.out.println("Now please enter the desired quantity:");
                    quantity = scanner.nextInt();
                    checkDigit(quantity);
                    break;
                }
                catch(InputMismatchException ime){
                    System.out.println("You must enter a integer!");
                    scanner.nextLine();
                }
                catch (MyCustomException mce) {             // dobaven custom exception za quantity, ako se vuvede otricatelno chislo
                    System.out.println("You must enter a integer bigger than 0!!!");
                    System.out.println("You must enter a positive Integer!!!");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            customer.searchProduct(productName, quantity, goodType);  //customera kazva turseniq produkt
            // proverka dali go imame nalichno
            boolean contains = false;
            for (Good good:inventory) {
                if(good.getTotalQuantity()>=quantity && good.getName().equalsIgnoreCase(productName) && good.getGoodType()==goodType){
                    contains = true;
                    System.out.printf("- You are a lucky guy! Yes, we have \"%s\" %s available.\n",productName, goodType);
                    System.out.println("Do you want to put it as a request? (Yes/No)");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes")){
                        constructCustomerRequest(customer, productName, goodType, quantity);
                        break;
                    }
                }else if(good.getName().equalsIgnoreCase(productName) && good.getGoodType()==goodType && quantity > good.getTotalQuantity()){  //promeneno
                    contains = true;
                    System.out.printf("Sorry, available quantity %s of %s (%s).\n" +
                                    "Do you want to order less quantity which is under %d, and then put it as a request? (Yes/No)\n"
                            ,good.getTotalQuantity(), productName, goodType, good.getTotalQuantity());
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes")){
                        System.out.printf("Please enter new quantity under %d.\n",good.getTotalQuantity());
                        // i tuk trqbva da se hvane otricatelen exception
                        int newQuantity = 0;                              
                        boolean inputNewQuantity = false;
                        while(!inputCorrectQuantity) {               // dokato ne vuvede INTEGER go karame da pishe  
                            try{                          //MyCustomException
                                System.out.println("Now please enter the desired quantity:");
                                newQuantity = scanner.nextInt();
                                if(newQuantity == 0){                                 // ako vuvede chislo ne ot 1-4
                                    System.out.println("Enter a number that is bigger than 0!!");      // dobaveno sega
                                }
                                checkDigit(newQuantity);
                                break;
                            }
                            catch(InputMismatchException ime){
                                System.out.println("You must enter a integer!");
                                scanner.nextLine();
                            }
                            catch (MyCustomException mce) {             // dobaven custom exception za quantity, ako se vuvede otricatelno chislo
                                System.out.println("You must enter a integer bigger than 0!!!");
                                System.out.println("You must enter a positive Integer!!!");
                                scanner.nextLine();
                            }
                        }
                        System.out.printf("Customer updated desired quantity: %d.\n", newQuantity);
                        constructCustomerRequest(customer, productName, goodType, newQuantity);
                        scanner.nextLine();
                        break;
                    }                                                                                                                 // do tuk promeneno
                }
            }
            if(contains==false){ System.out.println("The product doesn't appear in our catalog!");}// tova izpisva ako jelaniq produkt go nqmame v kataloga
            System.out.println("Would you like to continue? Y/N");  // dobaveno!
            String answerCustomer = scanner.nextLine();
            if (answerCustomer.equalsIgnoreCase("y")
                    || answerCustomer.equalsIgnoreCase("yes")) {
                continue;
            } else {
                break;
            }
        }


        int numberOfCustomerRequests = customer.getCustomerOrders().size();  //kolko requesti ima
        do {
            System.out.println("Do you want to check your requests? Y/N");        // dobaveno
            String answerCustomer = scanner.nextLine();
            if (answerCustomer.equalsIgnoreCase("y")
                    || answerCustomer.equalsIgnoreCase("yes")) {
                customer.checkRequests();
            } else {
                break;
            }

            if(!customer.getCustomerOrders().isEmpty()){                                  // dobaveno sega
                if(numberOfCustomerRequests > 0){
                    System.out.println("Do you want to cancel any request Yes/No?");        // dobaveno  samo ako ima nqkakvi zaqvki
                    String answerCancel = scanner.nextLine();
                    if(answerCancel.equalsIgnoreCase("yes") || answerCancel.equalsIgnoreCase("y")){
                        customer.cancelRequest();
                        numberOfCustomerRequests--;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
        } while (true);


        if(!customer.getCustomerOrders().isEmpty() && numberOfCustomerRequests != 0){  //dobaveno ako ima requesti i ako ima samo ako sa ACTIVE
            boolean canSign = false;
            for (Order order:customer.getCustomerOrders()) {                // dobaveno inache shte podpishe dogovor za 0 produkti!
                if(order.getOrderActivity()==OrderActivity.ACTIVE){
                    canSign = true;
                }
            }
            if(canSign==true){
                System.out.println("Do you want to sign contract now Yes/No?");       
                String answerSign = scanner.nextLine();
                if(answerSign.equalsIgnoreCase("yes")){
                    finalizeOrder(customer,admin,casse);
                }else{
                    System.out.println("Customer refuses to sign.. and he walks away...");  
                }
            }else{
                System.out.println("You have no requests to sign a contract. Have a nice day!");
            }
        }else{
            System.out.println("Customer has no requests to order.");
        }
    }


    public String choosingGoodType(){
        String choice = "";
        boolean isCorrectNumber = false;
        int i = 1;
        System.out.println("Which is the good type of your desired product?");
        for (GoodType type :
                GoodType.values()) {
            System.out.println(i + " - " + type);
            i++;
        }

        System.out.println("The system expects your choice");
        //метод за прихващане на изключения ако въведеният избор не e число
        int n = 0;
        while (!isCorrectNumber) {
            try{                          //MyCustomException
                n = scanner.nextInt();
                if(n == 0 || n > 5){                                 // ako vuvede chislo ne ot 1-4
                    System.out.println("Enter a number from 1-5!!");   
                }
                checkDigit(n);
                // избор на тип стока
                switch (n) {
                    case 1:
                        choice = "ALCOHOL";
                        isCorrectNumber = true;
                        break;
                    case 2:
                        choice = "FOOD";
                        isCorrectNumber = true;
                        break;
                    case 3:
                        choice = "DOMESTIC";
                        isCorrectNumber = true;
                        break;
                    case 4:
                        choice = "SOFTDRINK";
                        isCorrectNumber = true;
                        break;
                    case 5:
                        choice = "OTHER";
                        isCorrectNumber = true;
                        break;
                }
            }
            catch(InputMismatchException ime){
                System.out.println("You must enter a integer!");
                scanner.nextLine();
            } catch (MyCustomException mce) {             // dobaven custom exception za quantity, ako se vuvede otricatelno chislo
                System.out.println("You must enter a positive Integer!!!");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public String choiceOfAlcoholInventory() { // показва марките алкохол и избор на марка
        System.out.println();
        System.out.println("Please enter product name:");
        String choice = "";
        int i = 1;
        for (Alcohol alcohol :
                alcoholInventory) {
            System.out.println(i + " - " + alcohol.getName());
            i++;
        }

        System.out.println("The system expects your choice");  
        int n = 0;

        do { //проверка числото да е в обхвата на колекцията Алкохол
            try{
                n = scanner.nextInt();
                checkDigit(n);
                if ((0 < n) && (n < i)) {
                    break;
                } else {
                    System.out.println();
                    System.out.printf("Enter a number from 1- %d!!", i-1);   
                    System.out.printf("Enter a number from 1 - %d!!", i - 1);    
                }
            }catch(InputMismatchException ime){
                System.out.println("You must enter a integer!");
                scanner.nextLine();
            } catch (MyCustomException mce) {             // dobaven ako se vuvede otricatelno chislo
                System.out.println("You must enter a positive Integer!!!");
                scanner.nextLine();
            }
        } while (true);

        int nameNumber = 1;
        for (Alcohol alcohol :
                alcoholInventory) {
            if (nameNumber == n) {
                choice = alcohol.getName();
                break;
            }
            nameNumber++;
        }
        return choice;
    }



    public String choiceOfFoodInventory() { // показва марките храни и избор на марка
        System.out.println();
        System.out.println("Please enter product name:");
        String choice = "";
        int i = 1;
        for (Food food :
                foodsInventory) {
            System.out.println(i + " - " + food.getName());
            i++;
        }

        System.out.println("The system expects your choice");
        int n = 0; //метод за прихващане на изключения ако въведеният избор не e число

        do { //проверка числото да е в обхвата на колекцията за храни
            try{
                n = scanner.nextInt();
                checkDigit(n);
                if ((0 < n) && (n < i)) {
                    break;
                } else {
                    System.out.println();
                    System.out.printf("Enter a number from 1- %d!!", i-1);     
                    System.out.printf("Enter a number from 1- %d!!", i);    
                }
            }catch(InputMismatchException ime){
                System.out.println("You must enter a integer!");
                scanner.nextLine();
            } catch (MyCustomException mce) {             // dobaven ako se vuvede otricatelno chislo
                System.out.println("You must enter a positive Integer!!!");
                scanner.nextLine();
            }
        } while (true);

        int nameNumber = 1;
        for (Food food :
                foodsInventory) {
            if (nameNumber == n) {
                choice = food.getName();
                break;
            }
            nameNumber++;
        }
        return choice;
    }

    public String choiceOfSoftDrinkInventory() { // показва марките безалкохолни и избор на марка
        System.out.println();
        System.out.println("Please enter product name:");
        String choice = "";
        int i = 1;
        for (SoftDrink drink :
                softDrinkInventory) {
            System.out.println(i + " - " + drink.getName());
            i++;
        }

        System.out.println("The system expects your choice");
        int n = 0; //метод за прихващане на изключения ако въведеният избор не e число

        do { //проверка числото да е в обхвата на колекцията
            try{
                n = scanner.nextInt();
                checkDigit(n);
                if ((0 < n) && (n < i)) {
                    break;
                } else {
                    System.out.println();
                    System.out.printf("Enter a number from 1- %d!!", i-1);  
                    System.out.printf("Enter a number from 1- %d!!", i);      
                }
            }catch(InputMismatchException ime){
                System.out.println("You must enter a integer!");
                scanner.nextLine();
            } catch (MyCustomException mce) {             // dobaven ako se vuvede otricatelno chislo
                System.out.println("You must enter a positive Integer!!!");
                scanner.nextLine();
            }
        } while (true);

        int nameNumber = 1;
        for (SoftDrink drink :
                softDrinkInventory) {
            if (nameNumber == n) {
                choice = drink.getName();
                break;
            }
            nameNumber++;
        }
        return choice;
    }

    public String choiceOfDomesticInventory() { // показва марките избор на марка
        System.out.println();
        System.out.println("Please enter product name:");
        String choice = "";
        int i = 1;
        for (Domestic domestic :
                domesticProductsInventory) {
            System.out.println(i + " - " + domestic.getName());
            i++;
        }

        System.out.println("The system expects your choice");
        int n = 0; //метод за прихващане на изключения ако въведеният избор не e число

        do { //проверка числото да е в обхвата на колекцията
            try{
                n = scanner.nextInt();
                checkDigit(n);
                if ((0 < n) && (n < i)) {
                    break;
                } else {
                    System.out.println();
                    System.out.printf("Enter a number from 1- %d!!", i-1);     
                    System.out.printf("Enter a number from 1- %d!!", i);    
                }
            }catch(InputMismatchException ime){
                System.out.println("You must enter a integer!");
                scanner.nextLine();
            } catch (MyCustomException mce) {             // dobaven ako se vuvede otricatelno chislo
                System.out.println("You must enter a positive Integer!!!");
                scanner.nextLine();
            }
        } while (true);

        int nameNumber = 1;
        for (Domestic domestic :
                domesticProductsInventory) {
            if (nameNumber == n) {
                choice = domestic.getName();
                break;
            }
            nameNumber++;
        }
        return choice;
    }





    public void constructCustomerRequest(Customer customer, String productName, GoodType goodType, int quantity){ // sled kato razbira che e nalichen, podgotvqt zaqvkata
        double orderValue = 0;
        for (Good good:inventory) {
            if(good.getName().equalsIgnoreCase(productName) && good.getTotalQuantity() >= quantity) {
                orderValue = good.getPriceWarehouse() * quantity;
                customer.order(goodType, quantity, orderValue, productName);
                break;
            }
        }
    }




    public void finalizeOrder(Customer customer, Administrator admin, Case aCase)  {
        System.out.printf("- %s wants to proceed and sign a Order contract for the requests!\n", customer.getName());
        // tuk dobavqme poruchkite na edin klient v obshtite poruchki na sklada
        double contractAmount = 0;       //tova e cenata na celiq dogovor koqto trqbva da opredelim
        for (int i = 0; i < customer.getCustomerOrders().size(); i++) {   // slujat za namalqvane na stokata v sklada sled poruchkata
            for (Good good : inventory) {
                if (customer.getCustomerOrders().get(i).getOrderActivity() == OrderActivity.ACTIVE
                        && customer.getCustomerOrders().get(i).getProductName().equalsIgnoreCase(good.getName())) {
                    contractAmount += customer.getCustomerOrders().get(i).getTotalAmount();   // presmqtame cenata na vsichki poruchki po dogovora
                    customer.getCustomerOrders().get(i).setOrderActivity(OrderActivity.FINISHED);
                    good.setTotalQuantity(good.getTotalQuantity() -
                            customer.getCustomerOrders().get(i).getQuantity());    // namalqvame obshtoto kolichestvo v sklada na poruchaniq produkt
                    warehouseOrders.add(customer.getCustomerOrders().get(i));        // dobavqme poruchkite v tezi na sklada samo ako ne sa cancelled
                }
            }
        }// proverka dali budgeta na klienta e dostatuchen da plati poruchkata
        if(customer.getBudget() >= contractAmount){
            // ako budgeta e dostatuchen
            System.out.printf("- The order is processed! Order made from [%s] customer: %s, %s.\n" +
                            "- Now the contract is signed, the invoice was made and you must pay, total amount (%.2f) lv, please.\n", customer.getCustomerType(),
                    customer.getName(), customer.getPersonalType(), contractAmount);
            System.out.println("How do you prefer to pay?");
            int i = 1;
            for (PayType type :
                    PayType.values()) {
                System.out.println(i + " - " + type);
                i++;
            }
            System.out.println("The system expects your choice");
            int choiceOfPayType = 0;
            PayType payType = null;
            boolean inputCorrect = false;
            while(!inputCorrect){               // dokato ne vuvede INTEGER go karame da pishe 
                try{            // mycustomexception
                    choiceOfPayType = scanner.nextInt();
                    if(choiceOfPayType > 3 || choiceOfPayType==0){
                        System.out.println("Enter a correct number!");
                    }
                    checkDigit(choiceOfPayType);  
                    switch (choiceOfPayType) {
                        case 1: payType = PayType.CREDIT;
                            inputCorrect=true;
                            break;
                        case 2: payType = PayType.DEBITCARD;
                            inputCorrect=true;
                            break;
                        case 3: payType = PayType.CASH;
                            inputCorrect=true;
                            break;
                        default:
                            break;
                    }
                }catch(InputMismatchException ime){
                    System.out.println("You must enter a integer!");
                    scanner.nextLine();
                }
                catch(MyCustomException mce){                                   
                    System.out.println("Enter a positive number!");
                    scanner.nextLine();
                }
            }
            customer.pay(payType, contractAmount, customer.getPersonalType());
            customer.setBudget(customer.getBudget() - contractAmount);       // namalqvame budgeta na customera
            admin.sell(aCase, contractAmount);  //administratora prodava i uvelichava income na sklada
        }else{   // ako budgeta ne dostiga
            System.out.printf("- The order is processed! Sorry , but you don't have enough budget to finish the order! Deficit [%.2f]\n",
                    contractAmount - customer.getBudget());
        }
        customer.getCustomerOrders().clear();  // izchistvame spisuka s requesti na customera zashtoto veche e finalizirano vsichko
        customer.setCounterOrderNumberCustomer(1);
    }


    //promeneno kato sum vkaral metod contact tuk
    public void checkProductsQuantity(Administrator admin, Supplier supplier, Case casse){     // tuk proverqvame stokite za nalichnost i ni kazva koe trqbva
        boolean isFull = true;
        for (Good good:inventory) {     // ako trqbva da se zaredi
            if(good.getTotalQuantity() < 50){  // ako e pod 50 i toBeReload ne sudurja veche sushtiq produkt za zarejdane
                if(!toBeReload.contains(good)){
                    isFull=false;
                    toBeReload.add(good);
                    System.out.printf("Product: %s - %s with quantity: %d, must be reloaded.\n", good.getName(), good.getGoodType(), good.getTotalQuantity());
                }
            }
        }
        if(isFull){   // ako vsichko e pulno
            System.out.println("Every product has the normal amount of quantity!");
        }else{
            System.out.println("Do you want to proceed to reloading? (Yes/No)");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("yes")){
                contactProducers(admin, supplier, casse);
            }else{
                System.out.println("No reload");
            }
        }
    }

    public void contactProducers(Administrator admin, Supplier supplier, Case casse) {
        double total = 0;
        System.out.printf("Admin %s processing contact with producers...\n", admin.getName());
        for (Good good : toBeReload) {
            admin.searchProduct(good.getName(), 100, good.getGoodType());  //vinagi zarejdame produkta sus 100
            double orderValue = good.getPriceProducer() * 100;
            total+=orderValue;  // tuk presmqtame totala na zarejdaneto
            admin.order(good.getGoodType(), 100, orderValue, good.getName()); // admina poruchva po edinichno zashtoto vseki supplier e razlichen
            admin.pay(PayType.CREDIT, orderValue, admin.getPersonalType());                  // administratora plashta poruchkata
            supplier.sell(casse, orderValue);                          // supliera prodava, i ednivremenno s tova se uvelichava outcome na sklada
            // trqbva da uvelichim kolichestvoto da poruchanite produkti v sklada
            if(inventory.contains(good)){                         // tuk uvelichavame kolichestvoto na produkta v sklada
                good.setTotalQuantity(good.getTotalQuantity()+100);
            }
        }
        toBeReload.clear(); // clearvame zashtoto sme gi zaredili veche
        for (Order order : admin.getAdminOrders()) {               // tuk dobavqme dnevnite zarejdaniq na admina kum obshtite na sklada
            order.setOrderActivity(OrderActivity.FINISHED);
            warehouseOrders.add(order);
        }
        System.out.printf("Total amount of reloading: [%.2f]\n", total);
    }
}

