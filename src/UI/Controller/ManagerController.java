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

    public ManagerController(ManagerView managerView, ManagerModel managerModel) {
        this.view = managerView;
        this.view.employeeListener(new SubListener());
        this.view.customerListener(new SubListener());
        this.view.orderListener(new SubListener());

    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
        }
    }

    public I_EmployeeView getView() {
        return view;
    }

}
