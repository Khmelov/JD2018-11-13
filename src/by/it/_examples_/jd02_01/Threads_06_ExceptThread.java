package by.it._examples_.jd02_01;

public class Threads_06_ExceptThread extends Thread {
    static class ExceptThread extends Thread {
        public void run() {
            boolean flag = System.nanoTime()>0;
            if (flag) {
                throw new RuntimeException();
            }
            System.out.println("end of ExceptThread");
        }
    }

    public static void main(String[ ] args) throws InterruptedException {
        new ExceptThread().start();
        Thread.sleep(1000);
        System.out.println("end of main");
    }
}