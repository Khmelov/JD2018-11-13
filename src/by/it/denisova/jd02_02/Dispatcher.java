package by.it.denisova.jd02_02;

public class Dispatcher {
    private static final Object localMonitor = new Object();

    static final int K_SPEED = 100;

    public static int getCashierCount() {
        return cashierCount;
    }

    public static void setCashierCount(int cashierCount) {
        Dispatcher.cashierCount = cashierCount;
    }

    private static int cashierCount = 0;
    private static int buyerCounter = 0;
    private static int buyerInShop = 0;
    private static final int buyerPlan = 100;

    static int getBuyerCounter() {
        return buyerCounter;
    }

    public static void addBuyer() {
        synchronized (localMonitor) {
            int i = buyerCounter;
            int j = buyerInShop;
            Util.sleep(100);
            buyerCounter = ++i;
            buyerInShop = ++j;
        }
    }

    public static void removeBuyer() {
        synchronized (localMonitor) {
            buyerInShop--;
        }
    }

    static boolean marketClosed() {
        synchronized (localMonitor) {
            return buyerCounter >= buyerPlan && buyerInShop == 0;
        }
    }

    static boolean marketOpened() {
        synchronized (localMonitor) {
            return buyerCounter < buyerPlan;
        }
    }
}

