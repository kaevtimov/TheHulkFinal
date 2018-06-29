package Individuals;

public class Producer extends Individual implements Seller{

    //

    public Producer(String name, double budget, PersonalType personalType, String nationality, String personalInfo) {
        super(name, budget, personalType, nationality, personalInfo);
    }


    @Override
    public void sell() {
        //
    }
}
