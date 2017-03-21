package UI.Controller;

import BLL.Authentication.UserDetails;
import BLL.Model.Employee.ManagerModel;
import BLL.Model.Employee.PackerModel;
import BLL.Model.Employee.PickerModel;
import BLL.Model.Employee.StockerModel;
import UI.View.*;

/**
 * Created by James on 19/03/2017.
 */
public class EmployeeControllerFactory {
    public I_EmployeeController getController(UserDetails details) {
        if (details.getJobTitle() == null) {
            return null;
        }
        if (details.getJobTitle().equalsIgnoreCase("Picker")) {
            return new PickerController(new PickerView(details.getUserName()), new PickerModel());
        } else if (details.getJobTitle().equalsIgnoreCase("Packer")) {
            return new PackerController(new PackerView(details.getUserName()), new PackerModel());
        } else if (details.getJobTitle().equalsIgnoreCase("Loader")) {
            //return new LoaderController(new LoaderView(), new LoaderModel());
        } else if (details.getJobTitle().equalsIgnoreCase("Stocker")) {
            return new StockerController(new StockerView(details.getUserName()), new StockerModel());
        } else if (details.getJobTitle().equalsIgnoreCase("Manager")) {
            return new ManagerController(new ManagerView(details.getUserName()), new ManagerModel(/*details.getUserName(), details.getId(), details.getEmail()*/));
        }

        return null;
    }
}
