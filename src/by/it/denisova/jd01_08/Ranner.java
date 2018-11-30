package by.it.denisova.jd01_08;

public class Ranner {
    public static void main(String[] args) {
        Var s1 = new Scalar(1.234);
        System.out.println(s1);
        Var s2 = new Scalar("22.234");
        System.out.println(s2);
        //double [] array = {1.0, 2.0, 4.0};
        Var vec1 = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(vec1);

        String stringValue = "{1.0, 2.0, 4.0}";
        Var str1 = new Vector(stringValue);
        System.out.println(str1);
        ////////// c







    }
}
