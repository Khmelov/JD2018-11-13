package by.it.burlakov.jd01_07;

import java.util.Arrays;

/**
 * Created by user on 27.11.2018.
 */
public class Vector extends Var {

    private double[] valueVector;

    Vector(double[] valueVector){
        this.valueVector = new double[valueVector.length];
       System.arraycopy(valueVector, 0, this.valueVector, 0, this.valueVector.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(valueVector);
    }
}
