package UI.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by JiasenTian on 2017/3/13.
 */
public class PickerView extends JFrame{
    private JTextField ItemID = new JTextField(20);
    private JLabel additionLabel1 = new JLabel("Please enter the Item Id: ");
    public  JTextArea ItemInfo = new JTextArea(10, 20);
    private JTextField oderID = new JTextField(20);
    private JLabel additionLabel2 = new JLabel("Please enter the order Id: ");
    public  JTextArea orderInfo = new JTextArea(10,20);
    private JButton ItemButton = new JButton("Submit");
    private JButton OrderButton = new JButton("Submit");
    private JButton LogoutButton = new JButton("Log out");

    public PickerView(String name){
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Picker Page");
        this.setVisible(true);
        this.setSize(500, 500);
        ItemInfo.setLineWrap(true);
        ItemInfo.setWrapStyleWord(true);
        ItemInfo.setEditable(false);
        orderInfo.setLineWrap(true);
        orderInfo.setWrapStyleWord(true);
        orderInfo.setEditable(false);

        JScrollPane scrollPane1 = new JScrollPane(ItemInfo);
        JScrollPane scrollPane2 = new JScrollPane(orderInfo);

        JPanel section1 = new JPanel(new BorderLayout());
        JPanel section2 = new JPanel(new BorderLayout());

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
        Panel3.add(LogoutButton);

        setLayout(new BorderLayout(5,5));
        add(section1, BorderLayout.NORTH);
        add(section2, BorderLayout.CENTER);
        add(Panel3,BorderLayout.SOUTH);
    }
    public String getItemId() {
        return ItemID.getText();
    }

    public String getOrderId() {
        return oderID.getText();
    }

    public String createOrderDescription(String [] OrderInfo){
        String description = "";
        description += "order_id: " + OrderInfo[0] + "\n\nCustomer Id: " + OrderInfo[1] + "\n\nItem ID: " + OrderInfo[2]
                + "\n\nOrder Quantity: " +  OrderInfo[3] + "\n\nStatus: " + OrderInfo[4] + "\n\nOrder Price: " + OrderInfo[5]
                + "\n\nShipping Price: " + OrderInfo[6] + "\n\nTotal Price: " + OrderInfo[7] + "\n\nOrder Date: " + OrderInfo[8];
        return description;
    }

    public String createItemDescription(String [] ItemInfo){
        String description = "";
        description += "Item Id: " + ItemInfo[0] + "\n\nItem Type: " + ItemInfo[1] + "\n\nManufacturer: " + ItemInfo[2]
                + "\n\nSize: " +  ItemInfo[3] + "\n\nStock Quantity: " + ItemInfo[4] + "\n\nSelling Price: " + ItemInfo[5]
                + "\n\nPurchase Price: " + ItemInfo[6];
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

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
