package Goods;

public class Drinks extends Good {



    public Drinks(String name, double price, int taxes, int quantity, double deliveryPrice,
                  String expDate, String productInfo, int productNumber, int numberOfPurchases, GoodType goodType) {
        super(name, price, taxes, quantity, deliveryPrice, expDate, productInfo, productNumber, numberOfPurchases, goodType);
    }

    @Override
    public void showProduct() {
        System.out.printf("This is %s %s, price: %f, total amount of quantity: %d and expiration date: %s.\n %s",
                getGoodType(), getName(), getPrice(), getTotalQuantity(), getExpDate(), getProductInfo());
    }
}
