package by.epam.task3.view.output;

public class PrintResultOnConsole {

    private String result;

    public PrintResultOnConsole(String result) {
        this.result = result;
    }

    private String getResult() {
        return result;
    }

    public void printResultOnConsole (){

        System.out.println(getResult());
    }



}
