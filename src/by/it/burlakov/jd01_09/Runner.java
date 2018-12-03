package by.it.burlakov.jd01_09;

/**
 * Created by user on 01.12.2018.
 */
public class Runner {
    public static void main(String[] args) {
        Parser p = new Parser();
        Printer printer = new Printer();
        Var res = p.calc("3.8+26.2");
        System.out.println(res);
    }
}
