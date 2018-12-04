package by.it.lobkova.jd01_08;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            double[][] mas1 = Arrays.copyOf(value, value.length);
            double[][] mas2 = Arrays.copyOf(((Matrix) other).value, ((Matrix) other).value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    mas1[i][j] += mas2[i][j];
                }
            }
            return new Matrix(mas1);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
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
}