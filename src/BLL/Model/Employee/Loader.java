package BLL.Model.Employee;
import BLL.Model.Employee.I_EmployeeModel;

public class Loader implements I_EmployeeModel
{
	private String loaderStatus;
	
	public void Loader(String loaderStatus){
		this.loaderStatus = loaderStatus;
	}
	
	public String getLoaderStatus(){
		return loaderStatus;
	}
	
	public void setLoaderStatus(String loaderStatus){
		this.loaderStatus = loaderStatus;
	}
}