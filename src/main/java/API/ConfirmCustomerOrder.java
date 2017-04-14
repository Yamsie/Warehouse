package API;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;

/**
 * Created by James on 13/03/2017.
 */

@WebServlet(urlPatterns = "/confirmCustomerOrder")
public class ConfirmCustomerOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String securityToken = req.getParameter("orderid");
        String orderId = req.getParameter("token");
        resp.getWriter().write("Order ID: " + orderId);
        resp.getWriter().write("\nSecurity Token: " + securityToken);

        //This should update the given orderid to "Confirmed" if the given order ID exists and has a status of "Shipped"
        //or return an error message if the id does not exist
    }

}
