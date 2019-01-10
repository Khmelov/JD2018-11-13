package by.it.kruglenja.jd02_03;

public class Dispathcer {
    final static int K_SPEED = 200;
    private static int buyerCounter = 0;
    private static final int bayersPlan = 100;
    public static int bayersInShop = 0;

    private static final Object localMonitor = new Object();

    static int getBuyerCounter() {
        return buyerCounter;
    }

    static void addBayer() {
        synchronized (localMonitor) {
            int i = buyerCounter;
            int j = bayersInShop;
            Util.sleep(100);
            buyerCounter = ++i;
            bayersInShop = ++j;
        }
    }

    static void removeBuyer() {
        synchronized (localMonitor) {
            bayersInShop--;
        }
    }

    static boolean marketClosed() {
        synchronized (localMonitor) {
            return buyerCounter >= bayersPlan && bayersInShop == 0;
        }
    }

    static boolean marketOpen() {
            synchronized (localMonitor) {
            return buyerCounter < bayersPlan;
        }
    }
}
