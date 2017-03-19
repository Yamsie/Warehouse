package BLL.Model.Order;
import java.util.ArrayList;

public class OrderDetail implements I_Order //accessing customer orders file
{
	private int orderID;
	private String shippingAddress;
	private String status;
	private ArrayList<Integer> itemIDs;
	
	public void Order(int id, String shippingAddress)
	{
		this.orderID = id;
		this.shippingAddress = shippingAddress;
		this.status = "ACCEPTED";
		this.itemIDs = itemIDs;
	}
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	
	public ArrayList<Integer> getItemIDs() {
		return itemIDs;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public void setItemIDs(ArrayList<Integer> itemIDs) {
		this.itemIDs = itemIDs;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	/*public String getOrderDetails(int orderID)
	{
		return "OrderID: " + orderID + "\nItem(s): " + itemIDs + "\nShipping address: " + shippingAddress;
	}*/

	//Added these to make code compile
	public String getOrderDetails() {
		return null;
	}

	public void changeOrderInDB() {

	}
}