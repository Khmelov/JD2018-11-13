package by.it.lobkova.jd01_07;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Vector extends Var {
    public static void main(String[] args) {

    }

    public Vector(double[] value) {
        super(value);
    }

    public Vector(Vector vector) {
        super(vector.getValue());
    }

//    public Vector(String strVector) {
//        super(strVector);
//    }

    @Override
    public String toString() {
        return Arrays.toString((double[]) getValue());
    }
}
