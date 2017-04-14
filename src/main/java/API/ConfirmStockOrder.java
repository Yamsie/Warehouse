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

//
@WebServlet(urlPatterns = "/confirmStockOrder")
public class ConfirmStockOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String custId = req.getParameter("orderId");
        String securityToken = req.getParameter("token");
        resp.getWriter().write("\nSecurity Token: " + securityToken);

        //This should update the given orderid to "Confirmed"
        //or return an error message if the id does not exist
    }

}
