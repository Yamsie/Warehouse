package BLL.Model.Employee;
import BLL.Model.Box.BoxFactory;
import BLL.Model.Box.I_Box;
import BLL.Model.Employee.I_EmployeeModel;

import BLL.Model.Order.CustomerOrder;
import DAL.DatabaseService.AccessCountries;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.DatabaseService;

import javax.swing.*;

public class LoaderModel extends Employee implements I_EmployeeModel {
    //maybe automated?
    //each country has a specific loading zone
    //check if order is in loading zone

    String jobTitle;
    DatabaseService loaderDB = new AccessCustomerOrders();
    DatabaseService loaderDBCountry = new AccessCountries();

    public LoaderModel(int id, String userName, String jobTitle, String email) {
        super(id, userName, jobTitle, email);
    }

    public String[] showChosenOrder(String chosenOrder) {
        String chosenOrderInfo[] = new String[11];
        int chosenOrderID = Integer.parseInt(chosenOrder);
        String chosenOrderDetails = loaderDB.showData(chosenOrderID);
        chosenOrderInfo = chosenOrderDetails.split(",");

        String chosenCountryInfo[] = new String[6];
        String chosenCountryName = chosenOrderInfo[4];
        String chosenCountryDetails = loaderDBCountry.getCountryData(chosenCountryName);
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
        loaderDB.changeData(chosenOrderInfo);
        JOptionPane.showMessageDialog(null, "Shipped!");
        return chosenOrderInfo;
    }
}

