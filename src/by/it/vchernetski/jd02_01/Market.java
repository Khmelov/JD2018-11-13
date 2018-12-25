package by.it.vchernetski.jd02_01;

import java.util.ArrayList;
import java.util.List;

/*
количество покупателей находящихся в магазине выводится каждые 15 секунд
 */
public class Market {
    private static void print(int time) {
        System.out.println("======================================\n" + time + " sec" + "\t"
                + Buyer.getNumOfBuyers() + " buyers" + "\n======================================\n");
    }

    public static void main(String[] args) {
        List<Buyer> buyerList = new ArrayList<>();
        Good.fillMapGoods();
        System.out.println("Market opened");
        for (int time = 0; time < 120; time++) {
            int sec = time%60;
            int buyerCount;
            if (time == 0) {
                for (int i = 0; i < 10; i++) {
                    Buyer buyer = new Buyer(Dispatcher.buyerCounter++);
                    buyer.start();
                }
                Util.sleep(1000);
                print(time);
                continue;
            }
            buyerCount = Util.random(2);
            for (int i = 1; i < buyerCount; i++) {
                Buyer buyer = new Buyer(Dispatcher.buyerCounter++);
                buyer.start();
            }
            Util.sleep(1000);
            if (sec < 31) {
                if (Buyer.getNumOfBuyers() < sec + 10) {
                    while (Buyer.getNumOfBuyers() < sec + 10) {
                        buyerCount = Util.random(2);
                        for (int i = 1; i < buyerCount; i++) {
                            Buyer buyer = new Buyer(Dispatcher.buyerCounter++);
                            buyer.start();
                        }
                    }
                }
            }
            if (sec > 30) {
                if (Buyer.getNumOfBuyers() <= 70 - sec) {
                    while (Buyer.getNumOfBuyers() < 70-sec) {
                        buyerCount = Util.random(2);
                        for (int i = 1; i < buyerCount; i++) {
                            Buyer buyer = new Buyer((Dispatcher.buyerCounter++) + 9);
                            buyer.start();
                        }
                    }
                }
            }
            Util.sleep(1000);
            if(time%15==0) print(time);
        }
        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }

}
