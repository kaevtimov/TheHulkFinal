package Goods;

public class SoftDrink extends Drinks {

    private SoftDrinkType softDrinkType;
    private double deliveryPrice;

    public SoftDrink(String name, int quantity, GoodType goodType, SoftDrinkType softDrinkType){      // construktor za poruchkite
        super(name, quantity, goodType);
        this.softDrinkType = softDrinkType;
    }


    public SoftDrink(String name, double priceWarehouse, int quantity, String expDate, String productInfo,
                     GoodType goodType, SoftDrinkType softDrinkType) {
        super(name, priceWarehouse, quantity, expDate, productInfo, goodType);
        this.softDrinkType = softDrinkType;
        this.deliveryPrice = 0.30;       // na edinica napitka
    }

    public SoftDrinkType getSoftDrinkType() {
        return softDrinkType;
    }

    public void setSoftDrinkType(SoftDrinkType softDrinkType) {
        this.softDrinkType = softDrinkType;
    }

    @Override
    public void showProduct() {
        System.out.printf("This is %s-%s \"%s\", price: %.2f, total amount of quantity: %d and expiration date: %s. %s\n",
                getGoodType(), getSoftDrinkType(), getName(), getPriceWarehouse(), getTotalQuantity(), getExpDate(), getProductInfo());
    }
}
