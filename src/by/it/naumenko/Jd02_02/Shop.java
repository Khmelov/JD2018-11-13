package by.it.naumenko.Jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        List<Buyer> byuerList = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        Tovar.clearTovar();
        System.out.println(Tovar.tovar.entrySet());
        System.out.println("Магазин открылся");

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashier);
            threadCashier.start();
            threadList.add(threadCashier);
        }

        while (Dispecher.shopOpened()) {
        //for (int k = 0; k < 10; k++) {
            int byuerCount = Util.random(2);
            for (int i = 0; i < byuerCount; i++) {
                if (Dispecher.shopOpened()) {
                    Buyer byuer = new Buyer(Dispecher.getBuyerCounter());
                    threadList.add(byuer);
                    byuer.start();
                }
            }
            Util.sleep(1000);
        }
        for (Thread element : threadList) {
            try {
                element.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрылся");
        System.out.println(Buyer.chek);
    }
}
