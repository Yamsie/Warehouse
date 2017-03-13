package BLL.Authentication;

import java.util.Scanner;
import java.io.*;
/**
 * Created by Lenovo on 2017/3/13.
 */
public class DatabaseOperator {
    public DatabaseOperator(){

    }
    public String[]  getInfo(String userName)throws IOException{
        File file = new File("data/EMPLOYEE.txt");

        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String UserInfo = input.nextLine();
            String[] user = UserInfo.split(", ");
            if(userName.equals(user[1])){
                return user;
            }

        }
        String[] user = {"000000", "NULL", "NULL", "NULL"};
        return user;
    }
    
}
