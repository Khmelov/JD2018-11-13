package by.it.zakharenko.jd02_03;


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
