package BLL.Model.Box;

import BLL.Model.Inventory.Item;
import BLL.Model.Order.CustomerOrder;

import java.util.List;

/**
 * Created by James on 24/03/2017.
 */
public class BoxFactory {
    public I_Box createBox(CustomerOrder order) {
        double volume = calculateVolume(order);

        if (volume > 0 && volume <= 1) { //BoxA
            return new BoxA();
        }
        else if (volume > 1 && volume <= 1.5) { //BoxB
            return new BoxB();
        }
        else if (volume > 1.5 && volume <= 2) { //BoxC
            return new BoxC();
        }
        else if (volume > 2 && volume <= 3) { //BoxD
            return new BoxD();
        }
        else if (volume > 3 && volume <= 5) { //BoxE
            return new BoxE();
        }
        else if (volume > 5 && volume <= 7.5) { //BoxF
            return new BoxF();
        }
        else if (volume > 7.5 && volume <= 10) { //BoxG
            return new BoxG();
        }

        return null;
    }

    public double calculateVolume(CustomerOrder order) {
        double totalVolume = 0.0;
        List<Item> itemList = order.getItems();
        for (int i = 0; i < itemList.size(); i++) {
            totalVolume += itemList.get(i).getVolume();
        }

        return totalVolume;
    }
}
