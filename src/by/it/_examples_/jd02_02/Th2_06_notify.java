package by.it._examples_.jd02_02;

public class Th2_06_notify extends Thread {

    //переменная баланса
    private final static Integer monitorForBalance = 0;
    private static Integer balance = 0;

    private Th2_06_notify(String name) {
        super(name);
        start();
    }

    @Override
    public void run() {
        synchronized (monitorForBalance) {
            try {
                System.out.println(getName() + " увеличил баланс до " + (++balance));
                monitorForBalance.wait();
                System.out.println(getName() + " снова увеличил баланс до " + (++balance));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (Integer i = 0; i < 4; i++) {
            new Th2_06_notify("Поток "+i);
        }
        sleep(1000);
        System.out.println("Первая пауза завершена");
        synchronized (monitorForBalance) {
            monitorForBalance.notify();
        }
        sleep(1000);
        System.out.println("Вторая пауза завершена");
        synchronized (monitorForBalance) {
            monitorForBalance.notifyAll();
        }
    }
}
