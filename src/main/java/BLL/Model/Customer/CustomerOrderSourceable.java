package BLL.Model.Customer;

/**
 * Created by Lenovo on 2017/4/16.
 */
public interface CustomerOrderSourceable {

    public String customerOrder(String orderId, String userID, String ItemID, int quantity);

}
