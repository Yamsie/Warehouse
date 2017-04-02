package UI.View;

import BLL.Model.Inventory.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StockerView extends JFrame implements I_EmployeeView
{
    private JButton Button = new JButton("Log out");

    //Add New Item

    private JLabel addNewItemLabel = new JLabel("Please Enter the Detials of New Item: ");

    private JLabel addItemIDLabel = new JLabel("Please enter Item ID: ");
    private JTextField addItemID = new JTextField(10);

    private JLabel addItemTypeLabel = new JLabel("Please enter Item Type: ");
    private JTextField addItemType = new JTextField(10);

    private JLabel addManufacturerLabel = new JLabel("Please enter Item Manufacturer: ");
    private JTextField addManufacturer = new JTextField(10);

    private JLabel addSizeLabel = new JLabel("Please enter Item Size: ");
    private JTextField addSize = new JTextField(10);

    private JLabel addVolumeLabel = new JLabel("Please enter Item Volume: ");
    private JTextField addVolume = new JTextField(10);

    private JLabel addQuantityLabel = new JLabel("Please enter the Quantity: ");
    private JTextField addQuantity = new JTextField(10);

    private JLabel addSellingPriceLabel = new JLabel("Please enter Selling Price: ");
    private JTextField addSellingPrice = new JTextField(10);

    private JLabel addPurchasePriceLabel = new JLabel("Please enter Purchase Price: ");
    private JTextField addPurchasePrice = new JTextField(10);

    private JButton addButton = new JButton("Add");

    //Choose Item you wish to change

    private JLabel chooseItemToChangeLabel = new JLabel("Plese Enter the Item ID you want to change: ");

    private JButton chooseButton = new JButton("Submit");
    private JTextField chooseItem = new JTextField(10);

    //Change Existing Item

    private JLabel changeItemLabel = new JLabel("Please Enter Changed Detials of Item: ");

    private JLabel changeItemIDLabel = new JLabel("Please enter Item ID: ");
    private JTextField changeItemID = new JTextField(10);

    private JLabel changeItemTypeLabel = new JLabel("Please enter Item Type: ");
    private JTextField changeItemType = new JTextField(10);

    private JLabel changeManufacturerLabel = new JLabel("Please enter Item Manufacturer: ");
    private JTextField changeManufacturer = new JTextField(10);

    private JLabel changeSizeLabel = new JLabel("Please enter the Item Size: ");
    private JTextField changeSize = new JTextField(10);

    private JLabel changeVolumeLabel = new JLabel("Please enter the Item Volume: ");
    private JTextField changeVolume = new JTextField(10);

    private JLabel changeQuantityLabel = new JLabel("Please enter the Quantity: ");
    private JTextField changeQuantity = new JTextField(10);

    private JLabel changeSellingPriceLabel = new JLabel("Please enter Selling Price: ");
    private JTextField changeSellingPrice = new JTextField(10);

    private JLabel changePurchasePriceLabel = new JLabel("Please enter Purchase Price: ");
    private JTextField changePurchasePrice = new JTextField(10);

    private JButton changeButton = new JButton("Change");

    ////Create New Stock Order
    //
    //private JLabel stockOrderLabel = new JLabel("Please Enter Details of Stock Order: ");
    //
    //private JLabel stockOrderIDLabel = new JLabel("Plaese enter the Stock Order ID: ");
    //private JTextField stockOrderID = new JTextField(10);
    //
    //private JLabel orderItemIDLabel = new JLabel("Please enter the Item ID: ");
    //private JTextField orderItemID = new JTextField(10);
    //
    //private JLabel orderItemManufacturerLabel = new JLabel("Please enter the Manufacturer: ");
    //private JTextField orderItemManufacturer = new JTextField(10);
    //
    //private JLabel orderItemQuantityLabel = new JLabel("Please enter the Quantity: ");
    //private JTextField orderItemQuantity = new JTextField(10);
    //
    //private JButton newStockOrder = new JButton("Create order");

    //Logout Button

    private JButton logoutButton = new JButton("Log out");

    //GUI Layout

    public StockerView(String Stocker) {
        JPanel NorthPanel = new JPanel();
        JPanel CenterPanel = new JPanel();
        JPanel SouthPanel = new JPanel();
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        //JPanel Panel4 = new JPanel();
        Panel1.setLayout(new GridLayout(8, 2));
        Panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        Panel3.setLayout(new GridLayout(9, 2));
        //Panel4.setLayout(new GridLayout(6,2));

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Stocker Page");
        this.setVisible(true);
        this.setLocation(500, 10);
        this.setSize(500, 720);

        Panel1.add(addItemIDLabel);
        Panel1.add(addItemID);
        Panel1.add(addItemTypeLabel);
        Panel1.add(addItemType);
        Panel1.add(addManufacturerLabel);
        Panel1.add(addManufacturer);
        Panel1.add(addSizeLabel);
        Panel1.add(addSize);
        Panel1.add(addVolumeLabel);
        Panel1.add(addVolume);
        Panel1.add(addQuantityLabel);
        Panel1.add(addQuantity);
        Panel1.add(addSellingPriceLabel);
        Panel1.add(addSellingPrice);
        Panel1.add(addPurchasePriceLabel);
        Panel1.add(addPurchasePrice);

        Panel2.add(chooseItemToChangeLabel);
        Panel2.add(chooseButton);
        Panel2.add(chooseItem);

        Panel3.add(changeItemIDLabel);
        Panel3.add(changeItemID);
        Panel3.add(changeItemTypeLabel);
        Panel3.add(changeItemType);
        Panel3.add(changeManufacturerLabel);
        Panel3.add(changeManufacturer);
        Panel3.add(changeSizeLabel);
        Panel3.add(changeSize);
        Panel3.add(changeVolumeLabel);
        Panel3.add(changeVolume);
        Panel3.add(changeQuantityLabel);
        Panel3.add(changeQuantity);
        Panel3.add(changeSellingPriceLabel);
        Panel3.add(changeSellingPrice);
        Panel3.add(changePurchasePriceLabel);
        Panel3.add(changePurchasePrice);
        Panel3.add(changeButton);

        //Panel4.add(stockOrderIDLabel);
        //Panel4.add(stockOrderID);
        //Panel4.add(orderItemIDLabel);
        //Panel4.add(orderItemID);
        //Panel4.add(orderItemManufacturerLabel);
        //Panel4.add(orderItemManufacturer);
        //Panel4.add(orderItemQuantityLabel);
        //Panel4.add(orderItemQuantity);
        //Panel4.add(newStockOrder);

        NorthPanel.setLayout(new BorderLayout());
        NorthPanel.add(addNewItemLabel, BorderLayout.NORTH);
        NorthPanel.add(Panel1, BorderLayout.CENTER);
        NorthPanel.add(addButton, BorderLayout.SOUTH);

        CenterPanel.setLayout(new BorderLayout());
        CenterPanel.add(Panel2,BorderLayout.NORTH);
        CenterPanel.add(changeItemLabel, BorderLayout.CENTER);
        CenterPanel.add(Panel3, BorderLayout.SOUTH);

        SouthPanel.setLayout(new BorderLayout());
        //SouthPanel.add(stockOrderLabel, BorderLayout.NORTH);
        //SouthPanel.add(Panel4, BorderLayout.CENTER);
        SouthPanel.add(logoutButton, BorderLayout.SOUTH);


        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(NorthPanel);
        add(CenterPanel);
        add(SouthPanel);
    }

    //Button Listeners

    public void addNewItemListener(ActionListener listenForButton) {								//Listener for 'Add' Button
        addButton.addActionListener(listenForButton);
    }

    public void chooseListener(ActionListener listenForButton) {									//Listener for 'Choose' Button
        chooseButton.addActionListener(listenForButton);
    }

    public void changeItemDetailsListener(ActionListener listenForButton) {							//Listener for 'Change' Button
        changeButton.addActionListener(listenForButton);
    }

    // public void newStockOrderListener(ActionListener listenForButton){							//Listner for 'New Stock Order' Button
    //	newStockOrder.addActionListener(listenForButton);
    //}

    public void logoutListener(ActionListener listenForButton) {									//Listener for 'Logout' Button
        logoutButton.addActionListener(listenForButton);
    }

    public Item newItem(){
        int itemID = Integer.parseInt(getNewItemID());
        String itemType = getNewItemType();
        String manufacturer = getNewManufacturer();
        String size = getNewSize();
        double volume = Double.parseDouble(getNewVolume());
        int quantity = Integer.parseInt(getNewQuantity());
        double sPrice = Double.parseDouble(getNewSellingPrice());
        double pPrice = Double.parseDouble(getNewPurchasePrice());
        Item createdItem = new Item(itemID,itemType,manufacturer,size,volume,quantity,sPrice,pPrice);
        return createdItem;
    }

    public void setChangeInfo(String[] chosenItemInfo){
        setChangeItemID(chosenItemInfo[0]);
        setChangeItemType(chosenItemInfo[1]);
        setChangeManufacturer(chosenItemInfo[2]);
        setChangeSize(chosenItemInfo[3]);
        setChangeVolume(chosenItemInfo[4]);
        setChangeQuantity(chosenItemInfo[5]);
        setChangeSellingPrice(chosenItemInfo[6]);
        setChangePurchasePrice(chosenItemInfo[7]);
    }

    public Item changeItem(){
        int itemID = Integer.parseInt(getChangeItemID());
        String itemType = getChangeItemType();
        String manufacturer = getChangeManufacturer();
        String size = getChangeSize();
        double volume = Double.parseDouble(getChangeVolume());
        int quantity = Integer.parseInt(getChangeQuantity());
        double sPrice = Double.parseDouble(getChangeSellingPrice());
        double pPrice = Double.parseDouble(getChangePurchasePrice());
        Item changedItem = new Item(itemID,itemType,manufacturer,size,volume,quantity,sPrice,pPrice);
        return changedItem;
    }

    //public StockOrder newStockOrder(){					//Gets details of new stock order to be added to STOCK_ORDERS.txt
    //    int stockOrderID = Integer.parseInt(getStockOrderID());
    //    int itemID = Integer.parseInt(getOrderItemID();
    //    String manufacturer = getOrderItemManufacturer());
    //    int quantity = Integer.parseInt(getOrderItemQuantity());
    //	  StockOrder createdStockOrder = newStockOrder(stockOrderID,itemID,manufacturer,quantity);
    //    return createdStockOrder;
    //}

    //Get Methods for 'Add Item'

    public String getNewItemID() {
        return addItemID.getText();
    }

    public String getNewItemType() {
        return addItemType.getText();
    }

    public String getNewManufacturer() {
        return addManufacturer.getText();
    }

    public String getNewSize() {
        return addSize.getText();
    }

    public String getNewVolume() {
        return addVolume.getText();
    }

    public String getNewQuantity() {
        return addQuantity.getText();
    }

    public String getNewSellingPrice() {
        return addSellingPrice.getText();
    }

    public String getNewPurchasePrice() {
        return addPurchasePrice.getText();
    }

    //Get method for 'Choose Item'

    public String getChooseItem() {
        return chooseItem.getText();
    }

    //Get methods for 'Change Item'

    public String getChangeItemID() {
        return changeItemID.getText();
    }

    public String getChangeItemType() {
        return changeItemType.getText();
    }

    public String getChangeManufacturer() {
        return changeManufacturer.getText();
    }

    public String getChangeSize() {
        return changeSize.getText();
    }

    public String getChangeVolume() {
        return changeVolume.getText();
    }

    public String getChangeQuantity() {
        return changeQuantity.getText();
    }

    public String getChangeSellingPrice() {
        return changeSellingPrice.getText();
    }

    public String getChangePurchasePrice() {
        return changePurchasePrice.getText();
    }

    //Set methods for 'Change Item' (Used when ItemID entered to change item details)

    public void setChangeItemID(String itemID) {
        changeItemID.setText(itemID);
    }

    public void setChangeItemType(String itemType) {
        changeItemType.setText(itemType);
    }

    public void setChangeManufacturer(String manufacturer) {
        changeManufacturer.setText(manufacturer);
    }

    public void setChangeSize(String size) {
        changeSize.setText(size);
    }

    public void setChangeVolume(String volume) {
        changeVolume.setText(volume);
    }

    public void setChangeQuantity(String quantity) {
        changeQuantity.setText(quantity);
    }

    public void setChangeSellingPrice(String sellingPrice) {
        changeSellingPrice.setText(sellingPrice);
    }

    public void setChangePurchasePrice(String purchasePrice) {
        changePurchasePrice.setText(purchasePrice);
    }

    ////Get methods for 'New Stock Order'
    //
    //public String getStockOrderID() {
    //    return stockOrderID.getText();
    //}
    //
    //public String getOrderItemID() {
    //    return orderItemID.getText();
    //}
    //
    //public String getOrderItemManufacturer() {
    //    return orderItemManufacturer.getText();
    //}
    //
    //public String getOrderItemQuantity() {
    //    return orderItemQuantity.getText();
    //}

    //Error Message

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}