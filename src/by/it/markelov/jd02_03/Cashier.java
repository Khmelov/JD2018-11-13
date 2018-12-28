package by.it.markelov.jd02_03;

public class Cashier extends Thread {
    public Cashier(String s) {
        super(s);
    }

    Buyer buyer;

    public void serve() {
        try {
            Dispatcher.semaphoreCashier.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!Dispatcher.marketClosed()) {
            try {
                Thread.sleep(Util.random(2000, 5000) / Dispatcher.K_ACCELERATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buyer = Queue.buyerLinkedBlockingDeque.pollFirst();
            if (buyer == null) {
                System.out.println("Очередь пуста");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(this.getName() + " обслужил " + buyer.getName());
                Basket basketOfBuyer = buyer.basketOfBuyer;
                basketOfBuyer.basketContent();

              Dispatcher.semaphoreBuyer.release();
            }
        }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        serve();
    }

}
