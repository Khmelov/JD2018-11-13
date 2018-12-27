package by.it.markelov.jd02_02;

public class Dispatcher {
    public static final int K_ACCELERATION=1000;

    public static int buyersCreated =0;

    public static int buyersInMarketNow =0;

    private static final int buyerPlan = 100;

    private static final Object monitor = new Object();

    static void addBuyer() {
        synchronized (monitor) {
            int i=buyersCreated++;
            int j=buyersInMarketNow++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buyersCreated=++i;
            buyersInMarketNow=++j;

        }
    }
    static void removeBuyer() {
        synchronized (monitor) {
            buyersInMarketNow--;
        }
    }

    static boolean marketClosed() {
        synchronized (monitor) {
            return buyersCreated >= buyerPlan && buyersInMarketNow == 0;
        }
    }
}
