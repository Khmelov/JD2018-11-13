package by.it.lobkova.calc;

public class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String value) {
        value = value.replaceAll("[{|}]{2,}", "");
        String[] valueString = value.split("[}][\\s]*[,]*[\\s]*[{]+");
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

    private double[][] getArrayCopy(double[][] arr) {
        double[][] result = new double[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            result[i] = new double[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = getArrayCopy(value);

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] mas1 = getArrayCopy(value);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    mas1[i][j] += ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(mas1);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = getArrayCopy(value);

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] mas1 = getArrayCopy(value);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    mas1[i][j] -= ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(mas1);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = getArrayCopy(value);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        } else if (other instanceof Vector) {
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
        } else if (other instanceof Matrix) {
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
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = getArrayCopy(value);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] /= ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        } else throw new CalcException("Деление " + this + " и " + other + " невозможно");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String dilimiter = "";
        for (int i = 0; i < value.length; i++) {
            if (i >= 1) dilimiter = "}, {";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(dilimiter).append(value[i][j]);
                dilimiter = ", ";
            }
        }
        sb.append("}}");
        return sb.toString();
    }
}
