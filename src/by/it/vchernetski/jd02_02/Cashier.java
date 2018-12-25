package by.it.vchernetski.jd02_02;

import java.util.Map;

public class Cashier extends Thread {
    private String name;
    public boolean stop = true;
    private static final Object monitor = new Object();
    protected static int totalsum=0;
    public Cashier(int number) {
        name = "---- Cashier №" + number + ":";
    }

    @Override
    public void run() {
        System.out.println(this + " create");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer;
            if(stop){
                System.out.println("касса отдыхает");
                synchronized (this){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
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
        System.out.println(this+"closed");
    }
    @Override
    public String toString() {
        return name;
    }
    public boolean getStatus(){
        return  stop;
    }
    public void goToWork(){
        System.out.println(this+"start working");
        this.stop=false;
        synchronized (this){
            notify();
        }
    }
    public void close(){
        System.out.println(this + "closed");
        this.stop=false;
        synchronized (this){
            notify();
        }
    }
}
