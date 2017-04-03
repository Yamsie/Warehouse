package UI.Controller;

import BLL.Model.Employee.PackerModel;
import BLL.Model.Order.CustomerOrder;
import UI.View.PackerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import Package

/**
 * Created by Lenovo on 2017/3/13.
 */
public class PackerController implements I_EmployeeController {
    private PackerView view;
    private PackerModel model;

    public PackerController(PackerView view, PackerModel model){
        this.view = view;
        this.model = model;
        this.view.SubListener1(new SubListener1());
        this.view.SubListener2(new SubListener2());
        this.view.SubListener3(new SubListener3());
        this.view.LogoutListener(new LogoutListener());
    }
    class SubListener1 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String ItemID;

            try {
                model.addItemReady(Integer.parseInt(view.getItemId()));
                String description = model.createItemDescription();
                view.setItemInfo(description);
            }
            catch (NullPointerException e) {
                view.displayErrorMessage("Item ID: " + view.getItemId() + " not found. (Error " + e + ")");
            }
            catch (NumberFormatException e) {
                view.displayErrorMessage("Invalid Item ID: " + view.getItemId() + ". (Error " + e + ")");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                view.displayErrorMessage("Invalid Item ID: " + view.getItemId() + ". (Error " + e + ")");
            }
        }

    }
    class SubListener2 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            CustomerOrder order;

            try {
                view.setItemInfo("");
                view.setOrderInfo("");
                model.setCurrentOrder(Integer.parseInt(view.getOrderId()));
                String description = model.createOrderDescription();
                view.setOrderInfo(description);
            }
            catch (NullPointerException e) {
                view.displayErrorMessage("Order ID: " + view.getOrderId() + " not found. (Error " + e + ")");
            }
            catch (NumberFormatException e) {
                view.displayErrorMessage("Invalid Order ID: " + view.getOrderId() + ". (Error " + e + ")");
            }
        }

    }

    class SubListener3 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            CustomerOrder order;

            try {
                model.boxOrder();
            }
            catch (NullPointerException e) {
                e.printStackTrace();
                view.displayErrorMessage("Order ID: " + view.getOrderId() + " too large. (Error " + e + ")");
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
                view.displayErrorMessage("Invalid Order ID: " + view.getOrderId() + ". (Error " + e + ")");
            }
        }
    }

    class LogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            try {
                view.setVisible(false);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Error Logging Out.");
            }
        }

    }

    public PackerView getView() {
        return view;
    }
}
