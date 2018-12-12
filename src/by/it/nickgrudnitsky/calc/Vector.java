package by.it.nickgrudnitsky.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(strVector);
        double[] array = new double[0];
        int i = 0;
        while (matcher.find()) {
            int last = array.length;
            array = Arrays.copyOf(array, last + 1);
            array[i] = Double.parseDouble(matcher.group());
            i++;
        }
        value = array;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] rezult = Arrays.copyOf(value, value.length);
            for (int i = 0; i < rezult.length; i++) {
                rezult[i] = rezult[i] + ((Scalar) other).getValue();
            }
            return new Vector(rezult);
        } else {
            if (other instanceof Vector) {
                if (((Vector) other).value.length != this.value.length) {
                    throw new CalcException("Сложение невозможно");
                }
                double[] rezult = Arrays.copyOf(value, value.length);
                for (int i = 0; i < this.value.length; i++) {
                    rezult[i] = rezult[i] + ((Vector) other).value[i];
                }
                return new Vector(rezult);
            } else {
                return super.add(other);
            }
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] rezult = Arrays.copyOf(value, value.length);
            for (int i = 0; i < rezult.length; i++) {
                rezult[i] = rezult[i] - ((Scalar) other).getValue();
            }
            return new Vector(rezult);
        } else {
            if (other instanceof Vector && value.length == ((Vector) other).value.length) {
                double[] rezult = Arrays.copyOf(value, value.length);
                for (int i = 0; i < rezult.length; i++) {
                    rezult[i] = rezult[i] - ((Vector) other).value[i];
                }
                return new Vector(rezult);
            } else {
                return super.sub(other);
            }
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] rezult = Arrays.copyOf(value, value.length);
            for (int i = 0; i < rezult.length; i++) {
                rezult[i] = rezult[i] * ((Scalar) other).getValue();
            }
            return new Vector(rezult);
        } else {
            if (other instanceof Vector && value.length == ((Vector) other).value.length) {
                double[] vector = Arrays.copyOf(value, value.length);
                double rezult = 0;
                for (int i = 0; i < vector.length; i++) {
                    rezult += vector[i] * ((Vector) other).value[i];
                }
                return new Scalar(rezult);
            } else {
                return super.mul(other);
            }
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] rezult = Arrays.copyOf(value, value.length);
            for (int i = 0; i < rezult.length; i++) {
                rezult[i] = rezult[i] / ((Scalar) other).getValue();
            }
            return new Vector(rezult);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < value.length; i++) {
            stringBuilder.append(value[i]);
            if (i != value.length - 1) {
                stringBuilder.append(", ");
            } else {
                break;
            }
        }
        stringBuilder.append("}");
        return new String(stringBuilder);
    }
}
