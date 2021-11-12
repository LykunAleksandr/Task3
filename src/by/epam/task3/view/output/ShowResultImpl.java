package by.epam.task3.view.output;

import by.epam.task3.service.CalculateFromStringImpl;

public class ShowResultImpl implements ShowResalt {

    private static ShowResultImpl instance = new ShowResultImpl();

    public ShowResultImpl() {
    }

    public static ShowResultImpl getInstance() {
        return instance;
    }

    @Override
    public void showResalt() {
        CalculateFromStringImpl calc = CalculateFromStringImpl.getInstance();
        PrintResultOnConsole printer = new PrintResultOnConsole(calc.getStringForCulculation() + " = " +calc.getResult());
        printer.printResultOnConsole();
    }
}
