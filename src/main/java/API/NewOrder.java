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

@WebServlet(urlPatterns = "/newOrder")
public class NewOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String custId = req.getParameter("custid");
        String securityToken = req.getParameter("token");
        String itemId[] = req.getParameterValues("itemid");
        resp.getWriter().write("Customer ID: " + custId);
        resp.getWriter().write("\nSecurity Token: " + securityToken);
        try {
            if (itemId != null) {
                for (int i = 0; i < itemId.length; i++) {
                    resp.getWriter().write("\nItem ID " + i + ": " + itemId[i]);
                }
            }
        } catch (NullPointerException e) {
            resp.getWriter().write("Error");
        }

        //This will check to see if the token and custid match, assign the order a unique orderID,
        //then create order. If two itemIDs match then increment the quantity.
    }

}
