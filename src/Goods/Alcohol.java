package Goods;

public class Alcohol extends Drinks{

    private double alcoholContaining;
    private PackageType packageType;
    private AlcoholType alcoholType;
    private double deliveryPrice;

    public Alcohol(String name, int quantity, GoodType goodType, AlcoholType alcoholType){      // construktor za poruchkite
        super(name, quantity, goodType);
        this.alcoholType = alcoholType;
    }

    public Alcohol(String name, double priceWarehouse, int quantity, String expDate, String productInfo, GoodType goodType,
                   double alcoholContaining, AlcoholType alcoholType , PackageType packageType) {
        super(name, priceWarehouse, quantity, expDate, productInfo, goodType);
        this.alcoholContaining = alcoholContaining;
        this.alcoholType = alcoholType;
        this.packageType = packageType;
        this.deliveryPrice = 0.60;         // na edinica alcohol
    }

    public double getAlcoholContaining() {
        return alcoholContaining;
    }

    public void setAlcoholContaining(int alcoholContaining) {
        this.alcoholContaining = alcoholContaining;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public AlcoholType getAlcoholType() {
        return alcoholType;
    }

    public void setAlcoholType(AlcoholType alcoholType) {
        this.alcoholType = alcoholType;
    }

    @Override
    public void showProduct() {
        System.out.printf("This is %s-%s \"%s\", price: %.2f, total amount of quantity: %d and expiration date: %s.\n" +
                        "%s with alcohol contaning: %.2f procent.\n",
                getGoodType(), getAlcoholType(), getName(), getPriceWarehouse(), getTotalQuantity(), getExpDate(), getProductInfo(), getAlcoholContaining());
    }
}
