package BLL.Authentication;

import java.util.Scanner;
import java.io.*;
/**
 * Created by Lenovo on 2017/3/13.
 */
public class DatabaseOperator {
    protected DatabaseOperator(){
    }

    protected UserDetails getInfo(String userName)throws IOException{
        File file = new File("data/EMPLOYEES.txt");

        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String UserInfo = input.nextLine();
            String[] user = UserInfo.split(",");
            if(userName.equals(user[1])){
                return new UserDetails(Integer.parseInt(user[0]), user[1], user[2].toCharArray(), user[3], user[4]);
            }

        }

        return new UserDetails(Integer.parseInt("000000"), "NULL", "NULL".toCharArray(), "NULL", "NULL");
    }
    
}
