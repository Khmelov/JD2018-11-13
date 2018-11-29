package by.it.akhmelev.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Scalar s1=new Scalar(1.234);
        System.out.println(s1);
        Var s2=new Scalar("22.234");
        System.out.println(s2);
        Var s3=new Scalar(s1);
        System.out.println(s3);

        Var v=new Vector(new double[]{1,2,3,4});
        System.out.println(v);
    }
}
