package by.it.zhivov.jd01_08;

public class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var s = new Scalar(3.0);
        Var v = new Vector(new double[]{1, 2, 3}); // закомментируйте вектор и/или
        Var m = new Matrix("{ {1,2,3},{4,5,6},{7,8,9} } "); // матрицу, если вы их не реализовали
        print(s.add(s));
        print(s.sub(s));
        print(s.mul(s));
        print(s.div(s));
        print(v.add(v));
        print(v.sub(v));
        print(v.mul(v));
        print(v.div(v));
        print(m.add(m));
        print(m.sub(m));
        print(m.mul(m));
        print(m.mul(v));
    }
}