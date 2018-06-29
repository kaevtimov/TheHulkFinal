package Orders;

public interface Orderers {

    void makeOrder(String deadline, OrderType orderType);

    void pay(PayType payType, String bankAccNumber);

}
