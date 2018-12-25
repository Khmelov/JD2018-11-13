package by.it._examples_.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Th3_00_Atomics extends Thread {

    private enum State {
        NEW, INITIALIZING, INITIALIZED
    }

    private static final AtomicInteger atomicCount = new AtomicInteger(0);

    //целостная ссылка на состояние
    private static final AtomicReference<State> init = new AtomicReference<>(State.NEW);

    public void run() {
        System.out.println("Step 0:" + init.get());
        if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Already initialize");
        }
        System.out.println("Step 1:" + init.get());
        State prev = init.getAndSet(State.INITIALIZED);
        System.out.println("Step 2:" + init.get() + " prev:" + prev);
        atomicCount.getAndAdd(1);
    }

    public static void main(String[] args) throws InterruptedException {
        //чтобы не потерять потоки
        List<Thread> ths = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ths.add(new Th3_00_Atomics());
            ths.get(i).start();
        }
        for (Thread th : ths) th.join();
        System.out.println("atomicCount=" + atomicCount);
    }
}
