package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by James on 08/02/2017.
 * Handles interactions between view and model
 */
public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView inView, CalculatorModel inModel) {
        view = inView;
        model = inModel;

        this.view.addCalculationListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            int firstNumber, secondNumber = 0;

            try {
                firstNumber = view.getFirstNumber();
                secondNumber = view.getSecondNumer();

                model.addTwoNumbers(firstNumber, secondNumber);

                view.setCalcSolution(model.getCalculationValue());
            }

            catch(NumberFormatException ex) {
                view.displayErrorMessage("Enter two integers");
            }
        }

    }


}
