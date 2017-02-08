package Calculator;

/**
 * Created by James on 08/02/2017.
 * The model does handles all the logic
 */
public class CalculatorModel {

    private int calculationValue;

    public void addTwoNumbers(int firstNumber, int secondNumber) {
        calculationValue = firstNumber + secondNumber;
    }

    public int getCalculationValue(){
        return calculationValue;
    }
}
