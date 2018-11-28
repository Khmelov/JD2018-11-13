package by.it.skarpovich.jd01_07;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.value = value;
            }
        }
        //System.arraycopy(value, 0, this.value, 0, this.value.length);
    }




//
////        for (int i = 0; i < value.length; i++) {
////            for (int j = 0; j < value.length; j++) {
////                this.value[i][j] = value[i][j];
//            }
//
//        }
//    }
//
//    Matrix(Matrix matrix) {
//        this.value = Arrays.value;
//    }


    Matrix(String strMatrix) {

        Matcher matcher = Pattern.compile("\\{(.*)\\}").matcher(strMatrix);
        while (matcher.find()) {
            String[] strMatrixArray = matcher.group(1).replace(" ", "").split(",");
            value = new double[strMatrixArray.length][strMatrixArray.length];
            for (int i = 0; i < strMatrixArray.length; i++) {
                for (int j = 0; j < strMatrixArray.length; j++) {
                    value[i][j] = Double.parseDouble(strMatrixArray[i]);
                    System.out.println(value[i][j]);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < 2; j++) {

                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";


            }

        }
        sb.append("}");
        return sb.toString();




//        String v3=Arrays.deepToString(value);
//        return v3;

    }
}


