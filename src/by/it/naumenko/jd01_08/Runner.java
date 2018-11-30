package by.it.naumenko.jd01_08;


public class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var v = new Vector(new double[]{1,2,3});
        print(s.add(s));
        print(s.sub(s));
        print(s.mul(s));
        print(s.div(s));

        print(v.add(v));
        print(v.sub(v));
        print(v.mul(v));
        print(v.div(v));
    }
}
