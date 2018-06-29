package Goods;

public class Domestic extends Good {

    private DomesticType domesticType;

    public Domestic(String name, double price, double taxes, int quantity, double deliveryPrice,
                       String expDate, String productInfo, int productNumber, int numberOfPurchases, DomesticType domesticType) {
        super(name, price, taxes, quantity, deliveryPrice, expDate, productInfo, productNumber, numberOfPurchases);
        this.domesticType = domesticType;
    }


    public DomesticType getDomesticType() {
        return domesticType;
    }

    public void setDomesticType(DomesticType domesticType) {
        this.domesticType = domesticType;
    }




    @Override
    public void showCatalog() {

    }
}