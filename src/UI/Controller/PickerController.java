package UI.Controller;

import UI.Views.PickerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lenovo on 2017/3/13.
 */
public class PickerController {
    private PickerView view;
    //private Picker model;

    public PickerController(PickerView view/*, PickerView model*/){
        this.view = view;
        //this.model = model;
        this.view.SubListener1(new SubListener1());
        this.view.SubListener2(new SubListener2());
        this.view.LogoutListener(new LogoutListener());
    }

    class SubListener1 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String ItemID;

            try {
                ItemID = view.getItemId();
                //String[] ItemIfo = model.getInfo(ItemID);
                //#item_id,item_type,manufacturer,size,stock_quantity,selling_price,purchase_price
                /*Test*/ String[] ItemInfo = {"000001","Sports Shoes","Nike", "44", "566", "100", "66"};
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

            try {
                OrderID = view.getOrderId();
                //String[] orderIfo = model.getOrderInfo(OrderID);
                //#order_id,cust_id,item_id,order_quantity,status,order_price,shipping_price,total_price,order_date
                /*Test*/ String[] OrderInfo = {"100001","1213123","0000001", "340g","Arrived", "566", "100", "666", "2017/03/12"};
                String description = view.createOrderDescription(OrderInfo);
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
}
