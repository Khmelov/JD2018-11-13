package by.it.denisova.jd01_09;

public class Matrix extends Var {

    double [][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = new double[value.length][];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

    public Matrix(Matrix otherMatrix){
        this.value = new double[otherMatrix.value.length][];
        System.arraycopy(otherMatrix.value, 0, this.value, 0, this.value.length);
    }

    Matrix(String value){
        value = value.replaceAll("[{|}]{2,}", "");
        String[] strValue = value.split("[}][\\s]?,[\\s]?[{]");

        this.value = new double[strValue.length][];
        for (int i = 0; i < strValue.length; i++) {

            String[] valueStrNumb = strValue[i].trim().split(",");
            double[] tempArr = new double[valueStrNumb.length];

            for (int j = 0; j < valueStrNumb.length; j++) {
                tempArr[j] = Double.parseDouble(valueStrNumb[j]);
                this.value[i] = tempArr;
            }
        }
    }

    private double[][] getArrayCopy(double[][] arr) {
        double[][] result = new double[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }

    @Override
    public Var add(Var other) {
        if(other instanceof  Scalar) {
            double [][] res = getArrayCopy(value);

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Matrix){
            double[][] mas1 = getArrayCopy(value);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    mas1[i][j] += ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(mas1);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] matrix = getArrayCopy(value);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Vector) {
            double[][] matrix = getArrayCopy(value);
            double[] resultVector = new double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                double sum = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    sum += matrix[i][j] * ((Vector) other).getValue()[j];
                }
                resultVector[i] = sum;
            }
            return new Vector(resultVector);
        }
        else if (other instanceof Matrix) {
            double[][] matrix = getArrayCopy(value);
            double[][] res = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < ((Matrix) other).getValue()[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).getValue().length; k++) {
                        res[i][j] += matrix[i][k] * ((Matrix) other).getValue()[k][j];
                    }
                }
            }
            return new Matrix(res);
        }

        return super.mul(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res = getArrayCopy(value);

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            double[][] mas1 = getArrayCopy(value);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    mas1[i][j] -= ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(mas1);
        }
        return super.sub(other);
    }


    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (double[] aValue : value) {
            for (int j = 0; j < aValue.length; j++) {
                sb.append(delimiter).append(aValue[j]);
                delimiter = ", ";
            }
            sb.append("}");
            delimiter = ", {";
        }
        sb.append("}");

        return sb.toString();
    }
}
