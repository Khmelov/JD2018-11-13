package by.it.lobkova.jd02_01;


public class Good {
    public int id;
    public int value;
    public static int counter = 0;

    public Good() {
        counter++;
        this.id = counter;
        this.value = Util.random(100);
    }

}
