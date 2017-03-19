package BLL.Model.Inventory;
import java.util.ArrayList;

public class StockDetail
{
	private int itemID;
	private String itemType;
	private String manufacturer;
	private String size;
	private int quantity;
	private double sPrice;
	private double pPrice;
	
	public void change_Stock(int itemId, String[])	//Should this not take an int indicating new stock levels?
	{												//Or is String[] taking setting every attribute of the stock?
		this.itemID = id;
		this.itemType = type;
		this.manufacturer = maufacturer;
		this.size = size;
		this.quantity = quantity;					//New int should be placed here?
		this.sPrice = sPrice;
		this.pPrice = pPrice;
	}
	
	public String[] ShowAll_Items()
	{
		return allItems;
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public String getItemType() {
		return itemType;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public String getSize() {
		return size;
	}
	
	public int quantity() {
		return quantity;
	}
	
	public double sPrice() {
		return sPrice;
	}
	
	public double pPrice() {
		return pPrice;
	}
}