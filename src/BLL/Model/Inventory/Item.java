package BLL.Model.Inventory;

public class Item
{
	private String itemType;
	private String manufacturer;
	private String size;
	private double volume;
	private int itemID;
	private int quantity;
	private double sPrice;
	private double pPrice;
	
	public Item(int itemID, String itemType, String manufacturer, String size, double volume, int quantity, double sPrice, double pPrice)
	{
		this.itemID = itemID;
		this.itemType = itemType;
		this.manufacturer = manufacturer;
		this.size = size;
		this.volume = volume;
		this.quantity = quantity;
		this.sPrice = sPrice;
		this.pPrice = pPrice;
	}

	public Item(String[] itemInfo)
	{
		this.itemID = Integer.parseInt(itemInfo[0]);
		this.itemType = itemInfo[1];
		this.manufacturer = itemInfo[2];
		this.size = itemInfo[3];
		this.volume = Double.parseDouble(itemInfo[4]);
		this.quantity = Integer.parseInt(itemInfo[5]);
		this.sPrice = Double.parseDouble(itemInfo[6]);
		this.pPrice = Double.parseDouble(itemInfo[7]);
	}
}