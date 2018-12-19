package by.it._examples_.jd02_02;

public class Th2_01_not_syn {

    //переменная баланса
    private static Integer balance=0;

    //это касса. Просто добавляет в баланс единицу
    static class Cashier extends Thread {
        //создадим видимость расчета
        int calc(int in) {
            int j=0; for (int i = 0; i < 666; i++) {j=j+(int)((Math.sqrt(i)));}
            return in;
        }
        @Override
        public  void run() {
            //не будет работать. Одновременный доступ.
                balance += (calc(1));
        }
    }
    //создадим 4444 касс. Каждая добавит по 1. Сколько всего будет?
    public static void main(String[ ] args) throws InterruptedException {
        //Считаем сколько было потоков
        int thCount=Thread.activeCount();

        for (int i = 0; i < 4444; i++) {
            new Cashier().start();
         }
        //пока потоков больше чем было в начале просто ждем
        while (Thread.activeCount()>thCount) {Thread.sleep(100);}
        System.out.print("Итого:"+balance);
     }
}
