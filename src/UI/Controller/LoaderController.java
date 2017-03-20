package UI.Controller;

import UI.View.LoaderView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoaderController implements I_EmployeeController {
    private LoaderView view;
    //private LoaderModle model;

    public LoaderController(LoaderView view/*,LoaderModel model*/){
        this.view = view;
        //this.model = model;
        this.view.SubListener(new SubListener());
        this.view.LogoutListener(new LogoutListener());
    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String OrderID;

            try {
                //OrderID = view.getOrderId();
                //String[] orderIfo = model.getOrderInfo(OrderID);
                //#order_id,cust_id,item_id,order_quantity,status,order_price,shipping_price,total_price,order_date
                /*Test*/ String[] OrderInfo = {"100001","1213123","0000001", "340g","Arrived", "566", "100", "666", "2017/03/12"};
                String description;
                description = view.createDescription(OrderInfo);
                view.orderInfo.setText(description);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Wrong Order Id!\n");
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

    public LoaderView getView() {
        return view;
    }
}
