package by.it.kruglenja.jd02_02;

public class Dispathcer {
    final static int K_SPEED = 100;
    static int buyerCounter = 0;
    static final int buyerPlan = 100;
    static boolean close(){
        return buyerCounter >= buyerPlan;
    }

}
