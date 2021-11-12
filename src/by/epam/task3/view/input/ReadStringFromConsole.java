package by.epam.task3.view.input;

import java.util.Scanner;

public class ReadStringFromConsole {

    private String stringFromConsole;

    public String getStringFromConsole() {
        return stringFromConsole;
    }

    public boolean readStringFromConsol() {
        boolean isOk = false;
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        String str = null;
        do {
            isCorrect = false;
            System.out.println("Введите вырвжение для вычисления");
            str = scanner.nextLine();

//            String[] stringArray = number.split("");
//            for (int i = 0; i < 4; i++) {
//                try {
//                    array [i] = Integer.valueOf(stringArray[i]);
//                } catch (NumberFormatException e) {
//                    System.out.println("Не верный формат");
//                    e.printStackTrace();
//                    isCorrect = true;
//                    break;
//                }
//            }
        }while (isCorrect);
        this.stringFromConsole = str;
        return true;

    }
}
