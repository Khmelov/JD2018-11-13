package by.it.akhmelev.jd02_02;

class Dispatcher {

    private static final Object localMonitor = new Object();

    static final int K_SPEED = 100;

    private static int buyerCounter = 0;
    private static int buyerInShop = 0;
    private static final int buyerPlan = 100;

    static int getBuyerCounter() {
        return buyerCounter;
    }

    static void addBuyer() {
        synchronized (localMonitor) {
            int i=buyerCounter;
            int j=buyerInShop;
            Util.sleep(100);
            buyerCounter=++i;
            buyerInShop=++j;
        }
    }

    static void removeBuyer() {
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
