package by.it.berdnik.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        List<Buyer> buyerList = new ArrayList<>();
        GoodShop.products();
        System.out.println(GoodShop.product.entrySet());
        System.out.println("Market opened");

        for (int time = 0; time < 120; time++) {
            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                Buyer buyer = new Buyer(Dispatcher.buyerCounter++);
                buyerList.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
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
