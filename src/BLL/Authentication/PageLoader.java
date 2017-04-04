package BLL.Authentication;

import UI.Controller.EmployeeControllerFactory;
import UI.Controller.I_EmployeeController;
import UI.View.LoginView;

/**
 * Created by James on 04/04/2017.
 */
public class PageLoader {

    private LoginCredentials creds;
    private UserDetails details;
    private boolean isAuthenticated = false;

    public PageLoader(LoginCredentials creds, UserDetails details, boolean isAuthenticated) {
        this.creds = creds;
        this.details = details;
        this.isAuthenticated = isAuthenticated;
    }

    public void loadPage() {
        if(isAuthenticated == false){
            LoginView error = new LoginView();
            error.displayErrorMessage("Unverified user"); //return
        }
        else
        {    //FACTORY DESIGN PATTERN
            EmployeeControllerFactory employeeControllerFactory = new EmployeeControllerFactory();
            I_EmployeeController controller = employeeControllerFactory.getController(details);
            controller.getView().setVisible(true);
        }
    }
}
