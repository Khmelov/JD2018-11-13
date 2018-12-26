package by.it.kruglenja.jd01_01;

import java.util.Scanner;

public class Input {//Первоначальная инициализация игрового поля и присвоение игрокам желаемых идентификаторов
    private static String[] gameField = new String[9];

    public static String[] getGameField() { return gameField; }

    private static String player1 = "";
    private static String player2 = "";

    static void gameFieldInitialization() {
        for (int i = 0; i < gameField.length; i++) {
            gameField[i] = String.valueOf(i);
        }
        System.out.println("Здравствуйте, вас приветствует приложение крестики-нолики, введите букву латинскиго алфавита Х или О, которой вы хотите ходить: ");
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
        for (int i = 0; i <= 8; i++) {
            Scanner sc = new Scanner(System.in);
            if (player1Turn) {
                System.out.println("Введите цифру, вместо которой будет " + player1);
                int fieldIndex = sc.nextInt();
                gameField[fieldIndex] = player1;
                player1Turn = false;
            } else {
                System.out.println("Введите цифру, вместо которой будет " + player2);
                int fieldIndex = sc.nextInt();
                gameField[fieldIndex] = player2;
                player1Turn = true;
            }
            if (i >= 4) {
                int win = Logic.isWin();
                if (Logic.getWin()) {
                    if ((player1.equalsIgnoreCase("O") && win == 0) || (player1.equalsIgnoreCase("X") && win == 1)) {
                        System.out.println("Поздравляем, игрок 1 подебил");
                        break;
                    } else {
                        System.out.println("Поздравляем, игрок 2 победил");
                        break;
                    }
                }
            }
            Printer.printField(Input.getGameField());
        }
    }
}
