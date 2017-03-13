package UI.Views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import UI.Controller.LoginController;
/**
 * Created by Lenovo on 2017/3/12.
 */
public class LoginView extends JFrame{
    private JTextField userName = new JTextField(20);
    private JLabel additionLabel1 = new JLabel("USERNAME");
    private JTextField passWord = new JTextField(20);
    private JLabel additionLabel2 = new JLabel("PASSWORD");
    private JButton Button = new JButton("Submit");
    //private JTextField calcSolution = new JTextField(10);

   public LoginView(){
        JPanel LoginPanel1 = new JPanel();
        JPanel LoginPanel2 = new JPanel();
        JPanel LoginPanel3 = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("FastFire Log Page");
        this.setSize(600, 200);

        LoginPanel1.add(additionLabel1);
        LoginPanel1.add(userName);
        LoginPanel2.add(additionLabel2);
        LoginPanel2.add(passWord);
        LoginPanel3.add(Button);

        setLayout(new BorderLayout());
        add(LoginPanel1, BorderLayout.NORTH);
        add(LoginPanel2, BorderLayout.CENTER);
        add(LoginPanel3, BorderLayout.SOUTH);
    }
    public String getUserName() {
        return userName.getText();
    }

    public String getPassWord() {
        return passWord.getText();
    }

   public void SubmitListener(ActionListener listenForButton) {
        Button.addActionListener(listenForButton);
    }

   public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
