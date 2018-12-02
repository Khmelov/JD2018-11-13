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

//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder("{");
//        for (int i = 0; i < value.length; i++) {
//            str.append("{");
//            str.append(value[i][0]);
//            for (int j = 1; j < value[0].length; j++) {
//                str.append(", ");
//                str.append(String.valueOf(value[i][j]));
//            }
//            if (i == value.length - 1) str.append("}");
//            else str.append("}, ");
//        }
//        str.append("}");
//        return str.toString();
//    }

    @Override
    public String toString() {
        return " это какая-то матрица недоделанная ";
    }
}
