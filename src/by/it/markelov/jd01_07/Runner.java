package by.it.markelov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar doubleScalar=new Scalar(0.12345);
        Scalar objectScalar=new Scalar(doubleScalar);
        Scalar stringScalar=new Scalar("0.12345");

        System.out.println(doubleScalar.toString());
        System.out.println(objectScalar.toString());
        System.out.println(stringScalar.toString());
    }
}
