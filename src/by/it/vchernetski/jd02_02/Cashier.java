package by.it.vchernetski.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Cashier implements Runnable {
    private String name;
    private static final Object monitor = new Object();
    protected static int totalsum=0;
    public Cashier(int number) {
        name = "---- Cashier №" + number + ":";
    }

    @Override
    public void run() {
        System.out.println(this + " ready and wait");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer;
            StringBuilder nl = new StringBuilder();
            StringBuilder goods= new StringBuilder();
            if(QueueBuyer.sizePensioneer()>0){
                buyer = QueueBuyer.extractPensioner();
            }
            else{
                buyer=QueueBuyer.extractNotPensioner();
            }
            if (buyer == null) Util.sleep(1);
            else {
                int time = Util.random(2000, 5000);
                Util.sleep(time);
                int sum=0;
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Integer> entry : buyer.choosenGoods.entrySet()) {
                    sb.append(entry.getKey() + " price:" + entry.getValue() + "\n");
                    sum += entry.getValue();
                    synchronized (monitor){
                        totalsum+=sum;
                    }
                }
                System.out.println(this + " started service " + buyer +" Good(s): \n" + sb + "sum price: " + sum);
                synchronized (buyer) {
                    buyer.notify();
                }

            }
        }
    }
    @Override
    public String toString() {
        return name;
    }
}
