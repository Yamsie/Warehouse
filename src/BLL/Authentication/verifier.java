package BLL.Authentication;
import UI.Views.LoginView;

import java.util.Scanner;

public class verifier implements Authentication{
   private boolean temp = false;

   public void check(String userName, String passWord) throws Exception {
       java.io.File file = new java.io.File("data/EMPLOYEE.txt");

       Scanner input = new Scanner(file);

       while (input.hasNext()) {
           String UserInfo = input.nextLine();
           String[] user = UserInfo.split(", ");
           if(userName.equals(user[1])){
                temp = user[2].equals(passWord);
           }
           if(temp) {
               pageLoading(true, user[3], userName);
               break;
           }
       }
       if(temp == false){
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
