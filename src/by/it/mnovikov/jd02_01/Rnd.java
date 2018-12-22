package by.it.mnovikov.jd02_01;

import javax.xml.ws.Dispatch;

class Rnd {

    static int random(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis / Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleepTime(int from, int to) {
        try {
            Thread.sleep(Rnd.random(from, to));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
