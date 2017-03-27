package BLL.Model.Employee;

//import DAL package;

import BLL.Model.Box.BoxFactory;
import BLL.Model.Box.I_Box;
import BLL.Model.Employee.Employee;
import BLL.Model.Order.CustomerOrder;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.DatabaseService;
import BLL.Model.Inventory.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiasenTian on 2017/3/19.
 */

public class PackerModel extends Employee {
    //private String jobTitle;
    DatabaseService db = new AccessCustomerOrders(this.getJobTitle());
    List<String> toPack = new ArrayList<>();

    public PackerModel(int id, String userName, String jobTitle, String email){
        super(id, userName, jobTitle, email);
    }

    public String [] getItemInfo(int itemId){
        String[] itemInfo = db.getRow(itemId);
        Item item = new Item(itemInfo);
        return itemInfo;
    }

    public CustomerOrder getOrderInfo(int orderId) {
        String[] orderDetails = db.getRow(orderId);
        CustomerOrder custOrd = new CustomerOrder(orderDetails);
        return custOrd;
    }

    public void boxOrder(CustomerOrder order) {
        BoxFactory factory = new BoxFactory();
        I_Box box = factory.createBox(order);
        order.setBoxSize(box);
    }

    //public String getJobTitle() { return jobTitle;}
}

/**
 * needs to take order id
 * from order id, list items
 * from list of items, generate box
 * automatically set box size of order id
 * once order is set as packed, reset screen
 */
