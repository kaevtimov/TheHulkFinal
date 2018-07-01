package Goods;

public abstract class Good {
    private String name;
    private double priceProducer;
    private double priceWarehouse;
    private GoodType goodType;
    private int quantity;
    private int totalQuantity;
    private String expDate;
    private String productInfo;
    private int productNumber;
    private double deliveryPrice;

    public Good(String name, double priceWarehouse, int quantity, String expDate, String productInfo, GoodType goodType) {
        this.name = name;
        this.priceProducer = priceWarehouse/2;
        this.priceWarehouse = priceWarehouse;
        this.quantity = quantity;
        this.expDate = expDate;
        this.productInfo = productInfo;
        this.productNumber = productNumber;
        this.goodType = goodType;
    }
    public Good(String name, int quantity, GoodType goodType){        // za poruchki
        this.name = name;
        this.quantity = quantity;
        this.goodType = goodType;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceProducer() {
        return priceProducer;
    }

    public void setPriceProducer(double priceProducer) {
        this.priceProducer = priceProducer;
    }

    public double getPriceWarehouse() {
        return priceWarehouse;
    }

    public void setPriceWarehouse(double priceWarehouse) {
        this.priceWarehouse = priceWarehouse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public GoodType getGoodType() {
        return goodType;
    }
    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public abstract void showProduct();
}
