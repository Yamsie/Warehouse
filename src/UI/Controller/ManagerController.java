package UI.Controller;

import UI.Views.ManagerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerController {
    private ManagerView view;
    //private Manager model;
    private String userId;

    public ManagerController(ManagerView view/*, Manager model*/){
        this.view = view;
        // this.model = model;
        this.view.addListener(new addListener());
        this.view.changeListener(new changeListener());
        this.view.chooseListener(new chooseListener());
        this.view.newStockOrderListener(new newStockOrderListener());
        this.view.SubListener1(new SubListener1());
        this.view.SubListener2(new SubListener2());
        this.view.ChooseEmployeeListener(new ChooseEmployeeListener());
        this.view.setEmployeeInfoListener(new setEmployeeInfoListener());
        this.view.LogoutListener(new LogoutListener());
    }

    class addListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            try {
                String[] newItem = view.newItem();

                //model.addInfo(newItem);
                //test
                for(int i = 0; i < 7; ++i)
                    System.out.print(newItem[i] + " ");
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer to add new Item!");
            }
        }

    }

    class chooseListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String Id;
            try {
                Id = view.getChooseId();
                //String[] Item = model.showInfo(Id);
                //item_id,item_type,manufacturer,size,stock_quantity,selling_price,purchase_price
                String[] Item = {"20001", "Sport Shoes", "Nike", "44" , "500", "100", "75"};
                view.setChangeInfo(Item);
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("ID errer!");
            }
        }

    }


    class changeListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            try {
                String[] newInfo = view.getChange();
                //model.changeInfo(newInfo);
                for(int i = 0; i < 7; ++i)
                    System.out.print(newInfo[i] + " ");
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer to Log out!");
            }
        }

    }

    class newStockOrderListener implements  ActionListener{
        public void actionPerformed(ActionEvent arg0) {

            try {
                String[] newInfo = view.getNewStockOrder();
                //model.addInfo(newInfo);
                for(int i = 0; i < 5; ++i)
                    System.out.print(newInfo[i] + " ");
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer to create new stock order!");
            }
        }

    }

    class SubListener1 implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            String ItemID;

            try {
                ItemID = view.getItemID();
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
                OrderID = view.getOrderID();
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

    class ChooseEmployeeListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            try {
                String Id = view.getEmployeeId();

                //String [] employee = model.getInfo(Id);
                //test
                String [] employee = {"00001","Jason123", "123123", "Picker", "123123@outlook.com"};
                view.setEmployeeText(employee);
                userId = employee[0];
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer User ID!");
            }
        }

    }

    class setEmployeeInfoListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            try {
                String[] employee = view.getChangeInfo(userId);

                //model.changeInfo(employee);
                //test
                for(int i = 0; i < 5; ++i)
                    System.out.print(employee[i] + " ");
            }
            catch (Exception e) {
                e.printStackTrace();
                view.displayErrorMessage("Errer to add new Item!");
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
