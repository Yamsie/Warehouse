package UI.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by JiasenTian on 2017/3/13.
 */
public class PickerView extends JFrame implements I_EmployeeView {
    private JTextField ItemID = new JTextField(20);
    private JLabel additionLabel1 = new JLabel("Please enter the Item Id: ");
    public  JTextArea ItemInfo = new JTextArea(10, 20);
    private JTextField oderID = new JTextField(20);
    private JLabel additionLabel2 = new JLabel("Please enter the order Id: ");
    public  JTextArea orderInfo = new JTextArea(10,20);
    private JButton ItemButton = new JButton("Submit");
    private JButton OrderButton = new JButton("Submit");
    private JButton LogoutButton = new JButton("Log out");

    private JLabel additionLabel3 = new JLabel("Click the button to show all the order ID");
    private  JButton allOrderButton = new JButton("Show Orders ID");
    public JTextArea orderIDs  = new JTextArea(10,20);

    public PickerView(String name){
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        JPanel Panel4 = new JPanel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Picker Page");
        this.setVisible(true);
        this.setSize(500, 800);
        ItemInfo.setLineWrap(true);
        ItemInfo.setWrapStyleWord(true);
        ItemInfo.setEditable(false);
        orderInfo.setLineWrap(true);
        orderInfo.setWrapStyleWord(true);
        orderInfo.setEditable(false);
        orderIDs.setLineWrap(true);
        orderIDs.setWrapStyleWord(true);
        orderIDs.setEditable(false);

        JScrollPane scrollPane1 = new JScrollPane(ItemInfo);
        JScrollPane scrollPane2 = new JScrollPane(orderInfo);
        JScrollPane scrollPane3 = new JScrollPane(orderIDs);

        JPanel section1 = new JPanel(new BorderLayout());
        JPanel section2 = new JPanel(new BorderLayout());
        JPanel section3 = new JPanel(new BorderLayout());

        Panel1.add(additionLabel1);
        Panel1.add(ItemID);
        Panel1.add(ItemButton);
        section1.add(Panel1, BorderLayout.NORTH);
        section1.add(scrollPane1, BorderLayout.SOUTH);

        Panel2.add(additionLabel2);
        Panel2.add(oderID);
        Panel2.add(OrderButton);
        section2.add(Panel2, BorderLayout.NORTH);
        section2.add(scrollPane2, BorderLayout.SOUTH);

        Panel3.add(additionLabel3);
        Panel3.add(allOrderButton);
        section3.add(Panel3, BorderLayout.NORTH);
        section3.add(scrollPane3, BorderLayout.CENTER);

        Panel4.add(LogoutButton);

        setLayout(new GridLayout(4,1));
        add(section1);
        add(section2);
        add(section3);
        add(Panel4);

    }
    public String getItemId() {
        return ItemID.getText();
    }

    public String getOrderId() {
        return oderID.getText();
    }

    public String createOrderDescription(String [] detail){
        String description = "";
        description += "Order ID: " + detail[0] + "\t"
                + "Customer ID: " + detail[1] + "\n"
                + "Item ID: " + detail[2] + "\t"
                + "Order Quantity: " + detail[3] + "\n"
                + "Ststus: " + detail[4] + "\t"
                + "Box Size: " + detail[5] + "\n"
                + "Order Price: " + detail[6] + "\t"
                + "Shipping Price: " + detail[7] + "\n"
                + "Total Price: " + detail[8] + "\t"
                + "Order Date: " + detail[9] + "\n"
                + "Shipping Address: " + detail[10] + "\n";
        return description;
    }

    //#item_id,item_type,manufacturer,size,volume,stock_quantity,selling_price,purchase_price
    public String createItemDescription(String [] ItemInfo){
        String description = "";
        description += "Item Id: " + ItemInfo[0] + "\tItem Type: " + ItemInfo[1] + "\n\nManufacturer: " + ItemInfo[2]
                + "\tSize: " +  ItemInfo[3] + "\n\nVolum" + ItemInfo[4] + "\t\tStock Quantity: " + ItemInfo[5] + "\n\nSelling Price: " + ItemInfo[6]
                + "\tPurchase Price: " + ItemInfo[7];
        return description;
    }

    public String createIdDescription(int [] ids){
        String description = "";
        for(int i = 0; i < ids.length; ++i)
            description += "Order " + (i + 1) + " : " + ids[i] + "\n";
        return description;
    }

    public void LogoutListener(ActionListener listenForButton) {
        LogoutButton.addActionListener(listenForButton);
    }

    public void SubListener1(ActionListener listenForButton) {
        ItemButton.addActionListener(listenForButton);
    }

    public void SubListener2(ActionListener listenForButton) {
        OrderButton.addActionListener(listenForButton);
    }

    public void SubListener3(ActionListener listenForButton) { allOrderButton.addActionListener(listenForButton);}

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
