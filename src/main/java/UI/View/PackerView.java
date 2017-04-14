package UI.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by JiasenTain on 2017/3/13.
 */
public class PackerView extends JFrame implements I_EmployeeView {
    private JTextField ItemID = new JTextField(20);
    private JLabel additionLabel1 = new JLabel("Please enter the Item Id: ");
    private JTextArea itemInfo = new JTextArea(10, 20);
    private JTextField orderID = new JTextField(20);
    private JLabel additionLabel2 = new JLabel("Please enter the order Id: ");
    private JTextArea orderInfo = new JTextArea(10,20);
    private JButton ItemButton = new JButton("Pack Item");
    private JButton OrderButton = new JButton("Set");
    private JButton boxItems = new JButton("Box Items");
    private JButton LogoutButton = new JButton("Log out");

    public PackerView(String packer){
        JPanel LoginPanel1 = new JPanel();
        JPanel LoginPanel2 = new JPanel();
        JPanel LoginPanel3 = new JPanel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Packer Page");
        this.setVisible(true);
        this.setSize(500, 500);
        itemInfo.setLineWrap(true);
        itemInfo.setWrapStyleWord(true);
        itemInfo.setEditable(false);
        orderInfo.setLineWrap(true);
        orderInfo.setWrapStyleWord(true);
        orderInfo.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(itemInfo);
        JScrollPane scrollPane2 = new JScrollPane(orderInfo);
        JPanel section1 = new JPanel(new BorderLayout());
        JPanel section2 = new JPanel(new BorderLayout());

        LoginPanel1.add(additionLabel1);
        LoginPanel1.add(ItemID);
        LoginPanel1.add(ItemButton);
        section1.add(LoginPanel1, BorderLayout.NORTH);
        section1.add(scrollPane1, BorderLayout.SOUTH);

        LoginPanel2.add(additionLabel2);
        LoginPanel2.add(orderID);
        LoginPanel2.add(OrderButton);
        section2.add(LoginPanel2, BorderLayout.NORTH);
        section2.add(scrollPane2, BorderLayout.SOUTH);
        LoginPanel3.add(LogoutButton);
        LoginPanel3.add(boxItems);


        setLayout(new BorderLayout());
        add(section2, BorderLayout.NORTH);
        add(section1, BorderLayout.CENTER);
        add(LoginPanel3,BorderLayout.SOUTH);
    }

    public String getItemId() {
        return ItemID.getText();
    }

    public String getOrderId() {
        return orderID.getText();
    }

    public void setOrderInfo(String info) {
        orderInfo.setText(info);
    }

    public void setItemInfo(String info) {
        itemInfo.setText(info);
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

    public void SubListener3(ActionListener listenForButton) {
        boxItems.addActionListener(listenForButton);
    }


    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
