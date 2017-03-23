package BLL.Model.Order;

public class CustomerOrder 
{
	private int orderID;
	private int custID;
	private int itemID;
	private int quantity;
	private String status;
	private double orderPrice;
	private double shippingCost;
	private double totalCost;
	private String orderDate;
	private String shippingAddress;
	
	public void Order(int orderID, int custID, int itemID, int quantity, String shippingAddress, String status, double orderPrice, 
			double shippingCost, double totalCost, String orderDate)
	{
		this.orderID = orderID;
		this.custID = custID;
		this.itemID = itemID;
		this.quantity = quantity;
		this.shippingAddress = shippingAddress;
		this.status = status;
		this.orderPrice = orderPrice;
		this.shippingCost = shippingCost;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public int getCustID() {
		return custID;
	}
	
	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	public int getItemID(){
		return itemID;
	}
	
	public void setItemID(int itemID){
		this.itemID = itemID;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString()
	{
		return orderID+","+custID+","+itemID+","+quantity+","+status+","+orderPrice+","+shippingCost+","+totalCost+","+orderDate+","+shippingAddress;
	}
}