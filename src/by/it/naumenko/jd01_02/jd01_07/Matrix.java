package by.it.naumenko.jd01_02.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        //String scobkaBegin="{";

        for (int i = 0; i < value.length; i++) {
            String del = "";
            for (int j = 0; j < value[i].length; j++) {
                stringBuilder.append(del).append(value[i][j]);
                del = ", ";
            }
            if (i != value.length - 1) {
                del = "},{";
                stringBuilder.append(del);
            } else
                stringBuilder.append("}}");
        }

        return stringBuilder.toString();
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix){
        value=matrix.value;
    }
}
