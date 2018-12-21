package by.it.seroglazov.jd02_02;

import java.util.LinkedList;

public class Runner {

    private static final int MAX_COUNT = 100;
    private static int countBuyers = 0;
    static final int K_SPEED = 100;

    public static void main(String[] args) {
        System.out.println("Магазин открылся");
        LinkedList<Buyer> buyers = new LinkedList<>();
        Shop shop = new Shop();

        // Сразу 10 запускаем
        for (int i = 0; i < 10; i++) {
            buyers.add(new Buyer(countBuyers++, shop));
            SleepCases.sleepFor(1);
        }
        SleepCases.sleepFor(1000);

        for (int second = 1; countBuyers < MAX_COUNT; second++) {
            System.out.println("********* СЕКУНДА " + String.valueOf(second) + " *********");
            int c = getMaxBuyersCount(second);
            while (shop.buyersCount() < c) {
                buyers.add(new Buyer(countBuyers++, shop));
                if (countBuyers > MAX_COUNT) break;
                SleepCases.sleepFor(1);
            }
            if (countBuyers > MAX_COUNT) break;
            SleepCases.sleepFor(1000);
        }

        // Ждем пока все выйдут
        buyers.forEach(x-> {
            try {
                x.join();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
        });

        System.out.println("Магазин завершил работу.");

    }
/*
    private static void sleepFor(int millis){
        try {
            Thread.sleep(millis / K_SPEED);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }*/

    private static int getMaxBuyersCount(int second){
        int h = second / 60;
        int s = second - h*60;
        if (s <= 30) return 10 + s;
        else return 40 - (s - 30);
    }

}
