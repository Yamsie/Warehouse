package BLL.Model.Customer;

import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.AccessCustomers;
import DAL.DatabaseService.AccessInventory;
import DAL.DatabaseService.DatabaseService;

/**
 * Created by Lenovo on 2017/4/16.
 */
public class StateOfCustomers {
    private String operatorType;

    private DatabaseService customersDB = new AccessCustomers();
    private DatabaseService orderDB = new AccessCustomerOrders();
    private DatabaseService inventoryDB = new AccessInventory();

    public String getOperaterType(){
        return operatorType;
    }

    public void setOperatorType(String operatorType){
        this.operatorType = operatorType;
    }

    public DatabaseService operatorOfAccessInventory(){
        return inventoryDB;
    }

    public DatabaseService operatorOfAccessCustomerOrders(){
        return orderDB;
    }

    public DatabaseService operatorOfAccessCustomers() {return customersDB;}
}
