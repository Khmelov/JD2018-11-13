package by.it.mnovikov.jd01_01;

/**
 * Created by user on 13.11.2018.
 */
public class Hello {
    private String slogan = "Hello World!!";

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getSlogan() {
        return slogan;
    }

    void printSlogan() {
        System.out.println(slogan);
    }
}
