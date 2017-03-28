package UI;

import BLL.Authentication.Authentication;
import BLL.Authentication.Verifier;
import BLL.Model.Employee.PickerModel;
import UI.Controller.LoginController;
import UI.Controller.PickerController;
import UI.View.LoginView;
import UI.View.PickerView;

/**
 * Created by James on 13/03/2017.
 */

public class StartQuickfire {
    public static void main(String[] args) {
        LoginView userLoginView = new LoginView();
        Authentication userAuthentication = new Verifier();
        LoginController userLoginContoller = new LoginController(userLoginView, userAuthentication);
        userLoginView.setVisible(true);

      //  PickerView view = new PickerView("picker");
        //PickerModel model = new PickerModel(1,  "userName", "Picker", "123");
       // PickerController controller = new PickerController(view, model);
    }
}
