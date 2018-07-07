package Goods;

public class Domestic extends Good {

    private DomesticType domesticType;
    private double deliveryPrice;

    public Domestic(String name, int quantity, GoodType goodType, DomesticType domesticType){
        super(name, quantity, goodType);
        this.domesticType = domesticType;
    }

    public Domestic(String name, double priceWarehouse, int quantity,String expDate, String productInfo, DomesticType domesticType, GoodType goodType) {
        super(name, priceWarehouse, quantity, expDate, productInfo, goodType);
        this.domesticType = domesticType;
        this.deliveryPrice = 1;          // na edinica produkt
    }


    public DomesticType getDomesticType() {
        return domesticType;
    }

    public void setDomesticType(DomesticType domesticType) {
        this.domesticType = domesticType;
    }




    @Override
    public void showProduct() {
        System.out.printf("This is %s-%s \"%s\", price: %.2f, total amount of quantity: %d and expiration date: %s. %s\n",
                getGoodType(), getDomesticType(), getName(), getPriceWarehouse(), getTotalQuantity(), getExpDate(), getProductInfo());
    }
}
