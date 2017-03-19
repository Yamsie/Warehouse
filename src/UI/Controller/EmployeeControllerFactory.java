package UI.Controller;

import BLL.Authentication.UserDetails;
import BLL.Models.Employees.Employee;
import BLL.Models.Employees.I_EmployeeModel;
import BLL.Models.Employees.ManagerModel;
import UI.Views.I_EmployeeView;
import UI.Views.ManagerView;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * Created by James on 19/03/2017.
 */
public class EmployeeControllerFactory {
    public I_EmployeeController getController(UserDetails details) {
        if (details.getJobTitle() == null) {
            return null;
        }
        if (details.getJobTitle().equalsIgnoreCase("Picker")) {
            //return new PickerController(view/*, model*/);
        } else if (details.getJobTitle().equalsIgnoreCase("Packer")) {
            //return new PackerController(view/*, model*/);
        } else if (details.getJobTitle().equalsIgnoreCase("Loader")) {
            //return new LoaderController(view/*, model*/);
        } else if (details.getJobTitle().equalsIgnoreCase("Stocker")) {
            //return new StockerController(view/*, model*/);
        } else if (details.getJobTitle().equalsIgnoreCase("Manager")) {
            return new ManagerController(new ManagerView(details.getUserName()), new ManagerModel(details.getUserName(), details.getId(), details.getEmail()));
        }

        return null;
    }
}
