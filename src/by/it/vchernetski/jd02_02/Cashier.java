package by.it.vchernetski.jd02_02;

import java.util.Map;

public class Cashier extends Thread {
    private String name;
    public boolean stop = true;
    private static final Object monitor = new Object();
    private static final Object monitorForPrint = new Object();
    protected static int totalsum;

    public Cashier(int number) {
        name = "---- Cashier №" + number + ":";
    }

    @Override
    public void run() {
//        System.out.println(this + " create");
        while (!Dispatcher.marketClosed()) {
            Buyer buyer;
            if (stop) {
//                System.out.println("касса отдыхает");
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (QueueBuyer.sizePensioneer() > 0) {
                buyer = QueueBuyer.extractPensioner();
            } else {
                buyer = QueueBuyer.extractNotPensioner();
            }
            if (buyer == null) Util.sleep(1);
            else {
                int time = Util.random(2000, 5000);
                Util.sleep(time);
                int sum = 0;
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, Integer> entry : buyer.choosenGoods.entrySet()) {
                    sb.append(entry.getKey() + " price:" + entry.getValue() + "\n");
                    sum += entry.getValue();
                    synchronized (monitor) {
                        totalsum += entry.getValue();
                    }
                    synchronized (monitorForPrint){
                        printresult(entry);
                    }
                }
//                System.out.println(this + " started service " + buyer +" Good(s): \n" + sb + "sum price: " + sum);

                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
//        System.out.println(this+"closed");
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean getStatus() {
        return stop;
    }
    private static synchronized int getsum(){
        return totalsum;
    }
    public void goToWork() {
//        System.out.println(this+"start working");
        this.stop = false;
        synchronized (this) {
            notify();
        }
    }

    public void close() {
//        System.out.println(this + "closed");
        this.stop = false;
        synchronized (this) {
            notify();
        }
    }
    public void printresult(Map.Entry<String,Integer> entry){

        if(this.toString().contains("1")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%10d|%10d\n",entry.getKey()+": "+entry.getValue()," "," "," "," ",QueueBuyer.getDequeSize(),getsum());
        }
        if(this.toString().contains("2")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%10d|%10d\n"," ",entry.getKey()+": "+entry.getValue()," "," "," ",QueueBuyer.getDequeSize(),getsum());
        }
        if(this.toString().contains("3")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%10d|%10d\n"," "," ",entry.getKey()+": "+entry.getValue()," "," ",QueueBuyer.getDequeSize(),getsum());
        }
        if(this.toString().contains("4")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%10d|%10d\n"," "," "," ",entry.getKey()+": "+entry.getValue()," ",QueueBuyer.getDequeSize(),getsum());
        }
        if(this.toString().contains("5")){
            System.out.printf("%20s|%20s|%20s|%20s|%20s|%10d|%10d\n"," "," "," "," ",entry.getKey()+": "+entry.getValue(),QueueBuyer.getDequeSize(),getsum());
        }
    }
}
