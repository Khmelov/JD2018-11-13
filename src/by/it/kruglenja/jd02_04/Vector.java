package by.it.kruglenja.jd02_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 27.11.2018.
 */
public class Vector extends Var {
    private double value[];

    public double[] getValue() { return value; }

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector otherVector) {
        this.value = new double[otherVector.value.length];
        System.arraycopy(otherVector.value, 0, this.value, 0, otherVector.value.length);
    }

    Vector(String strVector) {
        Pattern extractor = Pattern.compile("[0-9.]+");
        Matcher extrMatcher = extractor.matcher(strVector);
        int len = 0;
        while (extrMatcher.find()) {
            len++;
        }
        extrMatcher.reset();
        this.value = new double[len];
        int count = 0;
        while (extrMatcher.find()) {
            this.value[count] = Double.parseDouble(extrMatcher.group());
            count++;
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Vector) {
            int len = this.value.length < ((Vector) other).value.length ? this.value.length : ((Vector) other).value.length;
            double[] sum = new double[len];
            for (int i = 0; i < len; i++) {
                sum[i] = this.value[i] + ((Vector) other).value[i];
            }
            return new Vector(sum);
        }
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] sum = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                sum[i] = this.value[i] + otherScalar.getValue();
            }
            return new Vector(sum);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            int len = this.value.length < ((Vector) other).value.length ? this.value.length : ((Vector) other).value.length;
            double[] sub = new double[len];
            for (int i = 0; i < len; i++) {
                sub[i] = this.value[i] - ((Vector) other).value[i];
            }
            return new Vector(sub);
        }
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double[] sub = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                sub[i] = this.value[i] - otherScalar.getValue();
            }
            return new Vector(sub);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double mul = 0;
            if (this.value.length == ((Vector) other).value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    mul += this.value[i] * ((Vector) other).value[i];
                }
            }
            return new Scalar(mul);
        }
        if (other instanceof Scalar) {
            double[] mul = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                mul[i] = this.value[i] * ((Scalar) other).getValue();
            }
            return new Vector(mul);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] div = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                div[i] = this.value[i] / ((Scalar) other).getValue();
            }
            return new Vector(div);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            res.append(value[i]);
            if (i != value.length - 1) {
                res.append(", ");
            }
            if (i == value.length - 1) {
                res.append("}");
            }
        }
        return res.toString();
    }
}
