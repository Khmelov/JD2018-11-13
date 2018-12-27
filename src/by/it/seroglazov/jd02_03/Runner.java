package by.it.seroglazov.jd02_03;

import java.util.LinkedList;

public class Runner {

    private static final int MAX_COUNT = 100;
    private static int countBuyers = 0;
    static final int K_SPEED = 100;
    // Писать полный лог
    static final boolean FULL_LOG = true;
    // Выводить таблицу
    static final boolean TABLE_MODE = !FULL_LOG;
    // При выводе в колонку сколько символов ширина колонки
    static final int CHARR_IN_COLUMN = 17;
    static final String EMPTY_COL = "                                           ".substring(0, CHARR_IN_COLUMN);

    public static void main(String[] args) {
        //System.out.println("Магазин открылся");

        LinkedList<Buyer> buyers = new LinkedList<>();
        Shop shop = new Shop();

        // Сразу 10 запускаем
        for (int i = 0; i < 10; i++) {
            buyers.add(new Buyer(countBuyers++, shop));
            SleepCases.sleepFor(1);
        }
        SleepCases.sleepFor(1000);

        for (int second = 1; countBuyers < MAX_COUNT; second++) {
            if (FULL_LOG) System.out.println("********* СЕКУНДА " + String.valueOf(second) + " *********");
            int c = getMaxBuyersCount(second);
            while (shop.buyersCount() < c) {
                buyers.add(new Buyer(countBuyers++, shop));
                if (countBuyers > MAX_COUNT) break;
                SleepCases.sleepFor(1);
            }
            if (countBuyers > MAX_COUNT) break;
            SleepCases.sleepFor(1000);
        }
        // Магазин закрывает менеджер
    }

    private static int getMaxBuyersCount(int second){
        int h = second / 60;
        int s = second - h*60;
        if (s <= 30) return 10 + s;
        else return 40 - (s - 30);
    }

}
