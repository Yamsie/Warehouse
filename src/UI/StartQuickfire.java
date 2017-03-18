package UI;

import BLL.API.Courier.Courier;
import BLL.Authentication.Authentication;
import BLL.Authentication.Verifier;
import UI.Controller.LoginController;
import UI.Views.LoginView;

import javax.xml.ws.Endpoint;

/**
 * Created by James on 13/03/2017.
 */

public class StartQuickfire {
    public static void main(String[] args) {
        LoginView userLoginView = new LoginView();
        Authentication userAuthentication = new Verifier();
        LoginController userLoginContoller = new LoginController(userLoginView, userAuthentication);
        userLoginView.setVisible(true);
    }
}
