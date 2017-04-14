package BLL.Model.Order;

import BLL.Model.Box.I_Box;
import BLL.Model.Inventory.Item;
import DAL.DatabaseService.AccessInventory;
import DAL.DatabaseService.DatabaseService;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrder //implements I_Order //accessing customer orders file
{
	private int orderID;
	private int custID;
	private List<Item> items = new ArrayList<Item>();
	private int quantity;
	private String shippingAddress;
	private String status;
	private String boxSize;
	private double orderPrice;
	private double shippingCost;
	private double totalCost;
	private String orderDate;
	private int loadingZone;
	

	public CustomerOrder(int orderID, int custID, List<Item> items, int quantity, String shippingAddress, String status, String boxSize, double orderPrice,
						 double shippingCost, double totalCost, String orderDate, int loadingZone)

	{
		this.orderID = orderID;
		this.custID = custID;
		this.items.addAll(items);
		this.quantity = quantity;
		this.shippingAddress = shippingAddress;
		this.status = status;
		this.boxSize = boxSize;
		this.orderPrice = orderPrice;
		this.shippingCost = shippingCost;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.loadingZone = loadingZone;
	}

	public CustomerOrder(String[] orderInfo)
	{
		this.orderID = Integer.parseInt(orderInfo[0]);
		this.custID = Integer.parseInt(orderInfo[1]);
		addItemToList(Integer.parseInt(orderInfo[2]));
		this.quantity = Integer.parseInt(orderInfo[3]);
		this.shippingAddress = orderInfo[4];
		this.loadingZone = Integer.parseInt(orderInfo[5]);
		this.status = orderInfo[6];
		this.boxSize = orderInfo[7];
		this.orderPrice = Double.parseDouble(orderInfo[8]);
		this.shippingCost = Double.parseDouble(orderInfo[9]);
		this.totalCost = Double.parseDouble(orderInfo[10]);
		this.orderDate = orderInfo[11];
	}

	private void addItemToList(int item) {
		DatabaseService db = new AccessInventory();
		String[] elements = db.selectInfo("item_id", Integer.toString(item)).get(0).split(",");
		items.add(new Item(elements));
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
	
	public List<Item> getItems(){
		return items;
	}
	
	public void setItemID(Item item){
		this.items.add(item);
	}

	public void setItemID(int id) {
		addItemToList(id);
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

	public String getBoxSize() {
	    return boxSize;
    }

    public void setBoxSize(I_Box box) {
		boxSize = box.boxName();
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

	public int getLoadingZone() {
		return loadingZone;
	}

	public void setLoadingZone(int loadingZone) {
		this.loadingZone = loadingZone;
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

	public boolean containsOrder(int itemId) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getItemID() == itemId) {
				return true;
			}
		}

		return false;
	}

	public String toString(int itemIndex) {
		return orderID + "," + custID + "," + items.get(itemIndex).getItemID() + "," + quantity + "," + shippingAddress + "," + loadingZone + "," + status + "," + boxSize + "," + orderPrice + "," + shippingCost + "," + totalCost + "," + orderDate;
	}
}