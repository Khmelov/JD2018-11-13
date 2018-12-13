package by.it.evenchik.jd01_08;

import java.util.Arrays;

class Matrix extends by.it.evenchik.jd01_08.Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value.length);
        }
    }


    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(matrix.value[i], 0, this.value[i], 0, value.length);
        }
    }

    @Override
    public by.it.evenchik.jd01_08.Var add(by.it.evenchik.jd01_08.Var other) {
        if (other instanceof Scalar) {
            double[][] addSc = Arrays.copyOf(value, value.length);
            for (int i = 0; i < addSc.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    addSc[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(addSc);
        } else if (other instanceof Matrix) {
            double[][] addMat = new double[value.length][value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    addMat[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(addMat);
        } else
            return other.add(this);
    }

    @Override
    public by.it.evenchik.jd01_08.Var sub(by.it.evenchik.jd01_08.Var other) {
        if (other instanceof Scalar) {
            double[][] subSc = new double[value.length][value.length];
            for (int i = 0; i < subSc.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    subSc[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(subSc);
        } else if (other instanceof Matrix) {
            double[][] subMat = new double[value.length][value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    subMat[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(subMat);
        } else
            return other.add(this);
    }


    Matrix(String value) {
        value = value.replaceAll("[{|}]{2,}", "");
        String[] stringValue = value.split("[}][\\s]?,[\\s]?[{]");
        this.value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {
            String[] valueStringNumber = stringValue[i].trim().split(",");
            double[] tempArr = new double[valueStringNumber.length];
            for (int j = 0; j < valueStringNumber.length; j++) {
                tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                this.value[i] = tempArr;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if (j != value[i].length - 1) sb.append(", ");
            }
            if (i < value.length - 1) sb.append("}, ");
            if (i == value.length - 1) sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
