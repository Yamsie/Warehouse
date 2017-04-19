package BLL.Model.Employee;

import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.AccessInventory;
import DAL.DatabaseService.DatabaseService;

/**
 * Created by Lenovo on 2017/4/2.
 */
public class StateOfPicker {
    private String operatorType;

    private DatabaseService pickerBD = new AccessCustomerOrders();
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
        return pickerBD;
    }

}
