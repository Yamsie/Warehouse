package BLL.API;

import BLL.Model.Customer.CustomerOrderDecorator;
import BLL.Model.Customer.CustomerOrderSource;
import BLL.Model.Customer.CustomerOrderSourceable;
import BLL.Model.Order.TemporaryOrder;
import BLL.Model.Customer.ContextOfCustomers;
import BLL.Model.Customer.StateOfCustomers;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.AccessCustomers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by James on 13/03/2017.
 */

@WebServlet(urlPatterns = "/newOrder")
public class NewOrder extends HttpServlet {

    StateOfCustomers state  = new StateOfCustomers();
    ContextOfCustomers context = new ContextOfCustomers(state);
    String orderDetail;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String custId = req.getParameter("custid");
        String itemId[] = req.getParameterValues("itemid");

        int orderId;
        //try {
        //    if (itemId != null) {
        //        for (int i = 0; i < itemId.length; i++) {
        //            resp.getWriter().write("\nItem ID " + i + ": " + itemId[i]);
        //        }
        //    }
        //} catch (NullPointerException e) {
        //    resp.getWriter().write("Error");
        //}

        try {
            state.setOperatorType("customers");
            AccessCustomers cust = (AccessCustomers) context.method();
            boolean User = cust.checkCustomers(custId);
            if (User) {
                ArrayList<TemporaryOrder> list = new ArrayList<>();
                ArrayList<String> order = new ArrayList<>();
                state.setOperatorType("order");
                AccessCustomerOrders newOrder = (AccessCustomerOrders) context.method();
                orderId = newOrder.getNewOrderId();
                String id = String.valueOf(orderId);
                list = getTotalItem(itemId);
                order = newOrder(list, id, custId);
                newOrder.addNewOrder(order);
            } else {
                resp.getWriter().write("User ID Error!");
            }
        } catch (NullPointerException e) {
            resp.getWriter().write("Order not submitted. Exception: " + e);
        }
    }

    public ArrayList<String> newOrder(ArrayList<TemporaryOrder> list,String orderId, String userID){
        ArrayList<String> newOrder = new ArrayList<>();
        for(int i = 0; i < list.size(); ++i){
            CustomerOrderSourceable source = new CustomerOrderSource();
            CustomerOrderSourceable obj = new CustomerOrderDecorator(source);
            newOrder.add(obj.customerOrder(orderId, userID, list.get(i).getItemID(), list.get(i).getCount()));
        }
        return newOrder;
    }


    public ArrayList<TemporaryOrder> getTotalItem(String [] ItemID){

        ArrayList<TemporaryOrder> item = new ArrayList<>();
        ArrayList<String> id = new ArrayList<>();

        for(int i = 0 ;i < ItemID.length; ++i) {
            id.add(ItemID[i]);
        }

        for(int i = 0; i < id.size(); ++i){
            boolean temp = checkExist(item, ItemID[i]);
            if(temp == false){
                item.add(new TemporaryOrder(ItemID[i]));
            }
            else{
                addCount(item,ItemID[i]);
            }
        }
        return item;
    }

    public boolean checkExist(ArrayList<TemporaryOrder> list, String Id){
        boolean temp = false;
        for(int i = 0 ; i < list.size(); ++i){
            if(list.get(i).getItemID().equals(Id)){
                temp = true;
                return temp;
            }
        }
        return false;
    }

    public void addCount(ArrayList<TemporaryOrder> list,String Id){
        for(int i = 0; i < list.size(); ++i){
            if(list.get(i).getItemID().equals(Id))
                list.get(i).add();
        }
    }
}