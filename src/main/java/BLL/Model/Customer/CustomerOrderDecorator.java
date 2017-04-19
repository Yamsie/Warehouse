package BLL.Model.Customer;

import DAL.DatabaseService.AccessCustomers;
import DAL.DatabaseService.AccessInventory;

import java.util.Calendar;

/**
 * Created by Lenovo on 2017/4/16.
 */
public class CustomerOrderDecorator implements CustomerOrderSourceable {

    private CustomerOrderSourceable source;
    StateOfCustomers state  = new StateOfCustomers();
    ContextOfCustomers context = new ContextOfCustomers(state);

    public CustomerOrderDecorator(CustomerOrderSourceable source){
        super();
        this.source = source;
    }
//#order_id,cust_id,item_id,order_quantity,shipping_address,loading_zone,status,box_size,order_price,shipping_price,total_price,order_date
    //123457,2,2,1,France,3,PACKING,BoxA,1.0,1.0,2.0,28/01/2017
    public String customerOrder(String orderId, String userID, String ItemId, int quantity){
        String orderDetail = "";
        orderDetail += source.customerOrder(orderId, userID, ItemId,quantity);
        orderDetail += addAddress(userID) + ",";
        orderDetail += getDefault();
        orderDetail += getOrderPrice(ItemId, quantity) + ",";
        orderDetail += "50.0,";
        orderDetail += getTotal(getOrderPrice(ItemId, quantity)) + ",";
        orderDetail += getDate();
        return orderDetail;
    }

    public double getOrderPrice(String ItemId, int quantity){
        state.setOperatorType("inventory");
        AccessInventory inventory = (AccessInventory)context.method();
        String temp = inventory.showData(Integer.parseInt(ItemId));
        String [] Item = temp.split(",");
        double price = Double.parseDouble(Item[7]) * quantity;
        return price;
    }

    public double getTotal(double price){
        double total = price + 50.0;
        return total;
    }

    public String getDefault(){
        //loading_zone,status,box_size
        String Default= "1,ACCEPTED,null,";
        return Default;
    }

    public String getDate(){
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month=ca.get(Calendar.MONTH);
        int day=ca.get(Calendar.DATE);
        String date = day + "/" + month + "/" + year;
        return date;
    }

    public String addAddress(String userID){
        state.setOperatorType("customers");
        AccessCustomers cus = (AccessCustomers)context.method();
        String temp = cus.getCustomersAddress(userID);
        return temp;
    }
}