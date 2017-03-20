package BLL.Models.Employees;

//import DAL package;
/**
 * Created by JiasenTian on 2017/3/19.
 */
public class PackerModel extends Employee {
    private String jobTitle;
    //DBOperater packerBD = new DBPakccr();

    public PackerModel(String userName, int id, String email){
        super(userName, id, email);
        jobTitle = "Packer";
    }

    public String [] getItemInfo(int ItemID){
        String [] ItemInfo = new String[7];
        //ItemInfo = packerDB.getItemInfo(ItemID);
        return ItemInfo;
    }

    public String [] getOrderInfo(int OrderID){
        String [] OrderInfo = new String[9];
        //OrderInfo = packerDB.getOrderInfo(OrderID);
        return OrderInfo;
    }

    public String getJobTitle() { return jobTitle;}
}
