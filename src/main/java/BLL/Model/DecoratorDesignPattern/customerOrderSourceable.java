package BLL.Model.DecoratorDesignPattern;

/**
 * Created by Lenovo on 2017/4/16.
 */
public interface customerOrderSourceable {

    public String customerOrder(String orderId, String userID, String ItemID, int quantity);

}
