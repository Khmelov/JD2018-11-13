package by.it._examples_.jd01_07.matrixOk;
@SuppressWarnings("all")
/**
 * Класс для хранения матрицы
 */
public class Matrix {
    private int[ ][ ] a;
    public Matrix(int n, int m) throws MatrixException {
        // проверка на отрицательные значения размерности матрицы
        if ((n < 1) || (m < 1)) {
            throw new MatrixException();
        }
        a = new int[n][m];
    }
    public int getVerticalSize() {
        return a.length;
    }
    public int getHorizontalSize() {
        return a[0].length;
    }
    public int getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) { // проверка i и j
            return a[i][j];
        }
        else {throw new MatrixException();}
    }
    public void setElement(int i, int j, int value) throws MatrixException {
        if (checkRange(i, j)) { // проверка i и j
            a[i][j] = value;
        }
        else {throw new MatrixException();}
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x" + a[0].length + "\n");
        for (int [ ] row : a) {
            for (int value : row) {
                s.append(value + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    private boolean checkRange(int i, int j) {
        if ( i >= 0 && i < a.length && j >= 0 && j < a[0].length ) {
            return true;
        } else {
            return false;
        }
    }



    // проверка возможности выхода за пределы матрицы
    private boolean checkRangeBad(int i, int j) {
        if ( i < 0 || i > a.length - 1 || j < 0 || j > a[0].length - 1) {
            return false;
        } else {
            return true;
        }
    }
}
