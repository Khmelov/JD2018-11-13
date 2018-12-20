package by.it.kruglenja.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        List<Buyer> buyers = new ArrayList<>();
        System.out.println("The market opens");

        for (int i = 0; i < 120; i++) {
            int buyerCount = Util.random(2);
            for (int j = 0; j < buyerCount; j++) {
                Buyer buyer = new Buyer(Dispathcer.buyerCounter++);
                buyers.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }
}
