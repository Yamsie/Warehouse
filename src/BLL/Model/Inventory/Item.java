public class Item
{
	public String itemType;
	public String manufacturer;
	public String size;
	public int itemID;	
	public int quantity;
	public double sPrice;
	public double pPrice;
	
	public Item(int itemID, String itemType, String manufacturer, String size, int quantity, double sPrice, double pPrice)
	{
		this.itemID = itemID;
		this.itemType = itemType;
		this.manufacturer = manufacturer;
		this.size = size;
		this.quantity = quantity;
		this.sPrice = sPrice;
		this.pPrice = pPrice;
	}
}