package Orders;

import Goods.GoodType;


public interface Orderable {

    void order(GoodType goodType, int quantity, double orderValue, String productName);

    //void constructOrder(String deadline, Good good);

    void pay(PayType payType, double amount);

}
