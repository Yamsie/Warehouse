package BLL.Model.Box;

/**
 * Created by James on 18/04/2017.
 */
public class CustomBox extends Box {

    public CustomBox(double volume) {
        super((int) volume + 1); //rounds box up to next metre squared
        boxName = "CustomBox";
    }
}
