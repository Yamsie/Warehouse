package UI.Views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

import BLL.Models.Employees.Employee;
import UI.Controller.ManagerController;
/**
 * Created by James on 2017/3/12.
 */
public class ManagerView extends JFrame implements I_EmployeeView {
    private JButton employeeButton = new JButton("View Employees");
    private JButton orderButton = new JButton("View Orders");
    private JButton customerButton = new JButton("View Customers");
    private JLabel nameLabel = new JLabel("Logged in as: ");
    private JLabel displayField = new JLabel();


    //private JLabel empLabel = new JLabel("View All Orders");
    //private JLabel orderLabel = new JLabel("View Employees");
    //private JLabel customerLabel = new JLabel("View Customers");



    public ManagerView(String userName){
        nameLabel.setText(nameLabel.getText() + userName);
        JPanel buttonsPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel displayPanel = new JPanel();
        JScrollPane scroller = new JScrollPane(displayField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Manager Window");
        this.setSize(500, 500);
        displayField.setSize(30,50);
        displayField.setText("");

        buttonsPanel.add(employeeButton);
        buttonsPanel.add(orderButton);
        buttonsPanel.add(customerButton);
        namePanel.add(nameLabel);
        displayPanel.add(displayField);
        displayPanel.add(scroller);

        setLayout(new GridLayout(3,3));
        add(namePanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.WEST);
        add(displayPanel, BorderLayout.EAST);
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

    public void setDisplayText(String output) {
        displayField.setText(output);
    }
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}