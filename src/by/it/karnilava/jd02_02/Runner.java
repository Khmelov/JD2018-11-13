package by.it.karnilava.jd02_02;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Runner {
    static AtomicInteger countBuyers = new AtomicInteger(0); // общий счетчик покупателей (сколько было всего)
    static AtomicInteger currentNumberOfBuyers = new AtomicInteger(0);//текущее число покупателей в магазине
    static Queue<Buyer> queue = new ArrayDeque<>();
    static int time;


    public static void main(String[] args) throws InterruptedException {
        new ListOfGoods();
        new AvailableCashdesks();

       //  System.out.println("The Shop is open");

//     НАЧАЛО ПЕЧАТИ ТАБЛИЦЫ
//
 for (int i = 0; i < 40 * 7 + 1; i++) {
            System.out.printf("_");
        }
        String delim = "|";
        System.out.println();
        System.out.printf("%40s%40s%40s%40s%40s%40s%40s%n", "Cashier #1"+delim,"Cashier #2"+delim,"Cashier #3"+delim,"Cashier #4"+delim,"Cashier #5"+delim,"Size of queue"+delim, "Gross Income"+delim);
        for (int i = 0; i < 40 * 7 + 1; i++) {
            System.out.printf("_");
        }
        System.out.println();


        // создаем  обычную очередь для покупателей


        new Cashier(1);


        for (time = 0; time < 120; time++) {
            if (time < 31) {
                add10Buyers(time);
            }
            if (time > 60 && time < 91) {
                add10Buyers(time - 60);

            }

            // Блок для времени, когда число людей в магазине варьируется от 30 до 40
            else {

                int seconds;
                if (time > 30 && time < 60) {
                    seconds = time;
                    add30_40Buyers(seconds);
                }
                if (time > 90 && time < 120) {
                    seconds = time - 60;
                    add30_40Buyers(seconds);
                }


            }
          //  System.out.println(time + " " + currentNumberOfBuyers);
            Thread.sleep(1000);
        }


    }

    static void add30_40Buyers(int seconds) {
        if (currentNumberOfBuyers.get() <= (40 + (30 - seconds))) {
            int count = Rnd.fromTo(0, 2);
            for (int i = 0; i <= count; i++) {
                if (currentNumberOfBuyers.get() < (40 + (30 - seconds))) {
                    if (countBuyers.get() % 4 == 0) {
                        Buyer buyer = new Buyer(countBuyers.get(), true);
                        queue.add(buyer);
                        countBuyers.getAndAdd(+1);
                      //  System.out.println("Attention! " + buyer + " is a pensioneer!");
                    } else {
                        Buyer buyer = new Buyer(countBuyers.get(), false);
                        queue.add(buyer);
                        countBuyers.getAndAdd(+1);
                    }

                }
            }
        }
    }

    static void add10Buyers(int time) {
        while (currentNumberOfBuyers.get() < 10 + time) {
            int count = Rnd.fromTo(0, 2);
            for (int i = 0; i <= count; i++) {
                if (countBuyers.get() % 4 == 0) {
                    Buyer buyer = new Buyer(countBuyers.get(), true);
                    queue.add(buyer);
                    countBuyers.getAndAdd(+1);
                    //System.out.println("Attention! " + buyer + " is a pensioneer!");
                } else {
                    Buyer buyer = new Buyer(countBuyers.get(), false);
                    queue.add(buyer);
                    countBuyers.getAndAdd(+1);
                }
            }
        }
    }

    static boolean isMarketClose() {
        if (time < 120) {
            return false;
        } else {
            return currentNumberOfBuyers.get() == 0;
        }
    }
}















