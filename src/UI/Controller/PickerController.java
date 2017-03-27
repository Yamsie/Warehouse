package UI.Controller;

import BLL.Model.Employee.PickerModel;
import UI.View.PickerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jiasen on 2017/3/13.
 */
public class PickerController implements I_EmployeeController {
    private PickerView view;
    private PickerModel model;

    public PickerController(PickerView view, PickerModel model){
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
                ItemID = view.getItemId();
                String[] ItemInfo = model. getItemInfo(Integer.parseInt(ItemID));
                String description = view.createItemDescription(ItemInfo);
                view.ItemInfo.setText(description);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("NO This Item In Stock!\n");
            }
        }

    }

    class SubListener2 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String OrderID;
            String detail = "";
            try {
                OrderID = view.getOrderId();
                String[] orderInfo = model.groupByOrderId(Integer.parseInt(OrderID));
                for(int i = 0; i < orderInfo.length; ++ i) {
                    if(orderInfo[i] != null){
                        detail += "\nOrder Item " + (i + 1) + " : \n" + model.detailOfOrder(orderInfo[i]) + "\n";
                    }
                }
                model.changeStateOfOrder(Integer.parseInt(OrderID));
                view.orderInfo.setText(detail);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("There is no correct order with this Id!\n");
            }
        }

    }

    class SubListener3 implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            String OrderID;

            try {
                String message = model.checkStock();
                view.displayErrorMessage(message);

                int[] OrderInfo = model.numberOfOrders();
                String description = view.createIdDescription(OrderInfo);
                view.orderIDs.setText(description);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Wrong Order ID Operation!\n");
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
                view.displayErrorMessage("Errer to Log out!");
            }
        }

    }

    public PickerView getView() {
        return view;
    }
}
