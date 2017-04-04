package BLL.Model.Employee;
import BLL.Model.Employee.I_EmployeeModel;

import DAL.DatabaseService.AccessCountries;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.DatabaseService;

import java.util.List;

public class LoaderModel extends Employee implements I_EmployeeModel
{
	//maybe automated?
	//each country has a specific loading zone
	//check if order is in loading zone

	String jobTitle;
	DatabaseService loaderDB = new AccessCustomerOrders();
	DatabaseService loaderDBCountry = new AccessCountries();

	public LoaderModel(int id, String userName, String jobTitle, String email) {
        super( id, userName, jobTitle, email);
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

        System.out.println(chosenOrderInfo[4]);
        System.out.println(chosenOrderInfo[5]);
        System.out.println(chosenCountryInfo[0]);
        System.out.println(chosenCountryInfo[1]);

        if(chosenOrderInfo[4].equals(chosenCountryInfo[0]))   {
            if(!(chosenOrderInfo[5].equals(chosenCountryInfo[1])))  {
                if(chosenOrderInfo[4].equals("Ireland") || chosenOrderInfo[4].equals("UK"))
                    chosenOrderInfo[5] = "1";
                else if(chosenOrderInfo[5].equals("France") || chosenOrderInfo[5].equals("Spain") ||
                        chosenOrderInfo[5].equals("Portugal"))
                    chosenOrderInfo[5] = "3";
                else if(chosenOrderInfo[5].equals("Switzerland") ||
                        chosenOrderInfo[5].equals("Italy") || chosenOrderInfo[5].equals("Austria"))
                    chosenOrderInfo[5] = "4";
                else if(chosenOrderInfo[5].equals("Netherlands") || chosenOrderInfo[5].equals("Belgium") ||
                        chosenOrderInfo[5].equals("Germany") || chosenOrderInfo[5].equals("Denmark"))
                    chosenOrderInfo[5] = "5";
                else if(chosenOrderInfo[5].equals("Norway") || chosenOrderInfo[5].equals("Sweden") ||
                        chosenOrderInfo[5].equals("Finland") || chosenOrderInfo[5].equals("Iceland"))
                    chosenOrderInfo[5] = "6";
            }
        }

        System.out.println(chosenOrderInfo[4]);
        System.out.println(chosenOrderInfo[5]);
        System.out.println(chosenCountryInfo[0]);
        System.out.println(chosenCountryInfo[1]);

        return chosenOrderInfo;
    }
}
