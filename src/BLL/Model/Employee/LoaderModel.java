package BLL.Models.Employees;


public class Loader implements I_Employee
{
	private String loaderStatus;
	
	public void Loader(String loaderStatus){
		this.loaderStatus = loaderStatus
	}
	
	public String getLoaderStatus(){
		return loaderStatus;
	}
	
	public void setLoaderStatus(String loaderStatus){
		this.loaderStatus = loaderStatus;
	}
}