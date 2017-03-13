public class Order implements OrderInterface
{
	private final int orderID;
	private String shippingAddress;
	private String status;
	private ArrayList<Integer>itemIDs;
	
	public Order(int id, String shippingAddress)
	{
		this.orderID = id;
		this.shippingAddress = shippingAddress;
		this.status = "SHIPPED";
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
}