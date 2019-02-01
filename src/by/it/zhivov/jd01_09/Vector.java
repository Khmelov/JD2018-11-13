package by.it.zhivov.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    double value[];

    public Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    public Vector(Vector vector) {
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    public Vector(String strVector) {
        String withoutBraces = strVector.replaceAll("[}{]", "");
        String[] s = withoutBraces.split(",");
        value = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            value[i] = Double.parseDouble(s[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String demiliter = "";
        for (double element : value) {
            sb.append(demiliter).append(element);
            demiliter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double resAdd[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resAdd.length; i++) {
                resAdd[i] = resAdd[i] + ((Scalar) other).getValue();
            }
            return new Vector(resAdd);
        } else if (other instanceof Vector) {
            double resAdd[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resAdd.length; i++) {
                resAdd[i] = resAdd[i] + ((Vector) other).value[i];
            }
            return new Vector(resAdd);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double resSub[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resSub.length; i++) {
                resSub[i] = resSub[i] - ((Scalar) other).getValue();
            }
            return new Vector(resSub);
        } else if (other instanceof Vector) {
            double resSub[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resSub.length; i++) {
                resSub[i] = resSub[i] - ((Vector) other).value[i];
            }
            return new Vector(resSub);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double resMul[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resMul.length; i++) {
                resMul[i] = resMul[i]*((Scalar) other).getValue();
            }
            return new Vector(resMul);
        } else if (other instanceof Vector) {
            //double resMul[] = Arrays.copyOf(value, value.length);
            double sum=0;
            for (int i = 0; i < value.length; i++) {
                sum += value[i] * ((Vector) other).value[i];//сумма произведений элементов векторов
            }
            return new Scalar(sum);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double resDiv[] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resDiv.length; i++) {
                resDiv[i] = resDiv[i]/((Scalar) other).getValue();
            }
            return new Vector(resDiv);
        } else return super.div(other);
    }
}
