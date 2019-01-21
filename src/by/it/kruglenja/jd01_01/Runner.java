package by.it.kruglenja.jd01_01;

public class Runner {
    public static void main(String[] args) {
        try {
            Input.gameFieldInitialization();
            Printer.printField(Input.getGameField());
            Input.playersTurn();
        }catch (Exception e){
            Logger logger = Logger.getInstance();
            logger.log(e.getStackTrace().toString());
            e.getStackTrace();
        }
    }
}
