package by.it._examples_.jd02_02;

public class Th2_11_interrupt extends Thread{
    @Override
    public void run() {
        try {
            int i = 0;
            while(i<10){   //выполним 10 циклов с паузой в 0.5 секунды
                sleep(500);
                System.out.printf("Loop №%d\n",++i);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupt");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Th2_11_interrupt th=new Th2_11_interrupt();
        th.start();
        sleep(3000);
        th.interrupt(); //прерываем поток после 3 секунд
    }
}
