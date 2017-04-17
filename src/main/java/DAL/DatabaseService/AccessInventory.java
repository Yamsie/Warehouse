package DAL.DatabaseService;

import java.util.List;

public class AccessInventory extends DatabaseService {

    public AccessInventory() {
        super("data/ALL_ITEMS.txt");
    }

    @Override
    public void changeItemData(String changedRow) {
        List<String> fileData = super.getData();

        for (int i = 1; i < fileData.size(); i++) {
            String[] detail = fileData.get(i).split(",");
            if (Integer.parseInt(detail[0]) == Integer.parseInt(changedRow.substring(0, changedRow.indexOf(",")))) {
                fileData.set(i, changedRow);
                break;
            }
        }
        super.writeData(fileData);
    }

    public String showData(int chosenItemID) {
        List<String> fileData = super.getData();
        //Instead of returning a string array, return an Item??
        for (int i = 1; i < fileData.size(); i++) {
            String itemInfo;
            String[] detail = fileData.get(i).split(",");
            if (Integer.parseInt(detail[0]) == chosenItemID) {
                itemInfo = fileData.get(i);
                //System.out.println(itemInfo);
                return itemInfo;
            }
        }
        return null;
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

    public void changeStates(int id){
        List<String> fileData = super.getData();


        for (int i = 1; i < fileData.size(); i++) {
            String itemInfo;
            String[] detail = fileData.get(i).split(",");
            if (Integer.parseInt(detail[0]) == id) {
                itemInfo = fileData.get(i);
                String [] item = itemInfo.split(",");
                if(item[6].equals("ACCEPT")) {
                    item[6] = "PACKING";
                }

                String newitem = "";

                for(int j = 0; j < item.length; ++j){
                    if(j == 0){
                        newitem += item[j];
                    }
                    else
                        newitem += "," + item[j];
                }
                //System.out.println(itemInfo);
                fileData.set(i, newitem);
            }
        }
        super.writeData(fileData);

    }

}