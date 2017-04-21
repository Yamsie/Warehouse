package UI.Controller;

import BLL.Model.Employee.StockerModel;
import BLL.Model.Inventory.Item;
import BLL.Model.Order.StockOrder;
import UI.View.StockerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

/**
 * Created by Shane on 2017/3/12.
 */
public class StockerController implements I_EmployeeController {
    private StockerView view;
    private StockerModel model;

    public StockerController(StockerView stockerView, StockerModel stockerModel){
        this.view = stockerView;
        this.model = stockerModel;
        this.view.addNewItemListener(new addNewItemListener());
        this.view.chooseListener(new chooseListener());
        this.view.changeItemDetailsListener(new changeItemDetailsListener());
        this.view.newStockOrderListener(new newStockOrderListener());
        this.view.logoutListener(new logoutListener());
    }

    class addNewItemListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            try {
                Item createdItem = view.newItem();
                model.addNewItem(createdItem);
            }
            catch (NumberFormatException e) {
                view.displayErrorMessage("Error, Invalid Input!");
            }
        }
    }

    class chooseListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            try {
                String chosenItemID = view.getChooseItem();
                String chosenItemInfo[] = model.showChosenItem(chosenItemID);
                view.setChangeInfo(chosenItemInfo);
            }
            catch (NumberFormatException e) {
                view.displayErrorMessage("Error, Invalid Input!");
            }
            catch (NullPointerException e) {
                view.displayErrorMessage("Error, No Item with that ID Exists!");
            }
        }
    }

    class changeItemDetailsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            try {
                Item changedItem = view.changeItem();
                model.changeExistingItem(changedItem);
            }
            catch (NumberFormatException e) {
                view.displayErrorMessage("Error, Invalid Input!");
            }
        }
    }

    class newStockOrderListener implements  ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            try {
                StockOrder createdStockOrder = view.newStockOrder();
                model.createNewStockOrder(createdStockOrder);
            }
    		catch (NumberFormatException e) {
                view.displayErrorMessage("Error, Invalid Input!");
            }
        }
    }

    class logoutListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
        }
    }

    public StockerView getView() {
        return view;
    }
}