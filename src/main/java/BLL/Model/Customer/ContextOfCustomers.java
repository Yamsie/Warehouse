package BLL.Model.Customer;

import DAL.DatabaseService.DatabaseService;

/**
 * Created by Lenovo on 2017/4/16.
 */
public class ContextOfCustomers {
    private StateOfCustomers state;

    public ContextOfCustomers(StateOfCustomers state){
        this.state = state;
    }

    public StateOfCustomers getState(){
        return state;
    }

    public void setState(StateOfCustomers state){
        this.state = state;
    }

    public DatabaseService method(){
        if(state.getOperaterType().equals("order")){
            return state.operatorOfAccessCustomerOrders();
        }
        else if(state.getOperaterType().equals("inventory")){
            return state.operatorOfAccessInventory();
        }
        else if(state.getOperaterType().equals("customers")){
            return state.operatorOfAccessCustomers();
        }
        return null;
    }
}
