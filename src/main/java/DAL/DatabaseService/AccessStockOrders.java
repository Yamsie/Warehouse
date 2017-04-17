package DAL.DatabaseService;

import java.util.List;

/**
 * Created by James on 20/03/2017.
 */
public class AccessStockOrders extends DatabaseService {

    public AccessStockOrders() {
        super("data/STOCK_ORDERS.txt");
    }

    @Override
    public int checkData(String allItemInfo) {
        int itemFound = 0;
        List<String> fileData = super.getData();
        for (int i = 1; i < fileData.size(); i++) {
            String detail = fileData.get(i);
            String itemID = detail.substring(0, (allItemInfo.indexOf(",")));
            if (itemID.equals(allItemInfo.substring(0, (allItemInfo.indexOf(","))))) {
                if (detail.equals(allItemInfo))
                    itemFound++;
            }
        }
        return itemFound;
    }
}
