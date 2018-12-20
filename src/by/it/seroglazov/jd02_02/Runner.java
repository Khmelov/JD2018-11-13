package by.it.seroglazov.jd02_02;

import java.util.LinkedList;

public class Runner {

    private static int countBuyers = 0;
    private static final int K_SPEED = 100;

    public static void main(String[] args) {
        LinkedList<Buyer> buyers = new LinkedList<>();
        Shop shop = new Shop();

        //Запускаем двух кассиров
        Cashier cashier1 = new Cashier(1, shop, K_SPEED);
        Cashier cashier2 = new Cashier(2, shop, K_SPEED);

        // Сразу 10 запускаем
        System.out.println("Магазин открылся");
        for (int i = 0; i < 10; i++) {
            buyers.add(new Buyer(countBuyers++, shop, K_SPEED));
            sleepFor(1);
        }
        sleepFor(1000);

        for (int second = 1; second < 2 * 60; second++) {
            System.out.println("********* СЕКУНДА " + String.valueOf(second) + " *********");
            int c = getMaxBuyersCount(second);
            while (shop.buyersCount() < c) {
                buyers.add(new Buyer(countBuyers++, shop, K_SPEED));
                sleepFor(1);
            }
            sleepFor(1000);
        }

        // Ждем пока все выйдут
        buyers.forEach(x-> {
            try {
                x.join();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
        });

        // Отпускаем кассиров
        cashier1.endOfWorkDay();
        cashier2.endOfWorkDay();

        System.out.println("Магазин завершил работу.");

    }

    private static void sleepFor(int millis){
        try {
            Thread.sleep(millis / K_SPEED);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
    }

    private static int getMaxBuyersCount(int second){
        int h = second / 60;
        int s = second - h*60;
        if (s <= 30) return 10 + s;
        else return 40 - (s - 30);
    }

}
