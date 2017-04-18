package BLL.Model.DecoratorDesignPattern;

/**
 * Created by Lenovo on 2017/4/16.
 */
public class customerOrderSource implements customerOrderSourceable {

    @Override
    public String customerOrder(String orderId, String userID, String ItemId, int quantity) {
        String orderDetail = "";
        orderDetail += Integer.parseInt(orderId) + "," + Integer.parseInt(userID) + "," + ItemId + "," + quantity + ",";
        return orderDetail;
    }

}
