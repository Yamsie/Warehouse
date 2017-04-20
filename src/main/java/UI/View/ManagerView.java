package UI.View;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 * Created by James on 2017/3/12.
 */
public class ManagerView extends JFrame implements I_EmployeeView {
    private JButton employeeButton = new JButton("View Employees");
    private JButton orderButton = new JButton("View Orders");
    private JButton customerButton = new JButton("View Customers");
    //private JButton addEmployee = new JButton("Add New ");
    //private JButton addCustomer = new JButton("Add New ");
    //private JButton ad = new JButton("Add New ");

    private JLabel empIdLabel = new JLabel("ID: ");
    private JTextField employeeId = new JTextField(20);
    private JLabel empNameLabel = new JLabel("Name: ");
    private JTextField employeeName = new JTextField(20);
    private JLabel empPasswordLabel = new JLabel("Password: ");
    private JPasswordField employeePassword = new JPasswordField(20);
    private JLabel empJobTitleLabel = new JLabel("Job Title: ");
    private JTextField employeeJobTitle = new JTextField(20);
    private JLabel empEmailLabel = new JLabel("Email: ");
    private JTextField employeeEmail = new JTextField(20);
    private JButton addEmployeeButton = new JButton("Add Employee");

    private JLabel nameLabel = new JLabel("Logged in as: ");
    private DefaultTableModel model = new DefaultTableModel();
    private JTable displayTable = new JTable(model);

    public ManagerView(String userName){
        nameLabel.setText(nameLabel.getText() + userName);
        JPanel buttonsPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel displayPanel = new JPanel();
        JPanel newEmployeePanel = new JPanel();
        JScrollPane scroller = new JScrollPane(displayTable);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Manager Window");
        this.setSize(500, 800);

        buttonsPanel.add(employeeButton);
        buttonsPanel.add(orderButton);
        buttonsPanel.add(customerButton);
        namePanel.add(nameLabel);
        displayPanel.add(displayTable);
        displayPanel.add(scroller);
        newEmployeePanel.add(empIdLabel);
        newEmployeePanel.add(employeeId);
        newEmployeePanel.add(empNameLabel);
        newEmployeePanel.add(employeeName);
        newEmployeePanel.add(empPasswordLabel);
        newEmployeePanel.add(employeePassword);
        newEmployeePanel.add(empJobTitleLabel);
        newEmployeePanel.add(employeeJobTitle);
        newEmployeePanel.add(empEmailLabel);
        newEmployeePanel.add(employeeEmail);
        newEmployeePanel.add(addEmployeeButton);

        setLayout(new GridLayout(3,3));
        add(namePanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.WEST);
        add(displayPanel, BorderLayout.EAST);
        add(newEmployeePanel, BorderLayout.SOUTH);
    }

    public void employeeListener(ActionListener listenForButton) {
        employeeButton.addActionListener(listenForButton);
    }

    public void addEmployeeListener(ActionListener listenForButton) {
        addEmployeeButton.addActionListener(listenForButton);
    }

    public void setDisplayText(String[][] output) {
        for (int i = 0; i < output[0].length; i++) {
            model.addColumn(output[0][i]);
        }

        for (int i = 1; i < output.length; i++) {
            model.addRow(output[i]);
        }
    }

    public String getNewEmpId() {
        return employeeId.getText();
    }

    public String getNewEmpName() {
        return employeeName.getText();
    }

    public char[] getNewEmpPassword() {
        return employeePassword.getPassword();
    }

    public String getNewEmpJobTitle() {
        return employeeJobTitle.getText();
    }

    public String getNewEmpEmail() {
        return employeeEmail.getText();
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}