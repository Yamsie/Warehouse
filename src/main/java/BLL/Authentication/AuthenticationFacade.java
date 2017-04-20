package BLL.Authentication;
import DAL.DatabaseService.AccessEmployees;
import DAL.DatabaseService.DatabaseService;

import java.util.Arrays;

public class AuthenticationFacade implements I_Authentication {

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
            String[] user = db.selectInfo("username", credentials.getUserName()).get(0).split(",");
            details = new UserDetails(Integer.parseInt(user[0]), user[1], user[2].toCharArray(), user[3], user[4]);
        } catch (IndexOutOfBoundsException e) {

        }

        if(!(details == null)){
            if((Arrays.equals(details.getPassword(), credentials.getPassword())) && (details.getUserName().equals(credentials.getUserName()))){
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