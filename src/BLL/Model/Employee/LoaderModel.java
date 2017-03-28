/*package BLL.Model.Employee;
import BLL.Model.Employee.I_EmployeeModel;

import DAL.DatabaseService.AccessCountries;
import DAL.DatabaseService.AccessCustomerOrders;

public class LoaderModel extends Employee implements I_Employee
{
	//maybe automated?
	//each country has a specific loading zone
	//check if order is in loading zone
	String jobTitle;
	DatabaseService loaderDB = new AccessCountries();

	public LoaderModel(String userName, int id, String email){
      super(id,userName,"Loader", email);
	   		jobTitle = "Loader";
	    }

	public String [] getCountryInfo(String countryName){
        String [] countryInfo = new String[7];
        //countryInfo = loaderDB.getCountryInfo(countryName);
        return countryInfo;
    }

	public String [] getOrderInfo(int orderID){
        String [] orderInfo = new String[9];
        //orderInfo = loaderDB.getOrderInfo(countryName);
        return orderInfo;
    }
}*/
