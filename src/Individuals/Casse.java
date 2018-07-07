package Individuals;

public class Casse {

    private double income;
    private double outcome;
    //private AL<Invoice> invoices;

    public Casse(double income, double outcome) {
        this.income = income;
        this.outcome = outcome;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
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
            System.out.printf("Warehouse BALANCE:[%.2f]! We are very sorry to announce you that our beautiful warehouse must open a bankruptcy proceedings!\n"
                    , outcome-income);
        }else if(outcome==income){
            // ako sme pred falit
            System.out.println("DANGER! Warehouse is nearly to bankrupt!");
        }else{
            // ako sme dobre
            System.out.printf("Warehouse BALANCE:[%.2f]. We are on a right way!\n", income-outcome);
        }
    }

//    public void lookInvoices(){                 // pokazva ni info za vsichki fakturi
//        for (Invoice invoice:invoices) {
//            invoice.showInvoice();
//        }
//    }
}
