package BLL.Model.Employee;

//import DAL Package
/**
 * Created by JiasenTian on 2017/3/19.
 */
public class PickerModel extends Employee implements I_EmployeeModel{
    private String jobTitle;
    //DBOperater pickerBD = new DBPikccr();

    public PickerModel(int id, String userName, String jobTitle, String email) {
            super( id, userName, jobTitle, email);
        }

    public String [] getItemInfo(int ItemID){
        String [] ItemInfo = new String[7];
        //ItemInfo = pickerDB.getItemInfo(ItemID);
        return ItemInfo;
    }

    public String [] getOrderInfo(int OrderID){
        String [] OrderInfo = new String[9];
        //OrderInfo = pickerDB.getOrderInfo(OrderID);
        return OrderInfo;
    }

}
