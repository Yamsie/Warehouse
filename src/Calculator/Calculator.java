package Calculator;
import java.util.Scanner;
import BLL.Authentication.*;
import UI.*;
import UI.Controller.LoginController;
import UI.Views.LoginView;

/**
 * Created by James on 08/02/2017.
 * Controller makes the view and model work together, the two do not interact directly
 * Adding this to test version control again
 */
public class Calculator {
    public static void main(String [] args) throws Exception {
        /*CalculatorView calcView = new CalculatorView();
        CalculatorModel calcModel = new CalculatorModel();
        CalculatorController calcController = new CalculatorController(calcView, calcModel);
        calcView.setVisible(true);*/
       /* Authentication test = new verifier();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your userName: ");
        String userName = input.next();
        System.out.println("Please enter your passWord: ");
        String passWord = input.next();
        test.check(userName, passWord);*/
        LoginView UserLoginView = new LoginView();
        Authentication UserAuthentication = new verifier();
        LoginController UserLoginContoller  = new LoginController(UserLoginView, UserAuthentication);
        UserLoginView.setVisible(true);


        //Push test
    }
}
