package UI.Controller;

import BLL.Authentication.UserDetails;
import BLL.Model.Employee.ManagerModel;
import UI.View.ManagerView;

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
            return new ManagerController(new ManagerView(details.getUserName()), new ManagerModel(/*details.getUserName(), details.getId(), details.getEmail()*/));
        }

        return null;
    }
}
