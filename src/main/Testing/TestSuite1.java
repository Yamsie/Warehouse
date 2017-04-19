import BLL.Model.Inventory.Item;
import BLL.Model.Order.StockOrder;
import DAL.DatabaseService.AccessInventory;
import DAL.DatabaseService.AccessStockOrders;
import DAL.DatabaseService.DatabaseService;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by Shane on 2017/3/12.
 */
public class TestSuite1 {

    private DatabaseService stockerDBInventory = new AccessInventory();
    private DatabaseService stockerDBStockOrders = new AccessStockOrders();

    @Test
    public void testAddNewItem() {
        int randItemID = (int) (Math.random() * (9000000 - 1000000) + 1000000); //Generates Random Number between 1 Million and 9 Million
        Item testItem = new Item(randItemID, "TestItemType", "TestManufacturer", "TestSize", 00.00, 1, 00.10, 00.01);
        String newRow = testItem.toString();
        //System.out.println("New Item Details: " + newRow);  //Used to check against database
        stockerDBInventory.addData(newRow);
        int itemFound = 0;
        itemFound = stockerDBInventory.checkData(newRow);     //Check to see if created order is successfully found in the database
        String itemDetailsArray[] = newRow.split(",");
        stockerDBInventory.deleteData(itemDetailsArray);      //Deleting test data
        try {
            assertTrue("itemFound = 1 => Item details successfully found in DB", itemFound == 1);
            System.out.println("Test 1 Pass [Test Suite 1]!\nCreated Item was successfully stored in database!");
        }
        catch (AssertionError e) {
            System.out.println("Test 1 Fail [Test Suite 1]!\nCreated Item could not be found in database!");
            fail();
        }
    }

    @Test
    public void testAddNewStockOrder() {
        int randOrderID = (int) (Math.random() * (9000000 - 1000000) + 1000000); //Generates Random Number between 1 Million and 9 Million
        int randItemID = (int) (Math.random() * (9000000 - 1000000) + 1000000); //Generates Random Number between 1 Million and 9 Million
        StockOrder testOrder = new StockOrder(randOrderID, randItemID, "TestManufacturer", 1, 00.01);
        String newRow = testOrder.toString();
        //System.out.println("New Stock Order Details: " + newRow);     //Used to check against database
        stockerDBStockOrders.addData(newRow);
        int itemFound = 0;
        itemFound = stockerDBStockOrders.checkData(newRow);     //Check to see if created order is successfully found in the database
        String itemDetailsArray[] = newRow.split(",");
        stockerDBInventory.deleteData(itemDetailsArray);        //Deleting test data
        try {
            assertTrue("itemFound = 1 => Order details successfully found in DB", itemFound == 1);
            System.out.println("Test 2 Pass [Test Suite 1]!\nCreated Order was successfully stored in database!");
        }
        catch (AssertionError e) {
            System.out.println("Test 2 Fail [Test Suite 1]!\nCreated Order could not be found in database!");
            fail();
        }
    }
}