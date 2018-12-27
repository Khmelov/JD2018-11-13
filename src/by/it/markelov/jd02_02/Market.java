package by.it.markelov.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        List<Thread> listOfTreads = new ArrayList<>();
        Goods.fillPricelist();

        Cashier cashier1 = new Cashier("Кассир №1");
        listOfTreads.add(cashier1);
        Cashier cashier2 = new Cashier("Кассир №2");
        listOfTreads.add(cashier2);

        for (int i = 0; i < 120; i++) {
            int random = Util.random(0, 2);
            for (int j = 1; j <= random; j++) {
                Buyer buyer = new Buyer("Покупатель № " + Dispatcher.buyersCreated);
                listOfTreads.add(buyer);
            }
            if (Dispatcher.buyersCreated>100) break;


            try {
                Thread.sleep(1000 / Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread tread : listOfTreads) {
            try {
                tread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Магазин закрылся-----------------------------------------------------");
    }
}
