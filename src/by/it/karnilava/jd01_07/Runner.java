package by.it.karnilava.jd01_07;

public class Runner {

    public static void main(String[] args) {
        AbstractVar v1= new Scalar(3.1415);
        AbstractVar v2 = new Vector(new double[]{1,2,3});
        AbstractVar v3 = new Vector("{1.0,2.0,4.0");
        AbstractVar v4 = new Matrix(new double[][]{ { 1.0, 2.0 }, { 3.0, 4.0 } });
        AbstractVar v5 = new Matrix("{{1,2},{3,4}}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
    }

}
