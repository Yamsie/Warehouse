package UI.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class LoaderView extends JFrame {

    private JTextField oderID = new JTextField(20);
    private JLabel additionLabel2 = new JLabel("Please enter the order Id: ");
    public JTextArea orderInfo = new JTextArea(10, 20);
    private JButton OrderButton = new JButton("Submit");
    private JButton LogoutButton = new JButton("Log out");

    public LoaderView(String loader) {
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Loader Page");
        this.setVisible(true);
        this.setSize(500, 400);

        orderInfo.setLineWrap(true);
        orderInfo.setWrapStyleWord(true);
        orderInfo.setEditable(false);

        JScrollPane scrollPane2 = new JScrollPane(orderInfo);
        JPanel section = new JPanel(new BorderLayout());

        Panel2.add(additionLabel2);
        Panel2.add(oderID);
        Panel2.add(OrderButton);
        section.add(Panel2, BorderLayout.NORTH);
        section.add(scrollPane2, BorderLayout.SOUTH);
        Panel3.add(LogoutButton);


        setLayout(new BorderLayout());
        add(section, BorderLayout.CENTER);
        add(Panel3, BorderLayout.SOUTH);
    }

    public String getOrderId() {
        return oderID.getText();
    }

    public String createDescription(String [] OrderInfo){
        String description = "";
        description += "order_id: " + OrderInfo[0] + "\n\nCustomer Id: " + OrderInfo[1] + "\n\nItem ID: " + OrderInfo[2]
                + "\n\nOrder Quantity: " +  OrderInfo[3] + "\n\nStatus: " + OrderInfo[4] + "\n\nOrder Price: " + OrderInfo[5]
                + "\n\nShipping Price: " + OrderInfo[6] + "\n\nTotal Price: " + OrderInfo[7] + "\n\nOrder Date: " + OrderInfo[8];
        return description;
    }

    public void LogoutListener(ActionListener listenForButton) {
        LogoutButton.addActionListener(listenForButton);
    }

    public void SubListener(ActionListener listenForButton) {
        OrderButton.addActionListener(listenForButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}