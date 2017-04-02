package BLL.Model.Employee;
import BLL.Model.Employee.I_EmployeeModel;

import DAL.DatabaseService.AccessCountries;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.DatabaseService;

public class LoaderModel extends Employee implements I_EmployeeModel
{
	//maybe automated?
	//each country has a specific loading zone
	//check if order is in loading zone

	String jobTitle;
	DatabaseService loaderDB = new AccessCountries();

	public LoaderModel(int id, String userName, String jobTitle, String email) {
        super( id, userName, jobTitle, email);
    }

	public String [] getCountryInfo(String countryName){
        String [] countryInfo = new String[7];
        //countryInfo = loaderDB.getCountryInfo(countryName);
        return countryInfo;
    }

	public String [] getOrderInfo(int orderID){
        String [] orderInfo = new String[11];
        //orderInfo = loaderDB.getOrderInfo(countryName);
        return orderInfo;
    }
}
