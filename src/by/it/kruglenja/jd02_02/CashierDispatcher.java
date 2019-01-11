package by.it.kruglenja.jd02_02;


import java.util.ArrayList;
import java.util.Collections;

public class CashierDispatcher {
    public static ArrayList<Boolean> cashierList = new ArrayList<Boolean>(Collections.nCopies(6, null));
    private static boolean openCas = true;
    private static boolean closedCas = false;

    private static int max = 0;
    private static int neededCass = 0;
    private static int openedCas = 0;

    static void runChasier() {
        int x = QueueBuyer.getBuyersInQueue();
        if (x > max) {
            max = x;
        }
        System.out.println("_-_-_-_-_- " + x + " покупателей в очереди, " + x + "- было максимум в очереди");
        if (x == 0) {
            Util.sleep(1);
        } else if (x > 0 && ((cashierList.get(1) == null) || (!cashierList.get(1)))) {
            cashierAdd(1);
            neededCass = 1;
        } else if (x > 5 && ((cashierList.get(2) == null) || (cashierList.get(2) != null && !cashierList.get(2)))) {
            cashierAdd(2);
            neededCass = 2;
        } else if (x > 10 && ((cashierList.get(3) == null) || (cashierList.get(3) != null && !cashierList.get(3)))) {
            cashierAdd(3);
            neededCass = 3;
        } else if (x > 15 && ((cashierList.get(4) == null) || (cashierList.get(4) != null && !cashierList.get(4)))) {
            cashierAdd(4);
            neededCass = 4;
        } else if (x > 25 && ((cashierList.get(5) == null) || (cashierList.get(5) != null && !cashierList.get(5)))) {
            cashierAdd(5);
            neededCass = 5;
        }

        for (int i = 1; i < cashierList.size(); i++) {
            if (cashierList.get(i) != null && cashierList.get(i))
                openedCas++;
        }
    }

    private static void cashierAdd(int cassNum) {
        if (cashierList.get(cassNum) == null) {
            Cashier cashier = new Cashier(cassNum);
            Thread thread = new Thread(cashier);
            thread.start();
            Market.threads.add(thread);
            cashierList.set(cassNum, openCas);
        }
        if (openedCas > neededCass) {
            while (openedCas != neededCass) {

                int randomcas = Util.random(1, 5);
                if (cashierList.get(randomcas) !=null && cashierList.get(randomcas)) {
                    try {
                        Market.threads.get(randomcas).wait();
                        cashierList.set(randomcas, closedCas);
                        System.out.println("''''''Кассир " + randomcas + " временно не работает'''''''");
                        openedCas--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (openedCas < neededCass) {
            while (openedCas != neededCass) {

                int randomcas = Util.random(1, 5);
                if (!cashierList.get(randomcas) && cashierList.get(randomcas)) {
                    Market.threads.get(randomcas).notify();
                    cashierList.set(randomcas, openCas);
                    System.out.println("'''''Касса " + randomcas + " заработала'''''");
                    openedCas++;
                }
            }
        }
        System.out.println("+=+=+=+=+ " + openedCas + " касс открыто");
    }
}
