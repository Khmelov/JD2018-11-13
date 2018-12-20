package by.it.nickgrudnitsky.jd02_02;

public class Cashier implements Runnable{

    private String name;

    public Cashier (int number){
        name = "Cashier #" + number + ": ";
    }

    @Override
    public void run() {
        while (Dispatcher.marketClose()){
            Util.sleep(100);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
