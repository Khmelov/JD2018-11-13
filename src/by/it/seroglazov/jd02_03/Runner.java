package by.it.seroglazov.jd02_03;

import java.util.LinkedList;

public class Runner {

    private static final int MAX_COUNT = 100;
    private static int countBuyers = 0;
    static final int K_SPEED = 100;
    // Писать полный лог
    static final boolean FULL_LOG = false;
    // Выводить таблицу
    static final boolean TABLE_MODE = !FULL_LOG;
    // При выводе в колонку сколько символов ширина колонки
    static final int CHARR_IN_COLUMN = 17;
    static final String EMPTY_COL = "                                           ".substring(0, CHARR_IN_COLUMN);
    private static LinkedList<Buyer> buyers = new LinkedList<>();

    public static void main(String[] args) {
        //System.out.println("Магазин открылся");

        Shop shop = new Shop();

        for (int second = 1; countBuyers < MAX_COUNT; second++) {
            if (FULL_LOG) System.out.println("********* СЕКУНДА " + String.valueOf(second) + " *********");
            int c = getMaxBuyersCount(second);
            int l;
            while ((l = LiveBuyersCount()) <= c) {
                buyers.add(new Buyer(countBuyers++, shop));
                if (FULL_LOG) System.out.println("Родился N"+countBuyers +". (Всего живых " + l + ")");
                if (countBuyers >= MAX_COUNT) break;
            }
            if (countBuyers >= MAX_COUNT) break;
            SleepCases.sleepFor(1000);
        }
        // Магазин закрывает менеджер
    }

    private static int LiveBuyersCount() {
        int count = 0;
        for (Buyer buyer : buyers) {
            if (buyer.isAlive()) count++;
        }
        return count;
    }

    private static int getMaxBuyersCount(int second){
        int h = second / 60;
        int s = second - h*60;
        if (s <= 30) return 10 + s;
        else return 40 - (s - 30);
    }

}
