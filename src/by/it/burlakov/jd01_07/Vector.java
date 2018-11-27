package by.it.burlakov.jd01_07;

import java.util.Arrays;

/**
 * Created by user on 27.11.2018.
 */
public class Vector extends Var {

<<<<<<< b36ad934598f84161d78637e307b7a61dbcf9efd
    private double[] value;

    Vector(double[] valueVector){
        this.value = new double[valueVector.length];
       System.arraycopy(valueVector, 0, this.value, 0, this.value.length);
    }

    Vector(Vector otherVector){
        this.value = new double[otherVector.value.length];

        System.arraycopy(otherVector.value, 0, this.value, 0, this.value.length);
    }

    Vector(String value){
        value = value.replaceAll("[{|}]", "");
        String[] stringValue = value.split(",");
        this.value = new double[stringValue.length];
        for (int i = 0; i < stringValue.length; i++) {
            this.value[i] = Double.parseDouble(stringValue[i].trim());
        }
=======
    private double[] valueVector;

    Vector(double[] valueVector){
        this.valueVector = new double[valueVector.length];
       System.arraycopy(valueVector, 0, this.valueVector, 0, this.valueVector.length);
>>>>>>> TaskA
    }

    @Override
    public String toString() {
<<<<<<< b36ad934598f84161d78637e307b7a61dbcf9efd
            StringBuilder sb = new StringBuilder("{");
            String separ = "";
        for (double val : value) {
            sb.append(separ).append(val);
            separ = ", ";
        }
        sb.append("}");
        return sb.toString();
=======
        return Arrays.toString(valueVector);
>>>>>>> TaskA
    }
}
