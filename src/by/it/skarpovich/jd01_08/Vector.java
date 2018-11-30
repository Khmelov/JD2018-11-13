package by.it.skarpovich.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector){
        value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, value, 0, vector.value.length);
    }

    //Сложение
    @Override
    public Var add(Var other) {
        System.out.println("Сложение");
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
        } else
            return other.add(this);
    }

    @Override
    public Var sub (Var other) {
        System.out.println("Вычитание");
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
        } else
            return other.add(this);
    }


    @Override
    public Var mul (Var other) {
        System.out.println("Произведение");
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);

        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            double sum=0;
//            C
            for (int i = 0; i < res.length; i++) {
                    res[i]=res[i] * ((Vector) other).value[i];

            }
            return new Vector(res);
        } else
            return other.add(this);
    }

    @Override
    public Var div (Var other) {
        System.out.println("Деление");
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else
            return super.div(other);
    }

//    int res5 = 0;
//        for (int n : arr51)
//            for (int m: arr52){
//        res5 += n*m;
//    }



    Vector(String strVector) {
        //StringBuilder sBuilder= new StringBuilder(strVector);
        Matcher matcher = Pattern.compile("\\{(.*)\\}").matcher(strVector);
        while (matcher.find()) {
            String[] strVectorArray = matcher.group(1).replace(" ", "").split(",");
            value = new double[strVectorArray.length];
            for (int i = 0; i <strVectorArray.length; i++) {
                value[i] = Double.parseDouble(strVectorArray[i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v2 : value) {
            sb.append(delimiter).append(v2);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();

    }
}
