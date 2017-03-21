package BLL.Models.Orders;
import java.util.ArrayList;

public class OrderDetail implements I_Order //accessing customer orders file
{
	private int orderID;
	private String shippingAddress;
	private String status;
	private ArrayList<Integer> itemIDs;
	
	public void Order(int orderID, String shippingAddress, String status, ArrayList<Integer> itemIDs)
	{
		this.orderID = orderID;
		this.shippingAddress = shippingAddress;
		this.status = status;
		this.itemIDs = itemIDs;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public ArrayList<Integer> getItemIDs() {
		return itemIDs;
	}
	
	public void setItemIDs(ArrayList<Integer> itemIDs) {
		this.itemIDs = itemIDs;
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
}