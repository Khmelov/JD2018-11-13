package by.it.lobkova.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String value){
        value = value.replaceAll("[{|}]{2,}", "");
        String[] valueString = value.split("[}][\\s]?,[\\s]?[{]");
        this.value = new double[valueString.length][];
        for (int i = 0; i < valueString.length; i++) {
            String[] valueStringElement = valueString[i].trim().split(",");
            double[] resultArr = new double[valueStringElement.length];
            for (int j = 0; j < valueStringElement.length; j++) {
                resultArr[j] = Double.parseDouble(valueStringElement[j]);
                this.value[i] = resultArr;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String dilimiter = "";
        for (int i = 0; i < value.length; i++) {
            if (i>=1) dilimiter = "}, {";
            for (int j = 0; j < value.length; j++) {
                sb.append(dilimiter).append(value[i][j]);
                dilimiter = ", ";
            }
        }
        sb.append("}}");
        return sb.toString();
    }

/*public Matrix(double[][] value) {
        super(value);
    }

    public Matrix(Matrix matrix) {
        super(matrix.getValue());
    }

//    public Matrix(String strScalar) {
//        super(Double.valueOf(strScalar));
//    }

    @Override
    public String toString() {
        return Arrays.toString((double[][]) getValue());
    }*/
}
