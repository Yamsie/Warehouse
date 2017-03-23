package BLL.Model.Inventory;

public class Item
{
	private String itemType;
	private String manufacturer;
	private String size;
	private int itemID;
	private int quantity;
	private double sPrice;
	private double pPrice;

	public Item(int itemID, String itemType, String manufacturer, String size, int quantity, double sPrice, double pPrice)	//Item constructor method
	{

		this.itemID = itemID;					//"this.itemID" refers to the current itemID
		this.itemType = itemType;				//that was created when we called this constructor while
		this.manufacturer = manufacturer;		//the second "itemID" refers to the parameter of the constructor!
		this.size = size;
		this.quantity = quantity;
		this.sPrice = sPrice;
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return itemID + "," + itemType + "," + manufacturer + "," + size + "," + quantity + "," + sPrice + "," + pPrice;
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

	public int getItemID() {
		return itemID;
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

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setsPrice(double sPrice) {
		this.sPrice = sPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

}