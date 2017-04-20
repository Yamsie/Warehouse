package BLL.Model.Box;

/**
 * Created by James on 24/03/2017.
 */
public class Box implements I_Box{

    //volume is measured in metres cubed
    private double volume;
    private int orderId;
    protected String boxName;

    public Box (double volume) {
        this.volume = volume;
    }

    public String boxName() {
        return boxName;
    }

    public double getVolume() {
        return volume;
    }
}