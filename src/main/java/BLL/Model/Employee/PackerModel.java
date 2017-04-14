package BLL.Model.Employee;

//import DAL package;

import BLL.Model.Box.BoxFactory;
import BLL.Model.Box.I_Box;
import BLL.Model.Employee.Employee;
import BLL.Model.Order.CustomerOrder;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.DatabaseService;
import BLL.Model.Inventory.Item;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiasenTian on 2017/3/19.
 */

public class PackerModel extends Employee {
    AccessCustomerOrders db = new AccessCustomerOrders();
    List<Integer> toPack = new ArrayList<Integer>();
    List<Integer> itemsReady = new ArrayList<Integer>();
    CustomerOrder currentOrder;

    public PackerModel(int id, String userName, String jobTitle, String email){
        super(id, userName, jobTitle, email);
    }

    public String [] getItemInfo(int itemId){
        String[] itemInfo = db.getRow(itemId);
        Item item = new Item(itemInfo);
        return itemInfo;
    }

    public CustomerOrder getCurrentOrder() {
        return currentOrder;
    }

    public void addItemReady(int itemId) {
        toPack.remove(toPack.indexOf(itemId));
        itemsReady.add(itemId);
    }

    public void setCurrentOrder(int orderId) {
        clearItemsReady();
        clearToPack();
        String[] orderDetails = db.getRow(orderId);
        currentOrder = new CustomerOrder(orderDetails);
        setItemsToPack();
    }

    public void setItemsToPack() {
        List<String> temp = new ArrayList<String>();
        temp = db.selectInfo("order_id", Integer.toString(currentOrder.getOrderID()));
        temp.retainAll(db.selectInfo("status", "PACKING"));


        int columnIndex = db.getColumnIndex("item_id");
        String[] elements;
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(i + "temp ;; " +temp.get(i));
            elements = temp.get(i).split(",");
            toPack.add(Integer.parseInt(elements[columnIndex]));
            if(!(currentOrder.containsOrder(Integer.parseInt(elements[columnIndex])))) {
                currentOrder.setItemID(Integer.parseInt(elements[columnIndex]));
            }
            System.out.println(i + "co ;; " + currentOrder.getItems().get(i));
            System.out.println(i + "tp ;; " + toPack.get(i));
        }
    }

    public void boxOrder() {
        if (validateOrder()) {
            BoxFactory factory = new BoxFactory();
            I_Box box = factory.createBox(currentOrder);
            currentOrder.setBoxSize(box);
            currentOrder.setStatus("LOADING");

            for (int i =  0; i < itemsReady.size(); i++) {
                System.out.println(currentOrder.getItems().get(i).toString());
                String[] orderDetails = currentOrder.toString(i).split(",");
                db.updateOrder(orderDetails);
            }

            JOptionPane.showMessageDialog(null, "Boxed!");

        } else {
            JOptionPane.showMessageDialog(null, "Not boxed!");
        }
    }

    private boolean validateOrder() {
        return  (toPack.size() == 0);
    }

    public String createOrderDescription(){
        String description = "";
        description += "Order ID: " + currentOrder.getOrderID() + "\nStatus: " + currentOrder.getStatus() + "\nItems to pack: ";

        for (int i = 0; i < toPack.size(); i++) {
            description += "\n -" + toPack.get(i);
        }

        return description;
    }

    public String createItemDescription(){
        String description = "";
        description += "\nItems packed: ";

        for (int i = 0; i < itemsReady.size(); i++) {
            description += "\n -" + itemsReady.get(i);
        }

        return description;
    }

    public void clearToPack() {
        toPack.clear();
    }

    public void clearItemsReady() {
        itemsReady.clear();
    }
}

/**
 * needs to take order id
 * from order id, list items
 * from list of items, generate box
 * automatically set box size of order id
 * once order is set as packed, reset screen
 */
