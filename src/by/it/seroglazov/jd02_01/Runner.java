package by.it.seroglazov.jd02_01;

public class Runner {

    static int countBuyers = 0;

    public static void main(String[] args) {
        for (int second = 0; second < 2 * 60; second++) {
            int c = MyRandom.getRandom(0, 2);
            for (int i = 0; i < c; i++) {
                Buyer b = new Buyer(countBuyers++);
            }
            sleepFor(1);
        }
    }

    static void sleepFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }
}
