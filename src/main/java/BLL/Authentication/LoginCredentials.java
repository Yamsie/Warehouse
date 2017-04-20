package BLL.Authentication;

/**
 * Created by James on 04/04/2017.
 */
public class LoginCredentials {

    private String userName;
    private char[] password;

    public LoginCredentials(String userName, char[] password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public char[] getPassword() {
        return password;
    }
}