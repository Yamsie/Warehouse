package UI.Controller;

import BLL.Model.Employee.LoaderModel;
import UI.View.LoaderView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoaderController implements I_EmployeeController {
    private LoaderView view;
    private LoaderModel model;

    public LoaderController(LoaderView view, LoaderModel model){
        this.view = view;
        this.model = model;
        this.view.SubListener(new SubListener());
        this.view.LogoutListener(new LogoutListener());
    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String chosenOrderID = view.getOrderId();
            String chosenOrderInfo[] = model.showChosenOrder(chosenOrderID);
            view.createDescription(chosenOrderInfo);
            String description = view.createDescription(chosenOrderInfo);
            view.orderInfo.setText(description);
        }
    }

    class LogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
        }
    }

    public LoaderView getView() {
        return view;
    }
}
