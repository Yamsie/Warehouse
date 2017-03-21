package BLL.Model.Orders;

public class StockOrder implements I_Order //accessing customer orders file
{
	private int stockOrderID;
	private int stockItemID;
	private int orderQuantity;
	private String manufacturer;
	private double stockOrderPrice;
	
	public void Order(int stockOrderID, int itemID, int orderQuantity, String manufacturer, double stockOrderPrice)
	{
		this.stockOrderID = stockOrderID;
		this.itemID = itemID;
		this.orderQuantity = orderQuantity;
		this.manufacturer = manufactuer;
		this.stockOrderPrice = stockOrderPrice;
	}
	
	public int getStockOrderID() {
		return stockOrderID;
	}
	
	public void setStockOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	
	public int getStockItemID(){
		return stockItemID;
	}
	
	public void setStockItemID(int stockItemID){
		this.stockItemID = stockItemID
	}
	
	public int getOrderQuantity() {
		return quantity;
	}
	
	public void setOrderQuantity(int OrderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public double getStockOrderPrice() {
		return stockOrderPrice;
	}

	public void setStockOrderPrice(double stockOrderPrice) {
		this.stockOrderPrice = stockOrderPrice;
	}
	
	public string getManufacturer(){
		return manufacturer;
	}
	
	public void setManufacturer(string manufacturer){
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString()
	{
		return stockOrderID + "," + stockItemID + "," + quantity + "," + manufacturer + "," price;
	}
}