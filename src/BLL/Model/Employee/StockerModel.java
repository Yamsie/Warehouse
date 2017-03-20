package BLL.Model.Employee;

/**
 * Created by Lenovo on 2017/3/20.
 */
public class StockerModel extends Employee{
    private String jobTitle;
    //DBOperater StockerDB = new DBStocker();

    public StockerModel(String userName, int id, String email){
        super(userName, id, email);
        jobTitle = "Stocker";
    }

    public void addInfo(String[] newItem){
        //StockerDB.addNewItem(newItem);
        //add new Item Information into txt file
    }

    public String [] showInfo(int ItemID){
        String [] ItemInfo = new String[7];
        //ItemInfo = StockerDB.getItemInfo(ItemID);
        return ItemInfo;
    }

    public void changeInfo(String[] newInfo){
        //StockerDB.changeStockInfo(newInfo);
    }

    public String getJobTitle() { return jobTitle;}
}
