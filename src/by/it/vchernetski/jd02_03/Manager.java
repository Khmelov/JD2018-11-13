package by.it.vchernetski.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager extends Thread {
    private int workingCashiers=0;
    Manager() {
        super();
    }

    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Cashier cashier3 = new Cashier(3);
        Market.cashiers.add(cashier3);
        executorService.execute(cashier3);
        Cashier cashier4 = new Cashier(4);
        Market.cashiers.add(cashier4);
        executorService.execute(cashier4);
        Cashier cashier5 = new Cashier(5);
        Market.cashiers.add(cashier5);
        executorService.execute(cashier5);
        executorService.shutdown();
        while (!Dispatcher.marketClosed()) {
            int n = neededNumOfCashiers();
            if(n==this.workingCashiers) {
                Util.sleep(1000);
                continue;
            }
            if(workingCashiers<n){
                for (Cashier cashier: Market.cashiers) {
                    if(workingCashiers==n) break;
                    if(cashier.getStatus()) {
                        this.workingCashiers++;
                        cashier.goToWork();
                    }
                }
                continue;
            }
            if(workingCashiers>n){
                for (Cashier cashier: Market.cashiers) {
                    if(workingCashiers==n) break;
                    if(!(cashier.getStatus())) {
                        this.workingCashiers--;
                        cashier.stop=true;
                    }
                }
            }
            Util.sleep(2000);
        }
        for (Cashier cashier: Market.cashiers) {
            cashier.close();
        }
    }
    private static int neededNumOfCashiers(){
        int dequeSize = QueueBuyer.buyers.size();
        if(dequeSize<5) return 1;
        if(dequeSize>=5&&dequeSize<10) return 2;
        if(dequeSize>=10&&dequeSize<15) return 3;
        if(dequeSize>=15&&dequeSize<20) return 4;
        if(dequeSize>=20) return 5;
        return 0;
    }
    public synchronized  int getWorkingCashiers(){
        return workingCashiers;
    }
}
