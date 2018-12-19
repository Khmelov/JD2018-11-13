package by.it.seroglazov.jd02_01;

import java.util.LinkedList;

public class Runner {

    private static int countBuyers = 0;
    private static final int K_SPEED = 100;

    public static void main(String[] args) {
        LinkedList<Buyer> buyers = new LinkedList<>();
        Shop shop = new Shop();
        for (int second = 0; second < 2 * 60; second++) {
            int c = MyRandom.getRandom(0, 2);
            for (int i = 0; i < c; i++) {
                buyers.add(new Buyer(countBuyers++, shop, K_SPEED));
            }
            sleepFor(1000);
        }
        buyers.forEach(x-> {
            try {
                x.join();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
        });
        System.out.println("Магазин завершил работу.");
    }

    private static void sleepFor(int millis){
        try {
            Thread.sleep(millis / K_SPEED);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }
}
