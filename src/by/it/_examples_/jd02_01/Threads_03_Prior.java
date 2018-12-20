package by.it._examples_.jd02_01;

class Threads_03_Prior {

    static class PriorThread extends Thread {
        PriorThread(String name) {
            super(name);
        }
        public void run() {
            for (int i = 0; i < 71; i++) {
                System.out.println(getName() + " " + i);
                try {
                    Thread.sleep(0); // попробовать sleep(0),sleep(10)
                } catch (InterruptedException e) {
                    System.err.print(e.toString());
                }
            }
        }
    }

    //основной поток
    public static void main(String[ ] args) {
        PriorThread max =  new PriorThread("Max");
        PriorThread norm = new PriorThread("       Norm");
        PriorThread min =  new PriorThread("               Min");
        min.setPriority(Thread.MIN_PRIORITY); // 1
        max.setPriority(Thread.MAX_PRIORITY); // 10
        norm.setPriority(Thread.NORM_PRIORITY); // 5
        min.start();
        norm.start();
        max.start();
    }


}
