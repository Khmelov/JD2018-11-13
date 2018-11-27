package by.it._examples_.jd01_07.matrixOk;
@SuppressWarnings("all")
public class Runner {
    public static void main(String[ ] args) {
        try {
            Matrix p = new Matrix(2, 3);
            MatrixCreator.fillRandomized(p, 2, 8);
            System.out.println("Matrix first is: " + p);
            Matrix q = new Matrix(3, 4);
            MatrixCreator.fillRandomized(q, 2, 7);
            System.out.println("Matrix second is: " + q);
            Multiplicator mult = new Multiplicator();
            System.out.println("Matrices product is " + mult.multiply(p, q));
        } catch (MatrixException ex) {
            System.err.println("Error of creating matrix " + ex);
        }
    }
}
