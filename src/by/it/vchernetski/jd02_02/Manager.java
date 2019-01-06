package by.it.vchernetski.jd02_02;

import java.util.Map;

public class Manager extends Thread {
    private int workingCashiers=0;
    Manager() {
        super();
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            Cashier cashier = new Cashier(i);
            Market.cashiers.add(cashier);
            cashier.start();
        }
        while (!Dispatcher.marketClosed()) {
            int n = neededNumOfCashiers();
            if(n==this.workingCashiers) {
                Util.sleep(1000);
                continue;
            }
            if(workingCashiers<n){
                for (Cashier cashier:Market.cashiers) {
                    if(workingCashiers==n) break;
                    if(cashier.getStatus()) {
                        this.workingCashiers++;
                        cashier.goToWork();
                    }
                }
                continue;
            }
            if(workingCashiers>n){
                for (Cashier cashier:Market.cashiers) {
                    if(workingCashiers==n) break;
                    if(!(cashier.getStatus())) {
                        this.workingCashiers--;
                        cashier.stop=true;
                    }
                }
            }
            Util.sleep(2000);
        }
        for (Cashier cashier:Market.cashiers) {
            cashier.close();
        }
    }
    private static int neededNumOfCashiers(){
        int dequeSize = QueueBuyer.getDequeSize();
        if(dequeSize<=5) return 1;
        if(dequeSize>5&&dequeSize<=10) return 2;
        if(dequeSize>10&&dequeSize<=15) return 3;
        if(dequeSize>15&&dequeSize<=20) return 4;
        if(dequeSize>20) return 5;
        return 0;
    }
    public synchronized  int getWorkingCashiers(){
        return workingCashiers;
    }
}
