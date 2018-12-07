package by.it.karnilava.jd01_09;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {

        String[] strArr = strVector.replaceAll("[{}]", "").split("[,]");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        this.value = res;

    }


    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        }


        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            double[] vec = Arrays.copyOf(((Vector) other).value, ((Vector) other).value.length);
            if (res.length == vec.length) {
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + vec[i];
                }
                return new Vector(res);

            } else

                return super.add(other);
        }
        return super.add(other);
    }

    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        }


        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            double[] vec = Arrays.copyOf(((Vector) other).value, ((Vector) other).value.length);
            if (res.length == vec.length) {
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] - vec[i];
                }
                return new Vector(res);

            } else

                return super.sub(other);
        }
        return super.sub(other);
    }

    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);

        }
        if (other instanceof Vector){
            double[] res = Arrays.copyOf(value, value.length);
            double[] vec = Arrays.copyOf(((Vector) other).value, ((Vector) other).value.length);
            if (res.length == vec.length) {
                double mul = 0;
                for (int i = 0; i < res.length; i++) {
                    mul = mul+res[i]*vec[i];
                }
                return new Scalar (mul);

            } else

                return super.mul(other);

        }

            return super.mul(other);
    }


    public Var div (Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);

        }


        return super.div(other);
    }

        public String toString () {
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
