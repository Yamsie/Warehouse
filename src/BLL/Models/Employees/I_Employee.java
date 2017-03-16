package BLL.Models.Employees;
import java.util.ArrayList;

public interface I_Employee{
	public string [] showAllItems(); 
	public string [] showCustomers();
	public string [] showCustomersAndOrders();
	public string [] showReturns();
	public string [] showCountries();
	public string [] showStockOrders();
	public void getNewOrder();
	public void getNewCustomer();
	public void getNewStockItem();
	public string [] getChangeAllItems();
	public string [] getChangeCustomers();
	public string [] getChangeReturns();
	public string [] getChangeCustomerOrders();
	public string [] getChangeStockOrders();
	public void getAddOrderInto();
	public void getDeleteOrder();
	public void DBOperator();
	
}