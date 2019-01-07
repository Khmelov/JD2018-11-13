package by.it.kruglenja.jd02_02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CashierDispatcher {
    public static ArrayList<Boolean> cashierList = new ArrayList<Boolean>(Collections.nCopies(6, false));
    private static boolean openCas = true;
    static boolean closedCas = false;


    static void runChasier() {
        int x = QueueBuyer.getBuyersInQueue();
        System.out.println("//////////// " + x + " покупателей в очереди");
        System.out.println(cashierList.toString());
        if (x == 0) {
            Util.sleep(1);
        } else if (x > 0 && (cashierList.get(1) == null) || (cashierList.get(1) != null && !cashierList.get(1))) {
            cashierAdd(1);
        } else if (x > 5 && (cashierList.get(2) == null) || (cashierList.get(2) != null && !cashierList.get(2))) {
            cashierAdd(2);
        } else if (x > 10 && (cashierList.get(3) == null) || (cashierList.get(3) != null && !cashierList.get(3))) {
            cashierAdd(3);
        } else if (x > 15 && (cashierList.get(4) == null) || (cashierList.get(4) != null && !cashierList.get(4))) {
            cashierAdd(4);
        } else if (x > 25 && (cashierList.get(5) == null) || (cashierList.get(5) != null && !cashierList.get(5))) {
            cashierAdd(5);
        }
    }

    private static void cashierAdd(int cassNum) {
        Cashier cashier = new Cashier(cassNum);
        Thread thread = new Thread(cashier);
        thread.start();
        Market.threads.add(thread);
        cashierList.set(cassNum, openCas);
    }
}
