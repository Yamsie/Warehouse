import java.util.ArrayList;

public class OrderDetail implements Order
{
	private int orderID;
	private String shippingAddress;
	private String status;
	private ArrayList<Integer> itemIDs;
	
	public void Order(int id, String shippingAddress)
	{
		this.orderID = id;
		this.shippingAddress = shippingAddress;
		this.status = "SHIPPED";
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
	
	public String getOrderDetails(int orderID)
	{
		return "OrderID: " + orderID + "\nItem(s): " + itemIDs + "\nShipping address: " + shippingAddress;
	}
	
	public void changeOrderInDB() // text file for now
	{
		//access DB/textfile and change Order
	}
}