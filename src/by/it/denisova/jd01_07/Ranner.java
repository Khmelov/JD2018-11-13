package by.it.denisova.jd01_07;

public class Ranner {
    public static void main(String[] args) {
        Var s1 = new Scalar(1.234);
        System.out.println(s1);
        Var s2 = new Scalar("22.234");
        System.out.println(s2);
        //double [] array = {1.0, 2.0, 4.0};

////


       Var s = new Scalar(3.0);
        System.out.println(((Scalar) s).add(s));
//
        Var vec1 = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(vec1);



     /* double [] mas = {1.0, 2.0, 4.0};
      Var vec1 = new Vector(mas);
       */




        String stringValue = "{1.0, 2.0, 4.0}";
        Var str1 = new Vector(stringValue);
        System.out.println(str1);


        ////c
        double[][] matrix1 = { { 1.0, 2.0 }, { 3.0, 4.0 } };


        String matrixString = " {{2.4, 43, 23},{6.4, 43, 223, -43}}";
        Matrix m1 = new Matrix(matrix1);
        System.out.println(m1);
        String string1 = "{{ 1.0, 2.0 }, { 3.0, 4.0 }}";
        Var m2 =  new Matrix(string1);
        System.out.println(m2);


    }
}
