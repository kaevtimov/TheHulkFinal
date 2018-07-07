package Goods;

public class Food extends Good{

        private FoodType foodType;
        private double deliveryPrice;

        public Food(String name, int quantity, GoodType goodType, FoodType foodType){
            super(name, quantity, goodType);
            this.foodType = foodType;
        }

        public Food(String name, double priceWarehouse, int quantity, String expDate, String productInfo, FoodType foodType, GoodType goodType) {
        super(name, priceWarehouse, quantity, expDate, productInfo, goodType);
        this.foodType = foodType;
        this.deliveryPrice = 0.40;       // na edinica hrana
    }


    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public void showProduct() {
        System.out.printf("This is %s-%s \"%s\", price: %.2f, total amount of quantity: %d and expiration date: %s. %s\n",
                getGoodType(), getFoodType(), getName(), getPriceWarehouse(), getTotalQuantity(), getExpDate(), getProductInfo());
    }
}
