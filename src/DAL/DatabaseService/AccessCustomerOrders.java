package DAL.DatabaseService;

/**
 * Created by James on 20/03/2017.
 */
public class AccessCustomerOrders extends DatabaseService {

    private String jobTitle;

    public AccessCustomerOrders(String jobTitle) {
        super("data/CUSTOMER_ORDERS.txt");
        this.jobTitle = jobTitle;
    }
}
