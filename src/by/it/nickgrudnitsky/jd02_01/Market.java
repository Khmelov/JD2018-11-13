package by.it.nickgrudnitsky.jd02_01;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market is opened.");
        for (int second = 0; second < 121; second++) {
            int time = second;
            if (second > 59) time = second - 60;
            if (second == 0) {
                for (int j = 0; j < 10; j++) {
                    Buyer buyer = new Buyer(Dispatcher.buyerCount++);
                    buyer.start();
                }
                Util.sleep(1000);
            }
            int buyerCount = Util.random(2);
            for (int j = 0; j < buyerCount; j++) {
                Buyer buyer = new Buyer(Dispatcher.buyerCount++);
                buyer.start();
            }
            Util.sleep(1000);
            if (time <= 30 && Buyer.buyers.size() < time + 10) {
                while (Buyer.buyers.size() < time + 10) {
                    buyerCount = Util.random(2);
                    for (int j = 0; j < buyerCount; j++) {
                        Buyer buyer = new Buyer(Dispatcher.buyerCount++);
                        buyer.start();
                    }
                }
            }
            if (time > 30 && Buyer.buyers.size() <= 40 + 30 - time) {
                while (Buyer.buyers.size() < 40 + 30 - time) {
                    buyerCount = Util.random(2);
                    for (int j = 0; j < buyerCount; j++) {
                        Buyer buyer = new Buyer(Dispatcher.buyerCount++);
                        buyer.start();
                    }
                }
            }
            if (second % 10 == 0) System.out.println("Секунда " + second + " " + Buyer.buyers.size());
        }
        for (Buyer buyer : Buyer.buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market is closed.");
    }
}
