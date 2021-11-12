package by.epam.task3.view.Calculator;

import by.epam.task3.service.CalculateFromStringImpl;
import by.epam.task3.view.input.InputDataImpl;
import by.epam.task3.view.output.ShowResultImpl;

public class CalculatorImpl implements Calculator {
    private static final CalculatorImpl instance = new CalculatorImpl();

    public CalculatorImpl() {
    }

    public static CalculatorImpl getInstance() {
        return instance;
    }

    @Override
    public void start(){
        InputDataImpl inputData = InputDataImpl.getInstance();
        ShowResultImpl outputdata = ShowResultImpl.getInstance();
        CalculateFromStringImpl calculator = CalculateFromStringImpl.getInstance();

        inputData.readData();
        calculator.calculate(inputData.getStringForCulculation());
        outputdata.showResalt();

    }
}
