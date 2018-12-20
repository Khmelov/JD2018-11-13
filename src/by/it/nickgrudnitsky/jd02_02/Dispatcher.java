package by.it.nickgrudnitsky.jd02_02;


class Dispatcher {

    static int K_SPEED = 1000;

    static int buyerCounter = 0;

    final static int buyerPlane = 100;

    static boolean marketClose() {
        return buyerCounter >= buyerPlane;
    }

}
