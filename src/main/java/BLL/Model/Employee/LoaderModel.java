package BLL.Model.Employee;
import BLL.Model.Box.BoxFactory;
import BLL.Model.Box.I_Box;
import BLL.Model.Employee.I_EmployeeModel;

import BLL.Model.Order.CustomerOrder;
import DAL.DatabaseService.AccessCountries;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.DatabaseService;

import javax.swing.*;
import java.util.List;

public class LoaderModel extends Employee implements I_EmployeeModel {

    String jobTitle;
    DatabaseService loaderDB = new AccessCustomerOrders();
    DatabaseService loaderDBCountry = new AccessCountries();

    public LoaderModel(int id, String userName, String jobTitle, String email) {
        super(id, userName, jobTitle, email);
    }

    public String[] updateOrder(String chosenOrder) {
        String chosenOrderInfo[];
        int chosenOrderID = Integer.parseInt(chosenOrder);
        String chosenOrderDetails = loaderDB.showData(chosenOrderID);
        chosenOrderInfo = chosenOrderDetails.split(",");

        String chosenCountryInfo[];
        String chosenCountryName = chosenOrderInfo[loaderDB.getColumnIndex("shipping_address")];
        String chosenCountryDetails = loaderDBCountry.selectInfo("country_name", chosenCountryName).get(0);
        chosenCountryInfo = chosenCountryDetails.split(",");

        if (chosenOrderInfo[4].equals(chosenCountryInfo[0])) {
            if (!(chosenOrderInfo[5].equals(chosenCountryInfo[1]))) {
                if (chosenOrderInfo[4].equals("Ireland") || chosenOrderInfo[4].equals("UK")) {
                    chosenOrderInfo[5] = "1";
                    chosenOrderInfo[6] = "SHIPPED";
                }
                else if (chosenOrderInfo[4].equals("France") || chosenOrderInfo[4].equals("Spain") ||
                        chosenOrderInfo[4].equals("Portugal")) {
                    chosenOrderInfo[5] = "3";
                    chosenOrderInfo[6] = "SHIPPED";
                }
                else if (chosenOrderInfo[4].equals("Switzerland") ||
                        chosenOrderInfo[4].equals("Italy") || chosenOrderInfo[4].equals("Austria")) {
                    chosenOrderInfo[5] = "4";
                    chosenOrderInfo[6] = "SHIPPED";
                }
                else if (chosenOrderInfo[4].equals("Netherlands") || chosenOrderInfo[4].equals("Belgium") ||
                        chosenOrderInfo[4].equals("Germany") || chosenOrderInfo[4].equals("Denmark")) {
                    chosenOrderInfo[5] = "5";
                    chosenOrderInfo[6] = "SHIPPED";
                }
                else if (chosenOrderInfo[4].equals("Norway") || chosenOrderInfo[4].equals("Sweden") ||
                        chosenOrderInfo[4].equals("Finland") || chosenOrderInfo[4].equals("Iceland")) {
                    chosenOrderInfo[5] = "6";
                    chosenOrderInfo[6] = "SHIPPED";
                }
            }
            else
                chosenOrderInfo[6] = "SHIPPED";
        }

        String output = "";
        for (int i = 0; i < chosenOrderInfo.length; i++) {
            output += chosenOrderInfo[i];
            if (i != chosenOrderInfo.length - 1) {
                output += ",";
            }
        }

        loaderDB.deleteData(chosenOrderInfo);
        loaderDB.addData(output);
        JOptionPane.showMessageDialog(null, "Shipped!");
        return chosenOrderInfo;
    }

    public String getOrders(){
        List<String> test = loaderDB.selectInfo("status", "LOADING");
        String [] temp = test.toArray(new String[0]);
        String orders = "";
        for(int i = 1; i < temp.length; i++){
            orders += temp[i] + "\n";
        }
        return orders;
    }
}

