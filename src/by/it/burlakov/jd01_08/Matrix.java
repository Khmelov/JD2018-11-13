package by.it.burlakov.jd01_08;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value){
        this.value = new double[value.length][];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

    Matrix(Matrix otherMatrix){
        this.value = new double[otherMatrix.value.length][];
        System.arraycopy(otherMatrix.value, 0, this.value, 0, this.value.length);
    }

    Matrix(String value){
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

    @Override
    public Var add(Var other) {
        Var var;
        if (other instanceof Scalar) {

            double[][] result = getArrayCopy(this.value);

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Scalar) other).getValue();
                }
            }
            var = new Matrix(result);

        } else if (other instanceof Matrix) {

            double[][] result = getArrayCopy(this.value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Matrix) other).value[i][j];
                }
            }
            var = new Matrix(result);

        } else{
             var = super.add(other);
        }
        return var;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar || other instanceof Matrix) {
            return this.add(other.mul(new Scalar(-1)));
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        Var var;
        int len = this.value.length;
        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            double[][] result = getArrayCopy(this.value);

            for (double[] arr: result){
                for (int i = 0; i < arr.length; i++) {
                    arr[i] *= scalar;
                }
            }
            var = new Matrix(result);
        } else if (other instanceof Vector) {
            double[][] result = getArrayCopy(this.value);
            double[] vector = ((Vector) other).getValue();
            double[] multVector = new double[vector.length];

            //by.it.burlakov.jd01_03.Helper.mul;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    multVector[i] += result[i][j] * vector[j];
                }
            }
            var = new Vector(multVector);
        } else {
            double[][] result = getArrayCopy(this.value);
            double[][] multMatrix = getInitArray(len);

            //by.it.burlakov.jd01_03.Helper.mul;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    for (int k = 0; k < result.length; k++) {
                        multMatrix[i][j] += result[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            var = new Matrix(multMatrix);
        }
        return var;
    }

    @Override
    public Var div(Var other) {

        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            double[][] result = getArrayCopy(this.value);

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] /= scalar;
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
    }

    private double[][] getInitArray(int len){
        return new double[len][len];
    }

    private double[][] getArrayCopy(double[][] arr){
        double[][] result = new double[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[i][j];
            }
        }
        return result;
    }

//    private double[][] addArrAndArgument(

    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String separ = "";
        for (double[] aValue : value) {
            for (double anAValue : aValue) {
                sb.append(separ).append(anAValue);
                separ = ", ";
            }
            sb.append("}");
            separ = ", {";
        }
        sb.append("}");

        return sb.toString();
    }
}
