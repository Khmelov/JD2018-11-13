package by.it.markelov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1=new Scalar(0.12345);
        Var v2=new Scalar((Scalar) v1);
        Var v3=new Scalar("0.12345");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }
}
