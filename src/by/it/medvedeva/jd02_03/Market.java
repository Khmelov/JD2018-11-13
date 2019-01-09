package by.it.medvedeva.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Market {

    public static void main(String[] args) {
        List<Buyer> buyerList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        QueueBuyer buyers = new QueueBuyer();
        Util.initassort();

        System.out.println("Market opened. Welcome!");

        //for (int num = 1; num <=2 ; num++) {
        //    Cashier cashier = new Cashier(num);
        //    Thread thread = new Thread(cashier);
        //    thread.start();
        //    threads.add(thread);
        //}


        ExecutorService executor;
        executor = Executors.newFixedThreadPool(2);
        executor.execute(new Cashier(1, buyers));
        executor.execute(new Cashier(2, buyers));
        Semaphore vzale = new Semaphore(20);



        for (int time = 0; Dispatcher.marketOpened() ; time++) {
            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                if (Dispatcher.marketOpened()){
                    if (vzale.tryAcquire()) {
                        Buyer buyer = new Buyer(Dispatcher.getBuyerCounter(), vzale);
                        //buyers.add(buyer);
                        threads.add(buyer);
                        buyer.start();
                    } else {
                        System.out.println("Customer "+
                                Integer.toString(Dispatcher.getBuyerCounter())+
                                " not enter because market is full");
                        Util.sleep(50);
                    }
                }
            }

            Util.sleep(100);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        executor.shutdown();
        System.out.println("Market already closed. Time to sleep!");
        System.exit(0);
    }
}

