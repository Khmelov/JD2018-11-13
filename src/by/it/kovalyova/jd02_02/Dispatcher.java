package by.it.kovalyova.jd02_02;

class Dispatcher {
    static final int K_SPEED = 100;
    static int buyerCounter = 0;
    static  final int buyerPlan=100;

    static boolean marketClosed(){
        return buyerCounter>=buyerPlan;
    }
}
