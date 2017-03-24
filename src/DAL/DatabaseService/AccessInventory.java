package DAL.DatabaseService;

import java.util.List;


/*
  Created by Jiasen on 21/03/2017.
 */

public class AccessInventory extends DatabaseService {

    public AccessInventory(){
        super("data/ALL_ITEMS.txt");
    }

    @Override
    public void changeData(String[] info) {
        List<String> fileData = super.getData();

        for(int i = 1; i < fileData.size(); i++){
            String[] detail = fileData.get(i).split(",");
            if(Integer.parseInt(detail[0]) == Integer.parseInt(info[0])){
                fileData.set(i,parseIntoString(info));
                break;
            }
        }
        super.writeData(fileData);
    }

    public void deleteData(String[] info){
        List<String> fileData = super.getData();

        for(int i = 1; i < fileData.size(); i++){
            String[] detail = fileData.get(i).split(",");
            if(Integer.parseInt(detail[0]) == Integer.parseInt(info[0])){
                fileData.remove(i);
                break;
            }
        }
        super.writeData(fileData);
    }

    public String showData(int id){
        List<String> fileData = super.getData();

        for(int i = 1; i < fileData.size(); i++){
            String itemInfo;
            String[] detail = fileData.get(i).split(",");
            if(Integer.parseInt(detail[0]) == id){
                itemInfo = fileData.get(i);
                System.out.println(itemInfo);
                return itemInfo;
            }
        }
        return null;
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
