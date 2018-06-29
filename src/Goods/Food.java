package Goods;

public class Food extends Good{

        private FoodType foodType;



    public Food(String name, double price, double taxes, int quantity, double deliveryPrice,
                   String expDate, String productInfo, int productNumber, int numberOfPurchases, FoodType foodType) {
        super(name, price, taxes, quantity, deliveryPrice, expDate, productInfo, productNumber, numberOfPurchases);
        this.foodType = foodType;
    }


    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public void showCatalog() {

    }
}
