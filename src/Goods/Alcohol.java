package Goods;

public class Alcohol extends Good{
    //dfghgh

    private int alcoholContaining;
    private PackageType packageType;
    private AlcoholType alcoholType;


    public Alcohol(String name, double price, double taxes, int quantity, double deliveryPrice,
                      String expDate, String productInfo, int productNumber, int numberOfPurchases,
                   int alcoholContaining, AlcoholType alcoholType , PackageType packageType) {
        super(name, price, taxes, quantity, deliveryPrice, expDate, productInfo, productNumber, numberOfPurchases);
        this.alcoholContaining = alcoholContaining;
        this.alcoholType = alcoholType;
        this.packageType = packageType;
    }

    public int getAlcoholContaining() {
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
    public void showCatalog() {

    }
}
