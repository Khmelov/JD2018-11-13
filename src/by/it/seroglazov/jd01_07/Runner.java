package by.it.seroglazov.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Scalar s1 = new Scalar(2.45);
        System.out.println(s1);
        Var s2 = new Scalar("22.981");
        System.out.println(s2);
        Var s3 = new Scalar(s1);
        System.out.println(s3);
    }
}
