package by.it.kovalyova.jd02_02;

import java.util.ArrayList;
import java.util.List;


public class Market {

    public static void main(String[] args) {
        List<Buyer> buyerList = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        QueueBuyer buyers = new QueueBuyer();

        System.out.println("Market opened. Welcome!");

        //for (int num = 1; num <=2 ; num++) {
        //    Cashier cashier = new Cashier(num);
        //    Thread thread = new Thread(cashier);
        //    thread.start();
        //    threads.add(thread);
        //}

        int cashiers = 0;
        for (int time = 0; Dispatcher.marketOpened() ; time++) {
            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                if (Dispatcher.marketOpened()){
                    Buyer buyer=new Buyer(Dispatcher.getBuyerCounter(),buyers);
                    //buyers.add(buyer);
                    threads.add(buyer);
                    buyer.start();
                }
            }

            if (buyers.getSize()>5) {
                //включаем кассу
                Cashier cashier = new Cashier(cashiers,buyers);
                cashiers++;
                while (!buyers.getLock()) {
                    Util.sleep(50);
                }
                int toq = 5;
                if (buyers.getSize()<5) {
                    toq = buyers.getSize();
                }
                for (int i = 0; i<5; i++) {
                    cashier.myqueue.add(buyers.extract());
                }
                buyers.releaseLock();
                Thread thread = new Thread(cashier);
                thread.start();

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
        System.out.println("Market already closed. Time to sleep!");
    }
    }

