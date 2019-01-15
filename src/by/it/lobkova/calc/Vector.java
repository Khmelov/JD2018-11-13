package by.it.lobkova.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    public double[] getValue() {
        return value;
    }

    Vector(String str) throws ExceptionCalc {
            String[] string = str.replaceAll("[{}]", "").split("[,]");
            double[] vector = new double[string.length];
            for (int i = 0; i < vector.length; i++) {
                vector[i] = Double.parseDouble(string[i]);
            }
            this.value = vector;
    }

    @Override
    public Var add(Var other) throws ExceptionCalc {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        } else {
            return super.sub(other);
        }
    }


    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (res.length == value.length) {
                double mul = 0;
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] * ((Vector) other).value[i];
                    mul += res[i];
                }
                return new Scalar(mul);
            }
        } else {
            return super.mul(other);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws ExceptionCalc {
        if (other instanceof Scalar) {
           // if (((Scalar) other).getValue() != 0) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] / ((Scalar) other).getValue();
                }
                return new Vector(res);
           // } else throw new ExceptionCalc("Деление на 0 невозможно");
        } else if (other instanceof Vector) {
            throw new ExceptionCalc("Деление вектора на вектор невозмоно");
        }

        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String dilimiter = "";
        for (double element : value) {
            sb.append(dilimiter).append(element);
            dilimiter = ", ";
        }
        sb.append("}");

        return sb.toString();
    }


}

