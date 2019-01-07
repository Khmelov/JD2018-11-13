package by.it.kruglenja.jd01_01;

public class Runner {
    public static void main(String[] args) {
        Input.gameFieldInitialization();
        Printer.printField(Input.getGameField());
        Input.playersTurn();
    }
}
