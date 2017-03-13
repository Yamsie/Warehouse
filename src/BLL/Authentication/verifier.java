package BLL.Authentication;
import UI.Views.LoginView;

import java.util.Scanner;
import java.io.*;

public class verifier implements Authentication{
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
           LoginView errer = new LoginView();
           errer.displayErrorMessage("Errer Username or Passwprd");
       }
       else{
           if(typeOfJob.equals("Picker")){
               System.out.println("load to picker page");
           }
           else if(typeOfJob.equals("Packer")){
               System.out.println("load to packer page");
           }
           else if(typeOfJob.equals("Package")){
               System.out.println("load to Package page");
           }
           else if(typeOfJob.equals("Stocker")){
               System.out.println("load to Stocker page");
           }
           else if(typeOfJob.equals("Manager")){
               System.out.println("load to Manager page");
           }
       }
   }
}
