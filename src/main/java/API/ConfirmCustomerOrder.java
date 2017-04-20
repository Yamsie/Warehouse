package API;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
import java.io.IOException;
import java.util.List;

/**
 * Created by James on 13/03/2017.
 */

@WebServlet(urlPatterns = "/confirmCustomerOrder")
public class ConfirmCustomerOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderid");

        try {
            int id = Integer.parseInt(orderId);

            DatabaseService co = new AccessCustomerOrders();

            List<String> orderInfo = co.selectInfo("order_id", orderId);
            for (int i = 0; i < orderInfo.size(); i++) {
                String[] data = orderInfo.get(i).split(",");
                String output = "";
                int statusIndex = co.getColumnIndex("status");
                if (data[statusIndex].compareTo("SHIPPED") == 0) {
                    co.deleteData(data);
                    data[statusIndex] = "CONFIRMED";
                    for (int j = 0; j < data.length; j++) {
                        output += data[j];
                        if (j != data.length - 1) {
                            output += ",";
                        }
                    }
                    co.addData(output);
                    resp.getWriter().write("Status updated.");
                } else {
                    resp.getWriter().write("Order not shipped.");
                }
            }
        } catch (Exception e) {
            resp.getWriter().write("Item not confirmed. Error: " + e);
        }
    }
}