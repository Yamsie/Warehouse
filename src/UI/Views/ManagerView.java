package UI.Views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import UI.Controller.ManagerController;
/**
 * Created by James on 2017/3/12.
 */
public class ManagerView extends JFrame implements I_EmployeeView {
    //private JTextField userName = new JTextField(20);
    //private JLabel additionLabel1 = new JLabel("USERNAME");
    //private JTextField passWord = new JTextField(20);
    //private JLabel additionLabel2 = new JLabel("PASSWORD");
    //private JButton Button = new JButton("Submit");

    private JButton employeeButton = new JButton("View Orders");
    private JButton orderButton = new JButton("View Employees");
    private JButton customerButton = new JButton("View Customers");
    private JLabel nameLabel = new JLabel("Logged in as: ");


    //private JLabel empLabel = new JLabel("View All Orders");
    //private JLabel orderLabel = new JLabel("View Employees");
    //private JLabel customerLabel = new JLabel("View Customers");



    public ManagerView(String userName){
        nameLabel.setText(nameLabel.getText() + userName);
        JPanel buttonsPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel displayPanel = new JPanel();
        JLabel displayField = new JLabel();
        JScrollPane scroller = new JScrollPane(displayField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Manager Window");
        this.setSize(600, 600);
        displayField.setSize(30,50);
        displayField.setText("");

        buttonsPanel.add(employeeButton);
        buttonsPanel.add(orderButton);
        buttonsPanel.add(customerButton);
        namePanel.add(nameLabel);
        displayPanel.add(scroller);

        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.WEST);
        add(namePanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.SOUTH);
    }

    public void employeeListener(ActionListener listenForButton) {
        employeeButton.addActionListener(listenForButton);
    }

    public void customerListener(ActionListener listenForButton) {
        employeeButton.addActionListener(listenForButton);
    }

    public void orderListener(ActionListener listenForButton) {
        employeeButton.addActionListener(listenForButton);
    }

    public void displayEmployees() {

    }

    public void displayCustomers() {

    }

    public void displayOrders() {

    }




    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}