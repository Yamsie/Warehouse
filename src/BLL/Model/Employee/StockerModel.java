package BLL.Model.Employee;

import DAL.DatabaseService.AccessInventory;
import DAL.DatabaseService.DatabaseService;

import java.util.List;

/**
 * Created by Lenovo on 2017/3/20.
 */
public class StockerModel extends Employee implements I_EmployeeModel {
     String jobTitle;
    DatabaseService StockerDB = new AccessInventory();

    //int newId, String newName, String newJobTitle, String newEmail
    public StockerModel(String userName, int id, String email){
        super(id,userName,"Stocker", email);
        jobTitle = "Stocker";
    }

    public void addInfo(String[] newItem){
        String addItem = parseIntoString(newItem);
        StockerDB.addData(addItem);
        //add new Item Information into txt file
    }

    public String [] showInfo(int ItemID){
        String [] ItemInfo = new String[7];
        String Item = StockerDB.showData(ItemID);
        ItemInfo = Item.split(",");
        return ItemInfo;
    }

    public void changeInfo(String[] newInfo){
        StockerDB.changeData(newInfo);
    }

    public String parseIntoString(String[] info){
        String ItemDetail = "";
        for(int i = 0; i < info.length; ++i){
            if(i == 0)
                ItemDetail += info[i];
            else
                ItemDetail += "," + info[i];
        }
        return ItemDetail;
    }

}
