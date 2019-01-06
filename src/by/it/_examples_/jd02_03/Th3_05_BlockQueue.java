package by.it._examples_.jd02_03;

import java.util.concurrent.*;

public class Th3_05_BlockQueue {
        public static void main(String[] args) {
            //указание что элементов в очереди будет только два
            final BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
            //поток на добавление (Java 7)
            new Thread() {
                public void run() {
                    for (int i = 1; i < 4; i++) {
                        try {
                            queue.put("Java" + i); // добавление 3-х элементов
                            System.out.println("Элемент " + i + " добавлен ");
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            //поток на извлечение (Java 8+)
            new Thread(() -> {
                try {
                    Thread.sleep(1_000);
                    // извлечение одного
                    System.out.println("Элемент " + queue.take() + " извлечен");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
}
