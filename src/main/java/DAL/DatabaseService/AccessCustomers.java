package DAL.DatabaseService;

import java.util.*;

/**
 * Created by James on 20/03/2017.
 */
public class AccessCustomers extends DatabaseService{

    public AccessCustomers(){ super("C:\\Users\\James\\IdeaProjects\\Warehouse\\data\\CUSTOMERS.txt"); }

    public boolean checkCustomers(String UserID){
        List<String> cus = super.getData();
        for (int i = 1; i < cus.size(); i++) {
            String[] detail = cus.get(i).split(",");
            if (Integer.parseInt(detail[0]) == Integer.parseInt(UserID)) {
                return true;
            }
        }
        return false;
    }

    public String getCustomersAddress(String UserID){
        List<String> cus = super.getData();
        String temp = "";
        for (int i = 1; i < cus.size(); i++) {
            String[] detail = cus.get(i).split(",");
            if (Integer.parseInt(detail[0]) == Integer.parseInt(UserID)) {
                temp = detail[3];
                break;
            }
        }
        return temp;
    }


}
