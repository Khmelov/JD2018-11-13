package by.it.naumenko.Jd02_02;

public class Dispecher {

    private static final Object localMOnitor = new Object();
    static final int buyerPlan = 3;
    static int buyerInShop = 0;
    static int buyerCounter = 0;


    static boolean shopCloosed() {
        synchronized (localMOnitor) {
            return buyerCounter >= buyerPlan && buyerInShop==0;
        }
    }

    static int getBuyerCounter() {
        return buyerCounter;
    }

    static boolean shopOpened() {
        synchronized (localMOnitor) {
            //return !shopCloosed();
            return buyerCounter <=buyerPlan;
        }
    }

    static void  addBuyer() {
        synchronized (localMOnitor) {
            buyerCounter++;
            buyerInShop++;
        }
    }

    static void  removeBuyer() {
        synchronized (localMOnitor) {
            buyerInShop--;
        }
    }
}

