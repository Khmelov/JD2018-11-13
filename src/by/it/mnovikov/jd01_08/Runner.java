package by.it.mnovikov.jd01_08;

/**
 * Created by user on 27.11.2018.
 */
public class Runner {
    public static void main(String[] args) {

        Var s = new Scalar(1.234);
        System.out.println(s);

        Var v = new Vector(new double[]{1,2,3,4});
        System.out.println(v);


    }
}
