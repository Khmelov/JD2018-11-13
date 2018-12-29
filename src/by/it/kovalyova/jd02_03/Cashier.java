package by.it.kovalyova.jd02_03;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number, QueueBuyer queue){
        name = "--- Cashier №" + number + ": ";
    }

    @Override
    public void run() {
        System.out.println(this+" started work");
        while (!Dispatcher.marketClosed()){
            Buyer buyer = QueueBuyer.extract();
            if (buyer!=null) {
                System.out.println(this + "started service " + buyer);
                int time = Util.random(2000, 5000);
                Util.sleep(time);
                System.out.println(this + "finished service " + buyer);
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
}
