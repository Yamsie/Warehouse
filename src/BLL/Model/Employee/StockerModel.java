package BLL.Model.Employee;

import BLL.Model.Inventory.Item;
import BLL.Model.Order.StockOrder;
import DAL.DatabaseService.AccessInventory;
import DAL.DatabaseService.AccessStockOrders;
import DAL.DatabaseService.DatabaseService;

import java.util.List;

public class StockerModel extends Employee implements I_EmployeeModel
{
    private DatabaseService stockerDBInventory = new AccessInventory();
    private DatabaseService stockerDBStockOrders = new AccessStockOrders();
    private String jobTitle;

    public StockerModel(int id, String name, String userName, String email){
        super(id,userName,"Stocker", email);
        String jobTitle = "Stocker";
    }

    public void addNewItem(Item createdItem) {
        String newRow = createdItem.toString();
        stockerDBInventory.addData(newRow);
    }

    public String[] showChosenItem(String chosenItem) {
        String chosenItemInfo[] = new String[7];
        int chosenItemID = Integer.parseInt(chosenItem);
        String chosenItemDetails = stockerDBInventory.showData(chosenItemID);
        chosenItemInfo = chosenItemDetails.split(",");
        return chosenItemInfo;
    }

    public void changeExistingItem(Item changedItem) {
        String changedRow = changedItem.toString();
        stockerDBInventory.changeItemData(changedRow);
    }

    public void createNewStockOrder(StockOrder createdStockOrder) {
    	String newRow = createdStockOrder.toString();
    	stockerDBStockOrders.addData(newRow);
    }

}
