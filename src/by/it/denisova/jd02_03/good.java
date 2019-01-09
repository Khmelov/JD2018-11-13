package by.it.denisova.jd02_03;


public class good {
    public int id;
    public int value;
    public static int counter = 0;

    public good() {
        counter++;
        this.id = counter;
        this.value = Util.random(100);
    }

}