package by.it.burlakov.jd01_07;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value){
        this.value = new double[value.length][];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

    Matrix(Matrix otherMatrix){
        this.value = new double[otherMatrix.value.length][];
        System.arraycopy(otherMatrix.value, 0, this.value, 0, this.value.length);
    }

    Matrix(String value){
        value = value.replaceAll("[{|}]{2,}", "");
        String[] stringValue = value.split("[}][\\s]?,[\\s]?[{]");

        this.value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {

            String[] valueStringNumber = stringValue[i].trim().split(",");
            double[] tempArr = new double[valueStringNumber.length];

            for (int j = 0; j < valueStringNumber.length; j++) {
                tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                this.value[i] = tempArr;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String separ = "";
        for (double[] aValue : value) {
            for (int j = 0; j < aValue.length; j++) {
                sb.append(separ).append(aValue[j]);
                separ = ", ";
            }
            sb.append("}");
            separ = ", {";
        }
        sb.append("}");

        return sb.toString();
    }

}
