package by.it.berdnik.jd01_09;

class Matrix extends Var {

    private double[][] value;

    public Matrix(String strMatrix) {
        super();
    }

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value.length);
        }
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }


    @Override
    public String toString() {
        return " это какая-то матрица недоделанная ";
    }
}
