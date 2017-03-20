package UI.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BLL.Models.Employees.ManagerModel;
import UI.Views.I_EmployeeView;
import UI.Views.ManagerView;
import BLL.Authentication.Authentication;
/**
 * Created by James on 16/03/2017.
 */
public class ManagerController implements I_EmployeeController {
    private ManagerView view;
    private ManagerModel model;

    public ManagerController(ManagerView managerView, ManagerModel managerModel) {
        this.view = managerView;
        this.model = managerModel;
        this.view.employeeListener(new EmployeeButtonListener());
        this.view.customerListener(new CustomerButtonListener());
        this.view.orderListener(new OrderButtonButtonListener());

    }

    class EmployeeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            view.setDisplayText(model.getEmployeeData());
        }
    }

    class CustomerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            //model.getCustomerData();
        }
    }

    class OrderButtonButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            //model.getOrderData();
        }
    }

    public I_EmployeeView getView() {
        return view;
    }

}
