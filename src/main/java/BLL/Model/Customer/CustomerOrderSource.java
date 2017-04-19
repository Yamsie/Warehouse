package BLL.Model.Customer;

/**
 * Created by Lenovo on 2017/4/16.
 */
public class CustomerOrderSource implements CustomerOrderSourceable {

    @Override
    public String customerOrder(String orderId, String userID, String ItemId, int quantity) {
        String orderDetail = "";
        orderDetail += Integer.parseInt(orderId) + "," + Integer.parseInt(userID) + "," + ItemId + "," + quantity + ",";
        return orderDetail;
    }

}
