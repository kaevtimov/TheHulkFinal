package Goods;

public class Drinks extends Good {



    public Drinks(String name, double priceWarehouse, int quantity,
                  String expDate, String productInfo, GoodType goodType) {
        super(name, priceWarehouse,  quantity,expDate, productInfo, goodType);
    }

    public Drinks(String name, int quantity, GoodType  goodType){        // za poruchki
        super(name, quantity,goodType);
    }

    @Override
    public void showProduct() {
        System.out.printf("This is %s %s, price: %.2f, total amount of quantity: %d and expiration date: %s. %s\n",
                getGoodType(), getName(), getPriceWarehouse(), getTotalQuantity(), getExpDate(), getProductInfo());
    }
}
