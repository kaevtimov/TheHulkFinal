package Individuals;

public class Supplier extends Stuff implements Seller{


    public Supplier(String name, PersonalType personalType, String nationality, String personalInfo, double salary, double bankAccount) {
        super(name, personalType, nationality, personalInfo, salary, bankAccount);
    }

    //




    @Override
    public void sell() {
        //
    }
}
