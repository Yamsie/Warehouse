package BLL.Model.Orders;

import BLL.Model.Order.I_Order;

public class StockOrder implements I_Order //accessing customer orders file
{
	private int stockOrderID;
	private int stockItemID;
	private int orderQuantity;
	private String manufacturer;
	private double stockOrderPrice;
	
	StockOrder(int stockOrderID, int itemID, int orderQuantity, String manufacturer, double stockOrderPrice)
	{
		this.stockOrderID = stockOrderID;
		this.stockItemID = itemID;
		this.orderQuantity = orderQuantity;
		this.manufacturer = manufacturer;
		this.stockOrderPrice = stockOrderPrice;
	}
	
	public int getStockOrderID() {
		return stockOrderID;
	}
	
	//public void setStockOrderID(int orderID) {
	//	this.orderID = orderID;
	//}
	
	
	public int getStockItemID(){
		return stockItemID;
	}
	
	public void setStockItemID(int stockItemID){
		this.stockItemID = stockItemID;
	}
	
	//public int getOrderQuantity() {
	//	return quantity;
	//}
	
	public void setOrderQuantity(int OrderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public double getStockOrderPrice() {
		return stockOrderPrice;
	}

	public void setStockOrderPrice(double stockOrderPrice) {
		this.stockOrderPrice = stockOrderPrice;
	}
	
	public String getManufacturer(){
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString()
	{
		return null;//stockOrderID + "," + stockItemID + "," + quantity + "," + manufacturer + "," price;
	}
}