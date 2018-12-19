package by.it.denisova.jd02_01;

import java.util.ArrayList;
import java.util.List;


public class Shop {

    public static void main(String[] args) {
        List<Buyer> list = new ArrayList<>();
        System.out.println("Магазин открыт");
        for (int time = 0; time < 100 ; time++) {
            int buyerCount = Util.random(2);
            for (int i = 0; i <= buyerCount; i++ ) {
                Buyer buyer = new Buyer(Dispatcher.buyerCounter++);
                list.add(buyer);
                buyer.start();
            }
           // Util.sleep(1000);
        }
        for (Buyer buyer: list) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
