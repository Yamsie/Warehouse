package BLL.Model.Order;

/**
 * Created by Lenovo on 2017/4/16.
 */
public class TemporaryOrder {
    private String ItemID;
    private int count = 1;
    private boolean exist = false;

    public TemporaryOrder(String ItemID){
        this.ItemID = ItemID;
    }

    public void add(){
        count++;
    }

    public String getItemID(){
        return ItemID;
    }

    public int getCount(){
        return count;
    }
}
