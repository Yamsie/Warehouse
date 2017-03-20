package UI.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


//item_id,item_type,manufacturer,size,stock_quantity,selling_price,purchase_price
//stock_order_id,item_id,quantity,manufacturer,price,
public class StockerView extends JFrame implements I_EmployeeView {
    private JLabel addNewItem = new JLabel("Please enter the detials of new item: ");
    private JLabel changeItem = new JLabel("Please change the detials of item: ");
    private JLabel ChooseItem = new JLabel("Plese enter the item id you want to change: ");
    private JLabel StockOrder = new JLabel("Plese enter the details of new order:  ");

    private JTextField choosItem = new JTextField(10);
    private JButton chooseButton = new JButton("Submit");

    private JTextField ItemID = new JTextField(10);
    private JLabel addItemID = new JLabel("Please enter New Item Id: ");

    private JTextField Item_Tpye = new JTextField(10);
    private JLabel addItem_Type = new JLabel("Please enter new Item Type: ");

    private JTextField Manufacturer = new JTextField(10);
    private JLabel addManufacturer = new JLabel("Please enter new Item Manufacturer: ");

    private JTextField Size = new JTextField(10);
    private JLabel addSize = new JLabel("Please enter the Item size: ");

    private JTextField Stock_quantity= new JTextField(10);
    private JLabel addStock_quantity = new JLabel("Please enter the quantity: ");

    private JTextField Selling_price= new JTextField(10);
    private JLabel addSelling_price = new JLabel("Please enter selling price: ");

    private JTextField Purchase_price= new JTextField(10);
    private JLabel addPurchase_price = new JLabel("Please enter purchase price: ");

    private JTextField ItemID1 = new JTextField(10);
    private JLabel changeItemID = new JLabel("Please enter New Item Id: ");

    private JTextField Item_Tpye1 = new JTextField(10);
    private JLabel changeItem_Type = new JLabel("Please enter new Item Type: ");

    private JTextField Manufacturer1 = new JTextField(10);
    private JLabel changeManufacturer = new JLabel("Please enter new Item Manufacturer: ");

    private JTextField Size1 = new JTextField(10);
    private JLabel changeSize = new JLabel("Please enter the Item size: ");

    private JTextField Stock_quantity1= new JTextField(10);
    private JLabel changeStock_quantity = new JLabel("Please enter the quantity: ");

    private JTextField Selling_price1= new JTextField(10);
    private JLabel changeSelling_price = new JLabel("Please enter selling price: ");

    private JTextField Purchase_price1= new JTextField(10);
    private JLabel changePurchase_price = new JLabel("Please enter purchase price: ");

    //stock_order_id,item_id,quantity,manufacturer,price,
    private JTextField stock_Order_Id = new JTextField(10);
    private JLabel stockOrderId = new JLabel("Plaese enter the stock order ID: ");

    private JTextField item_Id = new JTextField(10);
    private JLabel itemId = new JLabel("Please enter the item ID: ");

    private JTextField item_Quantity = new JTextField(10);
    private JLabel itemQuantity = new JLabel("Please enter the quantity: ");

    private JTextField item_Manufacturer = new JTextField(10);
    private JLabel itemManufacturer = new JLabel("Please enter the manufacturer: ");

    private JTextField item_Price = new JTextField(10);
    private JLabel itemPrice = new JLabel("Please enter the price: ");

    private JButton addButton = new JButton("Add");
    private JButton changeButton = new JButton("Change");
    private JButton newStockOrder = new JButton("Create order");
    private JButton LogoutButton = new JButton("Log out");


    public StockerView(String Stocker) {
        JPanel NorthPanel = new JPanel();
        JPanel CenterPanel = new JPanel();
        JPanel SouthPanel = new JPanel();
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        JPanel Panel4 = new JPanel();
        Panel1.setLayout(new GridLayout(7, 2));
        Panel2.setLayout(new GridLayout(8, 2));
        Panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        Panel4.setLayout(new GridLayout(6,2));

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Stocker Page");
        this.setVisible(true);
        this.setLocation(500, 10);
        this.setSize(500, 720);

        Panel1.add(addItemID);
        Panel1.add(ItemID);
        Panel1.add(addItem_Type);
        Panel1.add(Item_Tpye);
        Panel1.add(addManufacturer);
        Panel1.add(Manufacturer);
        Panel1.add(addSize);
        Panel1.add(Size);
        Panel1.add(addStock_quantity);
        Panel1.add(Stock_quantity);
        Panel1.add(addSelling_price);
        Panel1.add(Selling_price);
        Panel1.add(addPurchase_price);
        Panel1.add(Purchase_price);

        Panel2.add(changeItemID);
        Panel2.add(ItemID1);
        Panel2.add(changeItem_Type);
        Panel2.add(Item_Tpye1);
        Panel2.add(changeManufacturer);
        Panel2.add(Manufacturer1);
        Panel2.add(changeSize);
        Panel2.add(Size1);
        Panel2.add(changeStock_quantity);
        Panel2.add(Stock_quantity1);
        Panel2.add(changeSelling_price);
        Panel2.add(Selling_price1);
        Panel2.add(changePurchase_price);
        Panel2.add(Purchase_price1);
        Panel2.add(changeButton);

        Panel3.add(ChooseItem);
        Panel3.add(choosItem);
        Panel3.add(chooseButton);

        Panel4.add(stockOrderId);
        Panel4.add(stock_Order_Id);
        Panel4.add(itemId);
        Panel4.add(item_Id);
        Panel4.add(itemQuantity);
        Panel4.add(item_Quantity);
        Panel4.add(itemManufacturer);
        Panel4.add(item_Manufacturer);
        Panel4.add(itemPrice);
        Panel4.add(item_Price);
        Panel4.add(newStockOrder);

        NorthPanel.setLayout(new BorderLayout());
        NorthPanel.add(addNewItem, BorderLayout.NORTH);
        NorthPanel.add(Panel1, BorderLayout.CENTER);
        NorthPanel.add(addButton, BorderLayout.SOUTH);

        CenterPanel.setLayout(new BorderLayout());
        CenterPanel.add(Panel3,BorderLayout.NORTH);
        CenterPanel.add(changeItem, BorderLayout.CENTER);
        CenterPanel.add(Panel2, BorderLayout.SOUTH);

        SouthPanel.setLayout(new BorderLayout());
        SouthPanel.add(StockOrder, BorderLayout.NORTH);
        SouthPanel.add(Panel4, BorderLayout.CENTER);
        SouthPanel.add(LogoutButton, BorderLayout.SOUTH);


        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(NorthPanel);
        add(CenterPanel);
        add(SouthPanel);
    }

    public String getChooseId(){ return ChooseItem.getText();}

    private String getItemId() {
        return ItemID.getText();
    }
    private String getItemId1() {
        return ItemID1.getText();
    }
    private String getItemTpye() {
        return Item_Tpye.getText();
    }
    private String getItemTpye1() {
        return Item_Tpye1.getText();
    }
    private String getManufacturer() {
        return Manufacturer.getText();
    }
    private String getManufacturer1() {
        return Manufacturer1.getText();
    }
    private String getSize0() {
        return Size.getText();
    }
    private String getSize1() {
        return Size1.getText();
    }
    private String getStock_quantity() {
        return Stock_quantity.getText();
    }
    private String getStock_quantity1() {
        return Stock_quantity1.getText();
    }
    private String getSelling_price() {
        return Selling_price.getText();
    }
    private String getSelling_price1() {
        return Selling_price1.getText();
    }
    private String getPurchase_price() {
        return Purchase_price.getText();
    }
    private String getPurchase_price1() {
        return Purchase_price1.getText();
    }
    private String getStockOrderId() { return stock_Order_Id.getText();}
    private String getStockOrderItemId() { return item_Id.getText();}
    private String getStockOrderItemQuantity() { return item_Quantity.getText();}
    private String getStockItemManufacturer() { return item_Manufacturer.getText();}
    private String getStockItemPrice() { return item_Price.getText();}

    private void setItemId1(String ID) {
        ItemID1.setText(ID);
    }

    private void setItem_Tpye1(String type) {
        Item_Tpye1.setText(type);
    }

    private void setManufacturer1(String manufacturer) {
        Manufacturer1.setText(manufacturer);
    }

    private void setSize1(String size) {
        Size1.setText(size);
    }

    private void setStock_quantity1(String quantity) {
        Stock_quantity1.setText(quantity);
    }

    private void setSelling_price1(String price) {
        Selling_price1.setText(price);
    }

    private void setPurchase_price1(String price) {
        Purchase_price1.setText(price);
    }

    public String[] newItem(StockerView view){
        String[] Item = new String[7];
        Item[0] = view.getItemId();
        Item[1] = view.getItemTpye();
        Item[2] = view.getManufacturer();
        Item[3] = view.getSize0();
        Item[4] = view.getStock_quantity();
        Item[5] = view.getSelling_price();
        Item[6] = view.getPurchase_price();
        return Item;
    }

    public void setChangeInfo(String[] Item){
        setItemId1(Item[0]);
        setItem_Tpye1(Item[1]);
        setManufacturer1(Item[2]);
        setSize1(Item[3]);
        setStock_quantity1(Item[4]);
        setSelling_price1(Item[5]);
        setPurchase_price1(Item[6]);
    }

    public String[] getChange(){
        String Item[] = new String[7];
        Item[0] = getItemId1();
        Item[1] = getItemTpye1();
        Item[2] = getManufacturer1();
        Item[3] = getSize1();
        Item[4] = getStock_quantity1();
        Item[5] = getSelling_price1();
        Item[6] = getPurchase_price1();
        return Item;
    }

    //stock_order_id,item_id,quantity,manufacturer,price,
    public String[] getNewStockOrder(){
        String Item[] = new String[5];
        Item[0] = getStockOrderId();
        Item[1] = getStockOrderItemId();
        Item[2] = getStockOrderItemQuantity();
        Item[3] = getStockItemManufacturer();
        Item[4] = getStockItemPrice();
        return Item;
    }

    public void LogoutListener(ActionListener listenForButton) {
        LogoutButton.addActionListener(listenForButton);
    }

    public void chooseListener(ActionListener listenForButton) {
        chooseButton.addActionListener(listenForButton);
    }

    public void addListener(ActionListener listenForButton) {
        addButton.addActionListener(listenForButton);
    }

    public void changeListener(ActionListener listenForButton) {
        changeButton.addActionListener(listenForButton);
    }

    public void newStockOrderListener(ActionListener listenForButton){ newStockOrder.addActionListener(listenForButton);}

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}