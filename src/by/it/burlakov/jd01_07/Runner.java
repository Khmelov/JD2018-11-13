package by.it.burlakov.jd01_07;

/**
 * Created by user on 27.11.2018.
 */
public class Runner {
    public static void main(String[] args) {
        Scalar s1 = new Scalar("2.323");
        Scalar s2 = new Scalar(12.323);
        Scalar s3 = new Scalar(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        double[] vectorArr = {1, 2, 3, 6};
        Vector v1 = new Vector(vectorArr);
        v1.toString();
    }
}
