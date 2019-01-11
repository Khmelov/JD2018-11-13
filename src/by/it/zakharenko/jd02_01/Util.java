package by.it.zakharenko.jd02_01;

public class Util {

    public static int random(int max) {
        return random(0, max);
    }

    public static int random(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis/Dispatcher.SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}