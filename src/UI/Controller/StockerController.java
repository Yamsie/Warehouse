package UI.Controller;

import BLL.Model.Employee.StockerModel;
import BLL.Model.Inventory.Item;
import BLL.Model.Order.StockOrder;
import UI.View.StockerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            Item createdItem = view.newItem();
            model.addNewItem(createdItem);
        }
    }

    class chooseListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String chosenItemID = view.getChooseItem();
            String chosenItemInfo[] = model.showChosenItem(chosenItemID);
            view.setChangeInfo(chosenItemInfo);
        }
    }

    class changeItemDetailsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            Item changedItem = view.changeItem();
            model.changeExistingItem(changedItem);
        }
    }

    class newStockOrderListener implements  ActionListener{
        public void actionPerformed(ActionEvent arg0) {
    		StockOrder createdStockOrder = view.newStockOrder();
    		model.createNewStockOrder(createdStockOrder);
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

