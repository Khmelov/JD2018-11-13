package by.it.zakharenko.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    static List<Basket> basketList = new ArrayList<>();
    static List<Good> goodList = new ArrayList<>();

    public static void main(String[] args) {
        List<Buyer> buyerList = new ArrayList<>();


        for (int i = 0; i < 100; i++) {
            goodList.add(new Good());
        }

        for (int i = 0; i < 3; i++) {
            basketList.add(new Basket());
        }

        System.out.println("Market is open");

        for (int millis = 0; millis < 120; millis++) {
            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                Buyer buyer = new Buyer(Dispatcher.buyerCounter++);
                buyerList.add(buyer);
                buyer.start();
            }
            Util.sleep(100);
        }

        for (Buyer buyer : buyerList) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed");
    }

    public static void giveSomeBaskets() {
        for (int counter = 0; counter < 2; counter++) {
            basketList.add(new Basket());
        }
    }
}
