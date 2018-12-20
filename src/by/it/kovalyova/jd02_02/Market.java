package by.it.kovalyova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        List<Buyer> buyerList = new ArrayList<>();
        System.out.println("Market opened. Welcome!");

        for (int num = 1; num <=2 ; num++) {
            Cashier cashier = new Cashier(num);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        for (int time = 0; Dispatcher.marketOpened() ; time++) {
            int buyerCount =Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                if (Dispatcher.marketOpened()){
                    Buyer buyer=new Buyer(Dispatcher.getBuyerCounter());
                    threads.add(buyer);
                    buyer.start();
                }
        }
            Util.sleep(1000);
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

