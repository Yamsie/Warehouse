package BLL.Authentication;
import DAL.DatabaseService.AccessEmployees;
import DAL.DatabaseService.DatabaseService;
import UI.Controller.EmployeeControllerFactory;
import UI.Controller.I_EmployeeController;
import UI.View.LoginView;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.io.*;

public class AuthenticationFacade implements Authentication{

    private boolean userVerified = false;
    private LoginCredentials credentials;
    private UserDetails details;
    private DatabaseService db;
    private PageLoader pageLoader;

    public AuthenticationFacade() {
    }

    public void setCredentials(String userName, char[] passWord) {
        credentials = new LoginCredentials(userName, passWord);
    }

    public void authenticate() {
        db = new AccessEmployees();
        try {
            String[] user = db.selectInfo("UserName", credentials.getUserName()).get(0).split(",");
            details = new UserDetails(Integer.parseInt(user[0]), user[1], user[2].toCharArray(), user[3], user[4]);
        } catch (IndexOutOfBoundsException e) {

        }

        if(!(details == null)){
            if((Arrays.equals(details.getPassword(), credentials.getPassword()) && (details.getUserName().equals(credentials.getUserName())))){
                userVerified = true;
            }
            else {
                userVerified = false;
            }
        }

    }

    public void loadPage() {
        pageLoader = new PageLoader(credentials, details, userVerified);
        pageLoader.loadPage();
    }


}