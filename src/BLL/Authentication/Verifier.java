package BLL.Authentication;
import UI.Controller.EmployeeControllerFactory;
import UI.Controller.I_EmployeeController;
import UI.Views.LoginView;

import java.util.Arrays;
import java.io.*;

public class Verifier implements Authentication{

   public void check(String userName, char[] passWord) throws IOException {

       DatabaseOperator operator = new DatabaseOperator();
       UserDetails details = operator.getInfo(userName);
       if(details.getUserName().equals("NULL")){
           pageLoading(false, null);
       }
       else{
           if(Arrays.equals(details.getPassword(), passWord)){
               pageLoading(true, details);
           }
           else {
               pageLoading(false, null);
           }
       }

       }

   public void pageLoading(boolean temp, UserDetails details) {
       if(temp == false){
            LoginView error = new LoginView();
            error.displayErrorMessage("Error Username or Password"); //return
       }
       else
       {    //FACTORY DESIGN PATTERN
            EmployeeControllerFactory employeeControllerFactory = new EmployeeControllerFactory();
            I_EmployeeController controller = employeeControllerFactory.getController(details);
            controller.getView().setVisible(true);
       }
   }
}
