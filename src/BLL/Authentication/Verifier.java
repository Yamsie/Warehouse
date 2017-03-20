package BLL.Authentication;
import UI.Controller.*;
import UI.Views.*;

import java.util.Scanner;
import java.io.*;

public class Verifier implements Authentication{
   private boolean temp = false;

   public void check(String userName, String passWord) throws IOException {

          DatabaseOperator operator = new DatabaseOperator();
          String[] user = operator.getInfo(userName);
           if(user[1].equals("NULL")){
               pageLoading(false, null, null);
           }
           else{
               if(user[2].equals(passWord)){
                   pageLoading(true, user[3], userName);
               }
               else
                   pageLoading(false, null, null);
           }

       }

   public void pageLoading(boolean temp, String typeOfJob, String Name){
       if(temp == false){
           LoginView error = new LoginView();
           error.displayErrorMessage("Error Username or Password");
       }
       else{
           if(typeOfJob.equals("Picker")){
               System.out.println("load to picker page");
               PickerView UserView = new PickerView(Name);
               /*Employee usrModel = new Packer();*/
               PickerController UserPickerController = new PickerController(UserView /*UserModel*/);
           }
           else if(typeOfJob.equals("Packer")){
               System.out.println("load to packer page");
               PackerView UserView = new PackerView(Name);
               /*Employee usrModel = new Packer();*/
               PackerController UserPackerContoller  = new PackerController(UserView/*, UserAuthentication*/);
           }
           else if(typeOfJob.equals("Loader")){
               System.out.println("load to Loader page");
               LoaderView UserView = new LoaderView(Name);
               /*Employee UserModel = new Loader();*/
               LoaderController UserLoaderController = new LoaderController(UserView/*, UserModel*/);
           }
           else if(typeOfJob.equals("Stocker")){
               System.out.println("load to Stocker page");
               StockerView UserView = new StockerView(Name);
               /*Employee UserModel = new Stocker();*/
               StockerController UserStockerController = new StockerController(UserView/*, UserModel*/);
           }
           else if(typeOfJob.equals("Manager")){
               System.out.println("load to Manager page");
               ManagerView UserView  = new ManagerView(Name);
               /*Employee UserModel = new Manager();*/
               ManagerController UserMangerController = new ManagerController(UserView/*, UserModel*/);
           }
       }
   }
}
