package UI.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class LoaderView extends JFrame implements I_EmployeeView {

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

    public String createDescription(String [] chosenOrderInfo){
        String description = "";
        description += "Order ID: " + chosenOrderInfo[0] + "\n\nCustomer ID: " + chosenOrderInfo[1] + "\n\nItem ID: " + chosenOrderInfo[2]
                + "\n\nOrder Quantity: " +  chosenOrderInfo[3] + "\n\nShipping Address: " + chosenOrderInfo[4] + "\n\nLoading Zone: " + chosenOrderInfo[5]
                + "\n\nStatus: " + chosenOrderInfo[6] + "\n\nBox Size: " + chosenOrderInfo[7] + "\n\nOrder Price: " + chosenOrderInfo[8]
                + "\n\nShipping Price: " + chosenOrderInfo[9] + "\n\nTotal Price: " + chosenOrderInfo[10] + "\n\nOrder Date: " + chosenOrderInfo[11];
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