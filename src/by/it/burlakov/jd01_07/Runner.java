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
<<<<<<< b36ad934598f84161d78637e307b7a61dbcf9efd
        ////////////////////////////////////////////////////

        double[] vectorArr1 = {1, 2, 3, 6};
        String vectorString = "{  2.4,    43,   23,   43  }";

        Vector v1 = new Vector(vectorArr1);
        Vector v2 = new Vector(v1);
        Vector v3 = new Vector(vectorString);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        /////////////////////////////////////////////////////////

        double[][] matrix1 = {
                {3, -1, 2},
                {4, 2, 0},
                {6, 1}
        };

        String matrixString = " {{2.4, 43, 23},{6.4, 43, 223, -43}}";

        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(m1);
        Matrix m3 = new Matrix(matrixString);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

=======

        double[] vectorArr = {1, 2, 3, 6};
        Vector v1 = new Vector(vectorArr);
        v1.toString();
>>>>>>> TaskA
    }
}
