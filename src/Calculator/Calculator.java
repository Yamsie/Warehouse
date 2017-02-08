package Calculator;

/**
 * Created by James on 08/02/2017.
 * Controller makes the view and model work together, the two do not interact directly
 */
public class Calculator {
    public static void main(String [] args) {
        CalculatorView calcView = new CalculatorView();
        CalculatorModel calcModel = new CalculatorModel();
        CalculatorController calcController = new CalculatorController(calcView, calcModel);

        calcView.setVisible(true);
    }
}
