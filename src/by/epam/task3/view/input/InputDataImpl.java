package by.epam.task3.view.input;

public class InputDataImpl implements InputData {
    private static final InputDataImpl instance = new InputDataImpl();
    ReadStringFromConsole consolStringReader = new ReadStringFromConsole();
    private String stringForCulculation;


    public InputDataImpl() {
    }

    public static InputDataImpl getInstance() {
        return instance;
    }

    public String getStringForCulculation() {
        return stringForCulculation;
    }

    @Override
    public void readData() {
       consolStringReader.readStringFromConsol();
        this.stringForCulculation = consolStringReader.getStringFromConsole();

    }
}
