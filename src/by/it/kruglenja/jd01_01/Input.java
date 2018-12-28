package by.it.kruglenja.jd01_01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {//Первоначальная инициализация игрового поля и присвоение игрокам желаемых идентификаторов
    private static String[] gameField = new String[9];

    public static String[] getGameField() { return gameField; }

    private static String player1 = "";
    private static String player2 = "";

    static void gameFieldInitialization() {
        for (int i = 0; i < gameField.length; i++) {
            gameField[i] = String.valueOf(i);
        }
        System.out.println("Здравствуйте, вас приветствует приложение крестики-нолики, введите букву латинскиго алфавита Х или О, которой вы будете ходить: ");
        Scanner sc = new Scanner(System.in);
        while (player1.equals("")) {
            String temp = sc.next();
            sc.nextLine();
            if ((temp.equalsIgnoreCase("O"))) {
                player1 = "O";
                player2 = "X";
                System.out.println("Игрок 1 :: " + player1 + "\n" + "Игрок 2 :: " + player2 + "\n");
            } else if (temp.equalsIgnoreCase("X")) {
                player1 = "X";
                player2 = "O";
                System.out.println("Игрок 1 :: " + player1 + "\n" + "Игрок 2 :: " + player2 + "\n");
            } else {
                System.out.println("Введен неккоректный идентификатор игрока 1, пожалуйста, введите букву еще раз :");
            }
        }
    }

    static void playersTurn() {
        boolean player1Turn = true;
        Pattern pattern = Pattern.compile("[0-8]*");
        for (int i = 0; i <= 8; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите цифру, вместо которой будет " + (player1Turn ? player1 : player2));
            String fieldIndex = sc.next();
            Matcher matcher = pattern.matcher(fieldIndex);
            if (matcher.find() && fieldIndex.length() == 1) {
                gameField[Integer.parseInt(fieldIndex)] = player1Turn ? player1 : player2;
                player1Turn = !player1Turn;
            } else {
                System.out.println("Не балуйся и вводи нормально");
            }
            if (i >= 4) {
                int win = Logic.isWin();
                if (Logic.getWin()) {
                    if ((player1.equalsIgnoreCase("O") && win == 0) || (player1.equalsIgnoreCase("X") && win == 1)) {
                        Printer.printField(Input.getGameField());
                        System.out.println("Поздравляем, игрок 1 подебил");
                        break;
                    } else {
                        System.out.println("Поздравляем, игрок 2 победил");
                        Printer.printField(Input.getGameField());
                        break;
                    }
                }else {
                    System.out.println("Ничья, епта");
                }
            }
            Printer.printField(Input.getGameField());
        }
    }
}
