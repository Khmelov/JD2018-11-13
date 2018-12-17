package by.it._examples_.jd02_01;

class Threads_05_Daemon {
    static class SomeThread extends Thread {
        public void run() {
            try {
                if (isDaemon()) {
                    System.out.println("старт потока-демона");
                    Thread.sleep(1); // заменить параметр на 1
                } else {
                    System.out.println("старт обычного потока");
                }
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            } finally {
                if (!isDaemon()) {
                    System.out.println("завершение обычного потока");
                } else {
                    System.out.println("завершение потока-демона");
                }
            }
        }
    }

    public static void main(String[ ] args) {
        SomeThread usual = new SomeThread();
        SomeThread daemon = new SomeThread();
        daemon.setDaemon(true);
        daemon.start();
        usual.start();
        System.out.println("последний оператор main");
    }

}
