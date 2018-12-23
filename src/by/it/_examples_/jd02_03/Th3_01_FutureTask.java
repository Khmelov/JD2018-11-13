package by.it._examples_.jd02_03;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Th3_01_FutureTask {

    public static void main(String[] args) {
        //в Java 8+ можно использовать лямбды
        //Callable<Integer> callTh = () -> { sleep(500); return 500; };
        Callable<Integer> callTh = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                sleep(500);
                return 500;
            }
        };
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        FutureTask<Integer> task = new FutureTask<>(callTh);
        executorService.submit(task);
        try {
            System.out.print("Result:");
            System.out.println(task.get()+" Ok");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


}
