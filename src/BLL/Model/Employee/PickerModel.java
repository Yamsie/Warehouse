package BLL.Model.Employee;

import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.AccessInventory;
import DAL.DatabaseService.DatabaseService;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Jiasen on 2017/3/19.
 */
public class PickerModel extends Employee implements I_EmployeeModel{
    private String jobTitle;
    private String [] orderDetail;

    DatabaseService pickerBD = new AccessCustomerOrders("Picker");
    DatabaseService inventoryDB = new AccessInventory();
    //int newId, String newName, String newJobTitle, String newEmail

    public PickerModel(int id, String userName, String newJobTile, String email){
        super(id, userName, "Picker", email);
        jobTitle = "Picker";
    }

    public String [] getItemInfo(int ItemID){
        AccessInventory inventory =  (AccessInventory)inventoryDB;
        String  ItemInfo = inventory.showData(ItemID);
        String [] item = ItemInfo.split(",");
        return item;
    }

    public String [] getOrderInfo(int OrderID){

        String [] OrderInfo = groupByOrderId(OrderID);
        return OrderInfo;
    }

    public String [] groupByOrderId(int ID){
        AccessCustomerOrders picker = (AccessCustomerOrders)pickerBD;  // Explicit casting
        orderDetail = picker.allData();

        int count = 0;
        String[] orderGroup = new String[orderDetail.length];

        for(int i = 0; i < orderDetail.length; ++i){
            String [] order = orderDetail[i].split(",");
            if(ID == Integer.parseInt(order[0])){
                orderGroup[count] = orderDetail[i];
                count++;
            }
        }
        return orderGroup;
    }

    public int [] numberOfOrders(){

        AccessCustomerOrders picker = (AccessCustomerOrders)pickerBD;  // Explicit casting
        orderDetail = picker.allData();
        ArrayList<String> orderList = new ArrayList<String>();
        for(int i = 0; i < orderDetail.length; ++i){
            String [] order = orderDetail[i].split(",");
            orderList.add(order[0]);
        }

        for(int i = 0 ; i < orderList.size(); ++i){
            for(int j = i + 1; j < orderList.size(); ++j){
                if(Integer.parseInt(orderList.get(i)) == Integer.parseInt(orderList.get(j)))
                    orderList.remove(j);
            }
        }

        int[] orderId = new int[orderList.size()];
        for(int i = 0; i < orderList.size(); ++i){
            orderId[i] = Integer.parseInt(orderList.get(i));
        }
        return orderId;
    }

    public void changeStateOfOrder(int id){
        AccessCustomerOrders picker = (AccessCustomerOrders)pickerBD;
        picker.changeData(id);
    }

    public String checkStock(){

        String message1 = "All the order is correct and items is available in stock!";
        String message2 = "";
        AccessCustomerOrders picker = (AccessCustomerOrders)pickerBD;  // Explicit casting
        String[] order = picker.allData();

        for(int i = 0; i < order.length; ++i){
            String[] Item = order[i].split(",");
            String check = inventoryDB.showData(Integer.parseInt(Item[2]));
            if(check == null){
                message2 += "Error Order: \n"
                        + detailOfOrder(order[i])
                        + "\nError reason: Item not available in stock!\n\n";

            }
            else{
                String[] ItemDetail = check.split(",");
                if(Integer.parseInt(ItemDetail[5]) < Integer.parseInt(Item[3])){
                    message2 += "Delete Order: \n"
                            + detailOfOrder(order[i])
                            + "\nError reason: Order's quantity is larger than stocks!\n\n";

                }
            }
        }
        if(message2.equals(""))
            return message1;
        else
            return message2;
    }
    //#order_id,cust_id,item_id,order_quantity,status,box_size,order_price,shipping_price,total_price,order_date,shipping_address
    public String detailOfOrder(String order){
        String [] detail = order.split(",");
        String description = "";
        description += "Order ID: " + detail[0] + "\t"
                + "Customer ID: " + detail[1] + "\n"
                + "Item ID: " + detail[2] + "\t"
                + "Order Quantity: " + detail[3] + "\n"
                + "Ststus: " + detail[4] + "\t"
                + "Box Size: " + detail[5] + "\n"
                + "Order Price: " + detail[6] + "\t"
                + "Shipping Price: " + detail[7] + "\n"
                + "Total Price: " + detail[8] + "\t"
                + "Order Date: " + detail[9] + "\n"
                + "Shipping Address: " + detail[10] + "\n";
        return description;
    }
}
