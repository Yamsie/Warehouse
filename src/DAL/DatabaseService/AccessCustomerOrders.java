package DAL.DatabaseService;

import java.util.List;

/**
 * Created by Jiasen on 24/03/2017.
 */
public class AccessCustomerOrders extends DatabaseService {

    public AccessCustomerOrders() {
        super("data/CUSTOMER_ORDERS.txt");
    }


    public void deleteData(String order){
        List<String> fileData = super.getData();

        for(int i = 1; i < fileData.size(); i++){
            String detail = fileData.get(i);
            if(detail.equals(order)){
                fileData.remove(i);
                break;
            }
        }
        super.writeData(fileData);
    }

    public String[] allData() {
        List<String> fileData = super.getData();
        String[] detail = new String[fileData.size()-1];
        for (int i = 1; i < fileData.size(); i++) {
            detail[i - 1] = fileData.get(i);
            }
        return detail;
    }

    public void changeData(int id) {
        List<String> fileData = super.getData();

        for(int i = 1; i < fileData.size(); i++){
            String[] detail = fileData.get(i).split(",");
            if(Integer.parseInt(detail[0]) == id && detail[4].equalsIgnoreCase("ACCEPT")){
                detail[4] = "PACKING";
                fileData.set(i,parseIntoString(detail));
            }
        }
        super.writeData(fileData);
    }


    public String parseIntoString(String[] order){
        String temp = "";
        for(int i = 0; i < order.length; ++i){
            if(i ==0)
                temp += order[i];
            else
                temp += "," + order[i];
        }
            return temp;
    }

}
