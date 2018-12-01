package by.it.kruglenja.jd01_07;

/**
 * Created by user on 27.11.2018.
 */
public class Runner {
    public static void main(String[] args) {
        Var s1 = new Scalar(1.23);
        System.out.println(s1);
        Var v1 = new Vector("{1.0, 2.0, 3.0}");
        System.out.println(v1);
        Var v2 = new Vector("1, 2, 4");
        System.out.println(v1);
        Var m1 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
//        System.out.println(m1);
    }

}
