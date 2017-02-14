package Calculator;

/**
 * Created by James on 08/02/2017.
 * Controller makes the view and model work together, the two do not interact directly
 * Adding this to test version control again
 */
public class Calculator {
    public static void main(String [] args) {
        CalculatorView calcView = new CalculatorView();
        CalculatorModel calcModel = new CalculatorModel();
        CalculatorController calcController = new CalculatorController(calcView, calcModel);
        //this is a test
        calcView.setVisible(true);
    }
}
