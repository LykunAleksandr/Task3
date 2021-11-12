package by.epam.task3;

import by.epam.task3.view.Calculator.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        CalculatorImpl calculator = CalculatorImpl.getInstance();
        calculator.start();
    }

}
