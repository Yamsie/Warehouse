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
            if(Integer.parseInt(detail[0]) == id && detail[6].equalsIgnoreCase("ACCEPT")){
                detail[6] = "PACKING";
                fileData.set(i,parseIntoString(detail));
            }
        }
        super.writeData(fileData);
    }

    public String showData(int chosenOrderID) {
        List<String> fileData = super.getData();
        //Instead of returning a string array, return an Item??
        for (int i = 1; i < fileData.size(); i++) {
            String orderInfo;
            String[] detail = fileData.get(i).split(",");
            if (Integer.parseInt(detail[0]) == chosenOrderID) {
                orderInfo = fileData.get(i);
                //System.out.println(itemInfo);
                return orderInfo;
            }
        }
        return null;
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

    public void updateOrder(String[] newRow) {
        List<String> fileData = getData();
        int orderIdIndex = super.getColumnIndex("order_id");
        int itemIdIndec = super.getColumnIndex("item_id");
        String newLine = "";
        String[] rowElements;
        for(int i = 1; i < fileData.size(); i++) {
            rowElements = fileData.get(i).split(",");
            if(Integer.parseInt(rowElements[orderIdIndex]) == Integer.parseInt(newRow[orderIdIndex]) && Integer.parseInt(rowElements[itemIdIndec]) == Integer.parseInt(newRow[itemIdIndec])) {
                for (int j = 0; j < newRow.length; j++) {
                    newLine += newRow[j];
                    if (j != (newRow.length - 1)) {
                        newLine += ",";
                    }
                }
                System.out.println(newLine);
                fileData.remove(i);
                fileData.add(newLine);
                newLine = "";
            }
        }

        super.writeData(fileData);
    }

}
