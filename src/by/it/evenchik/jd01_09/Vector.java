package by.it.evenchik.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

    Vector(String strVector) {
        Matcher matcher = Pattern.compile("[\\w]").matcher(strVector);
        int str = 0;
        while (matcher.find()) {
            str++;
        }
        value = new double[str];
        str = 0;
        matcher.reset();
        while (matcher.find()) {
            value[str++] = Double.parseDouble(matcher.group());
        }
    }


    Vector(Vector vector) {
        this.value = vector.value;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] add = Arrays.copyOf(value, value.length);
            for (int i = 0; i < add.length; i++) {
                add[i] = add[i] + ((Scalar) other).getValue();
            }
            return new Vector(add);
        } else if (other instanceof Vector) {
            double[] add = Arrays.copyOf(value, value.length);
            for (int i = 0; i < add.length; i++) {
                add[i] = add[i] + ((Vector) other).value[i];
            }
            return new Vector(add);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] = sub[i] - ((Scalar) other).getValue();
            }
            return new Vector(sub);
        } else if (other instanceof Vector) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] = sub[i] - ((Vector) other).value[i];
            }
            return new Vector(sub);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] = mul[i] * ((Scalar) other).getValue();
            }
            return new Vector(mul);
        } else if (other instanceof Vector) {
            double mul = 0;
            for (int i = 0; i < value.length; i++) {
                mul += value[i] * ((Vector) other).value[i];
            }
            return new Scalar(mul);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Vector) {
        } else if (other instanceof Scalar) {
            double[] div = Arrays.copyOf(value, value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] = div[i] / ((Scalar) other).getValue();
            }
            return new Vector(div);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
