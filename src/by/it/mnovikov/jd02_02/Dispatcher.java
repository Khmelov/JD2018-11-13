package by.it.mnovikov.jd02_02;

class Dispatcher {

    private static final Object localMonitor = new Object();

    static final int K_SPEED = 10;

    private static int buyerCounter = 0;
    private static int buyerInShop = 0;
    private static final int buyerPlan = 100;

    static void addBuyer() {
        synchronized (localMonitor) {
//            int j = buyerCounter;
//            int i = buyerInShop;
            Util.sleep(100);
            buyerCounter = ++buyerCounter;
            buyerInShop = ++buyerInShop;
        }
    }

    static int getBuyerCounter() {
        return buyerCounter;
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
