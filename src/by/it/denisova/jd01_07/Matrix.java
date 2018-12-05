package by.it.denisova.jd01_07;

public class Matrix extends Var {

    double [][] value;

    public Matrix(double[][] value) {
        this.value = new double[value.length][];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

    public Matrix(Matrix otherMatrix){
        this.value = new double[otherMatrix.value.length][];
        System.arraycopy(otherMatrix.value, 0, this.value, 0, this.value.length);
    }

    Matrix(String value){
        value = value.replaceAll("[{|}]{2,}", "");
        String[] strValue = value.split("[}][\\s]?,[\\s]?[{]");

        this.value = new double[strValue.length][];
        for (int i = 0; i < strValue.length; i++) {

            String[] valueStrNumb = strValue[i].trim().split(",");
            double[] tempArr = new double[valueStrNumb.length];

            for (int j = 0; j < valueStrNumb.length; j++) {
                tempArr[j] = Double.parseDouble(valueStrNumb[j]);
                this.value[i] = tempArr;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (double[] aValue : value) {
            for (int j = 0; j < aValue.length; j++) {
                sb.append(delimiter).append(aValue[j]);
                delimiter = ", ";
            }
            sb.append("}");
            delimiter = ", {";
        }
        sb.append("}");

        return sb.toString();
    }
}
