package Individuals;

public class Case {

    private double income;
    private double outcome;

    public Case(double income, double outcome) {
        this.income = income;
        this.outcome = outcome;
    }


    double getIncome() {
        return income;
    }

    void setIncome(double income) {
        this.income = income;
    }

    public double getOutcome() {
        return outcome;
    }

    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }

    public void checkBalance(){      // proverqvame kak e balansa na sklada
        if(outcome > income){
            // ako sme vuv falit
            System.out.printf("[DANGER!] Warehouse BALANCE:[%.2f]! \n"
                    , income - outcome);
        }else if(outcome==income){
            // ako sme pred falit
            System.out.println("[DANGER!] Warehouse is nearly to bankrupt!");
        }else{
            // ako sme dobre
            System.out.printf("Warehouse BALANCE:[%.2f]. We are on a right way!\n", income-outcome);
        }
    }

    public static class MyCustomException extends Exception{

        public MyCustomException(String message){
            super(message);
        }
    }
}
