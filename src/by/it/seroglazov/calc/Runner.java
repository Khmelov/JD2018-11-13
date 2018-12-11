package by.it.seroglazov.calc;

public class Runner {
    public static void main(String[] args) {
        Var s1 = new Scalar(3);
        Var s2 = new Scalar(7);
        Var v1 = new Vector("{1, 2, 4}");
        Var v2 = new Vector("{2, 2, 2}");
        Var m1 = new Matrix("{{7, 7, 7,},{6, 4, 6},{2, 1, 2}}");
        Var m2 = new Matrix("{{7, 7, 7,},{6, 4, 6},{2, 1, 2}}");
        System.out.println(s1.add(s2));
        System.out.println(s1.mul(s2));
        System.out.println(m1.mul(m2));
    }

}
