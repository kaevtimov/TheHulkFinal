package Goods;

public class SoftDrink extends Drinks {

    private SoftDrinkType softDrinkType;


    public SoftDrink(String name, double price, int taxes, int quantity, double deliveryPrice, String expDate, String productInfo,
                     int productNumber, int numberOfPurchases, GoodType goodType,
                     SoftDrinkType softDrinkType) {
        super(name, price, taxes,quantity, deliveryPrice, expDate, productInfo, productNumber, numberOfPurchases, goodType);
        this.softDrinkType = softDrinkType;
    }

    public SoftDrinkType getSoftDrinkType() {
        return softDrinkType;
    }

    public void setSoftDrinkType(SoftDrinkType softDrinkType) {
        this.softDrinkType = softDrinkType;
    }

    @Override
    public void showProduct() {
        System.out.printf("This is %s-%s %s, price: %f, total amount of quantity: %d and expiration date: %s.\n %s",
                getGoodType(), getSoftDrinkType(), getName(), getPrice(), getTotalQuantity(), getExpDate(), getProductInfo());
    }
}
