package UI.Controller;

import BLL.Model.Employee.StockerModel;
import UI.View.StockerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockerController implements I_EmployeeController {
    private StockerView view;
    private StockerModel model;

    public StockerController(StockerView view, StockerModel model){
        this.view = view;
        this.model = model;
        this.view.addListener(new addListener());
        this.view.changeListener(new changeListener());
        this.view.chooseListener(new chooseListener());
        this.view.newStockOrderListener(new newStockOrderListener());
        this.view.LogoutListener(new LogoutListener());
    }

    class addListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            try {
                String[] newItem = view.newItem(view);
                model.addInfo(newItem);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer to add new Item!");
            }
        }

    }

    class chooseListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String Id;
            try {
                Id = view.getChooseId();
                String[] Item = model.showInfo(Integer.parseInt(Id));
                view.setChangeInfo(Item);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("ID errer!");
            }
        }

    }


    class changeListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            try {
                String[] newInfo = view.getChange();
                model.changeInfo(newInfo);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer to Log out!");
            }
        }

    }

    class newStockOrderListener implements  ActionListener{
        public void actionPerformed(ActionEvent arg0) {

            try {
                String[] newInfo = view.getNewStockOrder();
                model.addInfo(newInfo);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer to create new stock order!");
            }
        }

    }

    class LogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            try {
                view.setVisible(false);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer to Log out!");
            }
        }

    }

    public StockerView getView() {
        return view;
    }
}
