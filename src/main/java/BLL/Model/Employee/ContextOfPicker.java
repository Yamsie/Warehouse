package BLL.Model.Employee;

import DAL.DatabaseService.DatabaseService;

/**
 * Created by Lenovo on 2017/4/2.
 */
public class ContextOfPicker {
    private StateOfPicker state;

    public  ContextOfPicker(StateOfPicker state){
        this.state = state;
    }

    public StateOfPicker getState(){
        return state;
    }

    public void setState(StateOfPicker state){
        this.state = state;
    }

   public DatabaseService method(){
        if(state.getOperaterType().equals("picker")){
            return state.operatorOfAccessCustomerOrders();
        }
        else if(state.getOperaterType().equals("inventory")){
           return state.operatorOfAccessInventory();
        }
        return null;
    }
}
