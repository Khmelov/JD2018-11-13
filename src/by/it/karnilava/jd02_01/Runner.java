package by.it.karnilava.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static int countBuyers = 0; // общий счетчик покупателей


    public static void main(String[] args) throws InterruptedException {
        new ListOfGoods();

        // создаем  обычную очередь для покупателей

        Queue<Buyer> queue = new ArrayDeque<>();

        while (countBuyers<10){
            Thread.sleep(1000);
            int count = Rnd.fromTo(0,2);
            for (int i = 0; i <= count; i++) {
                countBuyers++;
                if (countBuyers<11){
                    Buyer buyer = new Buyer(countBuyers);
                    queue.add(buyer);
                }

            }
        }

    }
}
