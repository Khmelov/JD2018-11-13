package by.it.naumenko.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Shop {
    public static void main(String[] args) {
        List<Thread> threadByuers = new ArrayList<>();
        Tovar.clearTovar();
        System.out.println(Tovar.tovar.entrySet());
        System.out.println("Магазин открылся");

        ExecutorService executorService =  Executors.newFixedThreadPool(5);
        executorService.execute(new Cashier(1));
        executorService.execute(new Cashier(2));
        executorService.shutdown();

        while (Dispecher.shopOpened()) {
            int byuerCount = Util.random(2);
            for (int i = 0; i < byuerCount; i++) {
                if (Dispecher.shopOpened()) {
                    Buyer byuer = new Buyer(Dispecher.getBuyerCounter());
                    threadByuers.add(byuer);
                    byuer.start();
                }
            }
            Util.sleep(1000);
        }
        for (Thread element : threadByuers) {
            try {
                element.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (!(executorService.isTerminated())){
            Util.sleep(1);
        }
        System.out.println("Магазин закрылся");
    }
}
