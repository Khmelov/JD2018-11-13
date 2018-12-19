package by.it._examples_.jd02_01;

public class Threads_04_Join {
    static class JoinThread extends Thread {

        JoinThread (String name) {
            super(name);
        }

        public void run() {
            String nameT = getName();
            long timeout = 0;
            System.out.println("Старт потока " + nameT);
            try {
                switch (nameT) {
                    case "First":
                        timeout = 5_000;
                        break;
                    case "Second":
                        timeout = 4_000;
                }
                Thread.sleep(timeout);
                System.out.println("завершение потока " + nameT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //============================================================
    public static void main(String[ ] args) {
        System.out.println("Старт потока main");
        JoinThread t1 = new JoinThread("First");
        JoinThread t2 = new JoinThread("Second");
        t1.start();
        t2.start();
        try {
            t2.join(); // поток main остановлен до окончания работы потока t1
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()); // имя текущего потока
    }

}
