package Individuals;

public class Supplier extends Individual implements Sellable {

    //

    public Supplier(String name, PersonalType personalType, String nationality, String personalInfo) {
        super(name, personalType, nationality, personalInfo);
    }


    @Override
    public void sell(Casse casse, double contractAmount) {
        //
    }
}
