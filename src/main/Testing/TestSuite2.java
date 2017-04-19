import BLL.Model.Inventory.Item;
import BLL.Model.Order.CustomerOrder;
import DAL.DatabaseService.AccessCustomerOrders;
import DAL.DatabaseService.AccessInventory;
import DAL.DatabaseService.DatabaseService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by Shane on 19/04/2017.
 */
public class TestSuite2 {

    private DatabaseService DBCustomerOrders = new AccessCustomerOrders();
    private DatabaseService stockerDBInventory = new AccessInventory();
    private List<Item> itemsInCustomerOrder = new ArrayList<Item>();


    @Test
    public void testChangeExistingItemDetails() {
        int randItemID = (int)(Math.random() * (9000000-1000000)+ 1000000); //Generates Random Number between 1 Million and 9 Million
        Item testItem = new Item(randItemID,"TestItemType","TestManufacturer","TestSize",00.00,1,00.10,00.01);
        String newRow = testItem.toString();
        //System.out.println("Initial Item Details: " + newRow);       //Used to check against database
        stockerDBInventory.addData(newRow);                            //Create the initial Item that will soon be edited
        Item changedItem = new Item(randItemID, "ChangedItemType", "ChangedManufacturer", "ChangedSize", 00.00, 1, 0.01, 0.01);
        String changedRow = changedItem.toString();
        //System.out.println("Changed Item Details: " + changedRow);   //Used to check against database
        stockerDBInventory.changeItemData(changedRow);                 //Changing the item that was initially created, both have same IDs
        int changedItemFound = 0;
        int oldItemNotFound = 0;
        changedItemFound = stockerDBInventory.checkData(changedRow);   //Check to see if old details were overwritten by the new ones
        oldItemNotFound = stockerDBInventory.checkData(newRow);        //Check to see if old details were deleted
        String itemDetailsArray[] = changedRow.split(",");
        stockerDBInventory.deleteData(itemDetailsArray);               //Deleting test data
        try {
            assertTrue("changedItemFound = 1 and oldItemNotFound = 0 => Item details successfully changed in DB, Old item details deleted!", changedItemFound == 1 && oldItemNotFound == 0);
            System.out.println("Test 1 Pass [Test Suite 2]!\nItem Details were successfully changed in database!");
        } catch (AssertionError e) {
            System.out.println("Test 1 Fail [Test Suite 2]!\nItem Details were not changed in database!");
            fail();
        }
    }

    @Test
    public void testChangeItemStatus(){
        int randOrderID = (int) (Math.random() * (9000000 - 1000000) + 1000000); //Generates Random Number between 1 Million and 9 Million
        int randItemID = (int) (Math.random() * (9000000 - 1000000) + 1000000); //Generates Random Number between 1 Million and 9 Million
        Item testItem = new Item(randItemID, "TestItemType", "TestManufacturer", "TestSize", 00.00, 1, 00.10, 00.01);
        itemsInCustomerOrder.add(testItem);
        CustomerOrder testOrder = new CustomerOrder(randOrderID, 1, itemsInCustomerOrder, 1, "Ireland", "ACCEPTED", "BoxA", 00.01, 00.01, 00.02, "29/06/2016", 1);
        String newRow = testOrder.toString(0);
        String changedRow = (randOrderID + ",1," + randItemID + ",1,Ireland,1,PACKING,BoxA,0.01,0.01,0.02,29/06/2016");
        DBCustomerOrders.addData(newRow);
        DBCustomerOrders.changeData(randOrderID);
        int changedItemFound = 0;
        int oldItemNotFound = 0;
        changedItemFound = DBCustomerOrders.checkData(changedRow);   //Check to see if old details were overwritten by the new ones
        oldItemNotFound = DBCustomerOrders.checkData(newRow);        //Check to see if old details were deleted
        try {
            assertTrue("changedItemFound = 1 and oldItemNotFound = 0 => Order Status successfully changed in DB!", changedItemFound == 1 && oldItemNotFound == 0);
            System.out.println("Test 2 Pass [Test Suite 2]!\nOrder Status successfully changed from 'ACCEPTED' to 'PACKING' in database!");
        }
        catch (AssertionError e) {
            System.out.println("Test 2 Fail [Test Suite 2]!\nOrder Status was not changed in DB!");
            fail();
        }
    }

}
