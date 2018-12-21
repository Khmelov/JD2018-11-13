package by.it.kruglenja.jd02_02;

/**
 * Created by user on 20.12.2018.
 */
public class Cassier implements Runnable{
    private String name;

    public Cassier(int number) {
        name = "Cassier " + number +": ";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void run() {
        while (!Dispathcer.close()){
            Util.sleep(100);
        }
    }


}
