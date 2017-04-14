package BLL.Model.Order;

public class StockOrder
{
	private int stockOrderID;
	private int stockItemID;
	private String manufacturer;
	private int orderQuantity;
	private double price;

	public StockOrder(int stockOrderID, int stockItemID, String manufacturer, int orderQuantity, double price)
	{
		this.stockOrderID = stockOrderID;
		this.stockItemID = stockItemID;
		this.manufacturer = manufacturer;
		this.orderQuantity = orderQuantity;
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

	public String getManufacturer(){
		return manufacturer;
	}

	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
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
	
	@Override
	public String toString()
	{
		return stockOrderID + "," + stockItemID + "," + manufacturer + "," + orderQuantity + "," + price;
	}
}