package Goods;

public class Food extends Good{

        private FoodType foodType;



    public Food(String name, double price, double taxes, int quantity, double deliveryPrice,
                   String expDate, String productInfo, int productNumber, int numberOfPurchases, FoodType foodType, GoodType goodType) {
        super(name, price, taxes, quantity, deliveryPrice, expDate, productInfo, productNumber, numberOfPurchases, goodType);
        this.foodType = foodType;
    }


    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public void showProduct() {

    }
}
