package UI;

import BLL.Authentication.I_Authentication;
import BLL.Authentication.AuthenticationFacade;
import UI.Controller.LoginController;
import UI.View.LoginView;

/**
 * Created by James on 13/03/2017.
 */

public class StartQuickfire {
    public static void main(String[] args) {
        LoginView userLoginView = new LoginView();
        I_Authentication userAuthentication = new AuthenticationFacade();
        LoginController userLoginContoller = new LoginController(userLoginView, userAuthentication);
        userLoginView.setVisible(true);

      //  PickerView view = new PickerView("picker");
        //PickerModel model = new PickerModel(1,  "userName", "Picker", "123");
       // PickerController controller = new PickerController(view, model);
    }
}
