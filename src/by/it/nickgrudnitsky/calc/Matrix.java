package by.it.nickgrudnitsky.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

     Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value.length);
        }
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        Pattern pattern1 = Pattern.compile("[0-9]+(, ?[0-9])+");
        Matcher matcher1 = pattern1.matcher(strMatrix);
        int i1 = 0;
        int rowsCount = 0;
        int columnsCount = 0;
        while (matcher1.find()) {
            rowsCount++;
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(matcher1.group());
            while (matcher.find()) {
                columnsCount++;
            }
        }
        matcher1.reset();
        this.value = new double[rowsCount][columnsCount];

        while (matcher1.find()) {
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(matcher1.group());
            double[] array = new double[0];
            int i = 0;
            while (matcher.find()) {
                int last = array.length;
                array = Arrays.copyOf(array, last + 1);
                array[i] = Double.parseDouble(matcher.group());
                i++;
            }
            this.value[i1] = Arrays.copyOf(array, array.length);
            i1++;
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] rezult = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                rezult[i] = Arrays.copyOf(value[i], value.length);
            }
            for (int i = 0; i < value.length; i++) {
                for (int i1 = 0; i1 < value[0].length; i1++) {
                    rezult[i][i1] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(rezult);
        } else {
            if (other instanceof Matrix && value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] rezult = new double[value.length][value[0].length];
                for (int i = 0; i < rezult.length; i++) {
                    System.arraycopy(value[i], 0, rezult[i], 0, rezult[0].length);
                }
                for (int i = 0; i < rezult.length; i++) {
                    for (int i1 = 0; i1 < rezult[0].length; i1++) {
                        rezult[i][i1] += ((Matrix) other).value[i][i1];
                    }
                }
                return new Matrix(rezult);
            } else {
                return super.add(other);
            }
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] rezult = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                rezult[i] = Arrays.copyOf(value[i], value.length);
            }
            for (int i = 0; i < rezult.length; i++) {
                for (int i1 = 0; i1 < rezult[0].length; i1++) {
                    rezult[i][i1] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(rezult);
        } else {
            if (other instanceof Matrix && value.length == ((Matrix) other).value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] rezult = new double[value.length][value[0].length];
                for (int i = 0; i < rezult.length; i++) {
                    System.arraycopy(value[i], 0, rezult[i], 0, rezult[0].length);
                }
                for (int i = 0; i < rezult.length; i++) {
                    for (int i1 = 0; i1 < rezult[0].length; i1++) {
                        rezult[i][i1] -= ((Matrix) other).value[i][i1];
                    }
                }
                return new Matrix(rezult);
            } else {
                return super.sub(other);
            }
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] rezult = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                rezult[i] = Arrays.copyOf(value[i], value.length);
            }
            for (int i = 0; i < rezult.length; i++) {
                for (int i1 = 0; i1 < rezult[0].length; i1++) {
                    rezult[i][i1] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(rezult);
        } else {
            if (other instanceof Vector && value[0].length == ((Vector) other).getValue().length) {
                double[][] matrix = new double[value.length][value[0].length];
                double[] rezult = new double[value[0].length];
                for (int i = 0; i < value.length; i++) {
                    matrix[i] = Arrays.copyOf(value[i], value.length);
                }
                for (int i = 0; i < matrix[0].length; i++) {
                    for (int i1 = 0; i1 < rezult.length; i1++) {
                        rezult[i] += matrix[i][i1] * ((Vector) other).getValue()[i1];
                    }
                }
                return new Vector(rezult);
            } else {
                if (other instanceof Matrix && value[0].length == ((Matrix) other).value.length) {
                    double[][] rezult = new double[value.length][((Matrix) other).value[0].length];
                    double[][] matrix = new double[value.length][value[0].length];
                    for (int i = 0; i < value.length; i++) {
                        matrix[i] = Arrays.copyOf(value[i], value.length);
                    }
                    for (int i = 0; i < value.length; i++) {
                        for (int j = 0; j < value[0].length; j++) {
                            for (int k = 0; k < ((Matrix) other).value.length; k++) {
                                rezult[i][j] += matrix[i][k] * ((Matrix) other).value[k][j];
                            }
                        }
                    }
                    return new Matrix(rezult);
                }
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] rezult = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                rezult[i] = Arrays.copyOf(value[i], value.length);
            }
            for (int i = 0; i < rezult.length; i++) {
                for (int i1 = 0; i1 < rezult[0].length; i1++) {
                    rezult[i][i1] += rezult[i][i1] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(rezult);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i1 = 0; i1 < value.length; i1++) {
            stringBuilder.append("{");
            for (int i = 0; i < value.length; i++) {
                stringBuilder.append(value[i1][i]);
                if (i != value.length - 1) {
                    stringBuilder.append(", ");
                } else {
                    if (i1 != value.length - 1) {
                        stringBuilder.append("}, ");
                    } else {
                        break;
                    }
                }
            }
        }
        stringBuilder.append("}}");
        return new String(stringBuilder);
    }
}
