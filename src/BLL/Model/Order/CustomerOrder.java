package BLL.Model.Order;

import java.util.List;

public class CustomerOrder //implements I_Order //accessing customer orders file
{
	private int orderID;
	private int custID;
	private List<Integer> itemID;
	private int quantity;
	private String shippingAddress;
	private String status;
	private double orderPrice;
	private double shippingCost;
	private double totalCost;
	private String orderDate;
	
	public CustomerOrder(int orderID, int custID, List<Integer> itemID, int quantity, String shippingAddress, String status, String boxSize, double orderPrice,
			double shippingCost, double totalCost, String orderDate)
	{
		this.orderID = orderID;
		this.custID = custID;
		this.itemID = itemID;
		this.quantity = quantity;
		this.shippingAddress = shippingAddress;
		this.status = status;
		this.boxSize = boxSize;
		this.orderPrice = orderPrice;
		this.shippingCost = shippingCost;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
	}

	public CustomerOrder(String[] orderInfo)
	{
		this.orderID = Integer.parseInt(orderInfo[0]);
		this.custID = Integer.parseInt(orderInfo[1]);
		addItemToList(orderInfo[2]);
		this.quantity = Integer.parseInt(orderInfo[3]);
		this.shippingAddress = orderInfo[4];
		this.status = orderInfo[5];
		this.orderPrice = Double.parseDouble(orderInfo[6]);
		this.shippingCost = Double.parseDouble(orderInfo[7]);
		this.totalCost = Double.parseDouble(orderInfo[8]);
		this.orderDate = orderInfo[9];
	}

	private void addItemToList(String id) {
		itemID.add(Integer.parseInt(id));
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
	
	public List<Integer> getItemID(){
		return itemID;
	}
	
	public void setItemID(int itemID){
		this.itemID.add(itemID);
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