package by.it.burlakov.jd01_09;

import java.util.Arrays;

/**
 * Created by user on 27.11.2018.
 */
public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] valueVector) {
        this.value = new double[valueVector.length];
        System.arraycopy(valueVector, 0, this.value, 0, this.value.length);
    }

    Vector(Vector otherVector) {
        this.value = new double[otherVector.value.length];

        System.arraycopy(otherVector.value, 0, this.value, 0, this.value.length);
    }

    Vector(String value) {
        value = value.replaceAll("[{|}]", "");
        String[] stringValue = value.split(",");
        this.value = new double[stringValue.length];
        for (int i = 0; i < stringValue.length; i++) {
            this.value[i] = Double.parseDouble(stringValue[i].trim());
        }
    }
    public String toString() {

        StringBuilder sb = new StringBuilder("{");
        String separ = "";
        for (double val : value) {
            sb.append(separ).append(val);
            separ = ", ";
        }
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        Var var;
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Scalar) other).getValue();
            }
            var = new Vector(result);
        }
        else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            var = new Vector(result);
        } else {
            var = super.add(other);
        }
        return var;
    }

    @Override
    public Var sub(Var other) {
        Var var;
        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= scalar;
            }
            var = new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            var = new Vector(result);
        } else {
            var = super.sub(other);
        }
        return var;
    }

    @Override
    public Var div(Var other) {
        Var var;
        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] /= scalar;
            }
            var = new Vector(result);
        } else {
            var = super.div(other);
        }
        return var;
    }


    public Var mul(Var other) {
        Var var;
        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= scalar;
            }
            var = new Vector(result);
        } else if (other instanceof Vector) {
            double summa = 0.0;
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Vector) other).value[i];
                summa += result[i];
            }
            var = new Scalar(summa);
        } else {
            var = super.mul(other);
        }
        return var;
    }
}