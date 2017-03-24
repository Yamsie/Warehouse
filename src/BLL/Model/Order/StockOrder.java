package BLL.Model.Order

public class StockOrder
{
	private int stockOrderID;
	private int stockItemID;
	private int orderQuantity;
	private String manufacturer;
	private double price;
	
	public void Order(int stockOrderID, int itemID, int orderQuantity, String manufacturer, double price)
	{
		this.stockOrderID = stockOrderID;
		this.stockItemID = stockItemID;
		this.orderQuantity = orderQuantity;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	
	public int getStockOrderID() {
		return stockOrderID;
	}
	
	public void setStockOrderID(int stockOrderID) {
		this.stockOrderID = stockOrderID;
	}
	
	
	public int getStockItemID(){
		return stockItemID;
	}
	
	public void setStockItemID(int stockItemID){
		this.stockItemID = stockItemID;
	}
	
	public int getOrderQuantity() {
		return orderQuantity;
	}
	
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
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
		return stockOrderID + "," + stockItemID + "," + orderQuantity + "," + manufacturer + "," + price;
	}
}