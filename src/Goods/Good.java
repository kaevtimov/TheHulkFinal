package Goods;

public abstract class Good {
    private String name;
    private double price;
    private GoodType goodType;
    private double taxes;
    private int quantity;
    private int totalQuantity;
    private double deliveryPrice;
    private String expDate;
    private String productInfo;
    private int productNumber;
    private int numberOfPurchases;

    public Good(String name, double price, double taxes, int quantity, double deliveryPrice,
                   String expDate, String productInfo, int productNumber, int numberOfPurchases, GoodType goodType) {
        this.name = name;
        this.price = price + taxes + deliveryPrice;
        this.taxes = taxes;
        this.quantity = quantity;
        this.deliveryPrice = deliveryPrice;
        this.expDate = expDate;
        this.productInfo = productInfo;
        this.productNumber = productNumber;
        this.numberOfPurchases = numberOfPurchases;
        this.goodType = goodType;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }



    public abstract void showCatalog();

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public GoodType getGoodType() {
        return goodType;
    }

    public void setGoodType(GoodType goodType) {
        this.goodType = goodType;
    }
}
