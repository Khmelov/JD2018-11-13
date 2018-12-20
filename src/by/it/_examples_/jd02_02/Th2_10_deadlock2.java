package by.it._examples_.jd02_02;

public class Th2_10_deadlock2 {
    //класс с кошельком и балансом
    private static class Wallet { int money=100; }

    //класс-поток для перевода денег
    private static class MoneySender extends Thread {
        final Wallet from; final Wallet to; int amount;

        //конструктор принимает параметры платежа
        MoneySender(Wallet from, Wallet to, int amount) {
            this.from=from; this.to=to; this.amount=amount;
            start();
        }

        //какие-то расчеты перед платежом
        void process() {
            try {
                sleep(1);
                System.out.println("Готов платеж на "+amount);}
            catch (Exception e) { e.printStackTrace(); }
        }

        @Override
        public void run() {
            synchronized (from) {
                process(); //делаем расчеты, готовим перевод
                synchronized (to) {
                    from.money-=amount; //в полностью засинхронизированном блоке
                    to.money+=amount;   //"потокобезопасно" делаем перевод
                    System.out.println("Ок, переведено "+amount);
                }
            }
        }
    }

    public static void main(String[] args) {
        Wallet w1=new Wallet();
        Wallet w2=new Wallet();
        Wallet w3=new Wallet();
        System.out.println("Начинаем перевод...");
        new MoneySender(w1,w2,10);
        new MoneySender(w2,w1,15);
        new MoneySender(w1,w3,20);
    }
}
