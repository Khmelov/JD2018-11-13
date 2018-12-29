package by.it.seroglazov.jd02_03;

public class SleepCases {

    static void sleepRandom(int minMillis, int maxMillis) {
        int millis = MyRandom.getRandom(minMillis, maxMillis);
        try {
            Thread.sleep(millis / Runner.K_SPEED);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }

    static void sleepFor(int millis) {
        try {
            Thread.sleep(millis / Runner.K_SPEED);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }
}
