package by.it.lobkova.jd02_03;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

public class Market {
    static List<Basket> basketList = new ArrayList<>();
    static List<Good> goodList = new ArrayList<>();

    public static void main(String[] args) {
        initialSetup();
        List<Thread> threads = new ArrayList<>();
        System.out.println("Market is open");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Cashier(1));
        executorService.execute(new Cashier(2));
        executorService.shutdown();

        for (; ;) {
            if (!Dispatcher.marketOpened()) break;

            int buyerCount = Util.random(2);
            for (int i = 0; i < buyerCount; i++) {
                Buyer buyer = new Buyer(Dispatcher.getBuyerCounter());
                threads.add(buyer);
                buyer.start();
            }
            Util.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (!executorService.isTerminated())
            Util.sleep(1);
        System.out.println("Market closed");
    }

    private static void initialSetup() {
        for (int i = 0; i < 100; i++) {
            goodList.add(new Good());
        }

        for (int i = 0; i < 3; i++) {
            basketList.add(new Basket());
        }
    }

    public static void giveSomeBaskets() {
        System.out.println("----------- added 2 baskets ------------");
        for (int counter = 0; counter < 2; counter++) {
            basketList.add(new Basket());
        }
    }
}
