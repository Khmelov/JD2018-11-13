package by.it._examples_.jd02_03;

import java.util.concurrent.*;

public class Th3_03_CountDownLatch {

    private static CountDownLatch start=new CountDownLatch(5);
    private static CountDownLatch finish=new CountDownLatch(5);

    private static class Run implements Runnable{
        private String name;
        Run(String name) {this.name = name;} //конструктор Run

        @Override
        public void run() {
            System.out.println(name+" создан");
            try {
            start.countDown();
            start.await();  //ждем пока все соберутся
            System.out.println("--"+name+" стартовал");
            Thread.sleep(Math.round(Math.random()*1000));  //работа
            System.out.println("----"+name+" финишировал");
            finish.countDown();
            finish.await(); //ждем пока все соберутся
            System.out.println("------"+name+" завершился");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executors= Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executors.execute(new Run("Поток №"+i));
        }
        executors.shutdown();
    }


}
