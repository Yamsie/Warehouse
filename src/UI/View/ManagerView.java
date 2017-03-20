package UI.View;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by James on 2017/3/12.
 */
public class ManagerView extends JFrame implements I_EmployeeView {
    private JButton employeeButton = new JButton("View Employees");
    private JButton orderButton = new JButton("View Orders");
    private JButton customerButton = new JButton("View Customers");
    private JLabel nameLabel = new JLabel("Logged in as: ");
    //private JLabel displayField = new JLabel();
    private DefaultTableModel model = new DefaultTableModel();
    private JTable displayTable = new JTable(model);;
    private String rows[][];
    private String columns[][];


    //private JLabel empLabel = new JLabel("View All Orders");
    //private JLabel orderLabel = new JLabel("View Employees");
    //private JLabel customerLabel = new JLabel("View Customers");



    public ManagerView(String userName){
        nameLabel.setText(nameLabel.getText() + userName);
        JPanel buttonsPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel displayPanel = new JPanel();
        JScrollPane scroller = new JScrollPane(displayTable);
//        displayTable.setFillsViewportHeight(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Manager Window");
        this.setSize(500, 500);

        buttonsPanel.add(employeeButton);
        buttonsPanel.add(orderButton);
        buttonsPanel.add(customerButton);
        namePanel.add(nameLabel);
        displayPanel.add(displayTable);
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

    public void setDisplayText(String[][] output) {
        clearDisplayText();
        for (int i = 0; i < output[0].length; i++) {
            model.addColumn(output[0][i]);
        }



        for (int i = 1; i < output.length; i++) {
            model.addRow(output[i]);
        }



    }
    public void clearDisplayText() {
    }
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}