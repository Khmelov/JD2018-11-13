package by.it.seroglazov.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    @Override
    String getType() {
        return "Matrix";
    }

    private static String ErrMessPatternNotFound = "Exception: Ошибка ввода матрицы. Не найден шаблон: {{1,2,...},{3,4,...},...}";
    private static String ErrMessDifferentColsCount = "Exception: Количество столбцов в каждой строке матрицы должно быть задано одинаковым.";

    Matrix(double[][] value) {
        if (value.length == 0) {
            this.value = new double[0][];
        } else {
            int cols = value[0].length;
            for (double[] aValue : value) { // Check: matrix should be rectangle
                if (aValue.length != cols) {
                    // Call exception
                }
            }
            this.value = new double[value.length][cols];
            for (int i = 0; i < value.length; i++) {
                System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
            }
        }
    }

    Matrix(Matrix anMatr) {
        if (anMatr.value.length == 0) {
            value = new double[0][0];
        } else {
            value = new double[anMatr.value.length][anMatr.value[0].length];
            for (int i = 0; i < anMatr.value.length; i++) {
                System.arraycopy(anMatr.value[i], 0, value[i], 0, anMatr.value[i].length);
            }
        }
    }

    Matrix(String str) {

        String strWithoutWhiteSpaces = str.replaceAll("\\s", "");
        if (!strWithoutWhiteSpaces.matches("[{]([{][^{}]+[}],)*[{][^{}]+[}][}]")) { // Pattern to string like {{2.0,3,9},{4.75,6,0},{1e2,0xA,010}}
            System.out.println(ErrMessPatternNotFound);
        }
        Pattern extCurlyBrackets = Pattern.compile("[{](.*)[}]"); // Find all inside external curly brackets
        Matcher m1 = extCurlyBrackets.matcher(strWithoutWhiteSpaces);
        if (m1.find()) {
            Pattern intCurlyBrackets = Pattern.compile("[{]([^}]*)[}]"); // Find all internal curly brackets
            Matcher m2 = intCurlyBrackets.matcher(m1.group(1));
            int counter = 0;
            while (m2.find()) counter++; // First step - simple counting internal {}
            if (counter == 0) {
                System.out.println(ErrMessPatternNotFound);
            }
            value = new double[counter][];
            m2.reset();
            int i = 0;
            while (m2.find()) {
                String[] strRows = m2.group(1).split(",");
                value[i] = new double[strRows.length];
                for (int j = 0; j < strRows.length; j++) {
                    value[i][j] = Double.parseDouble(strRows[j]);
                }
                i++;
            }
            // Now check is our matrix a rectangle?
            int len = value[0].length; // At this point value has at least one element
            for (double[] v : value) {
                if (v.length != len) {
                    System.out.println(ErrMessDifferentColsCount);
                    break;
                }
            }
        } else {
            System.out.println(ErrMessPatternNotFound);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            sb.append(value[i][0]);
            for (int j = 1; j < value[0].length; j++) {
                sb.append(", ");
                sb.append(String.valueOf(value[i][j]));
            }
            if (i == value.length - 1) sb.append("}");
            else sb.append("}, ");
        }
        sb.append("}");
        return sb.toString();
    }

    // Matrix +- Scalar = Matrix (true - add; false - subtract)
    private Var addOrSubScal(Var other, boolean operation) {
        int op = operation ? 1 : -1;
        double s = ((Scalar) other).getValue();
        double[][] nm = new double[value.length][];
        for (int i = 0; i < nm.length; i++) {
            nm[i] = new double[value[i].length];
            for (int j = 0; j < nm[i].length; j++) {
                nm[i][j] = value[i][j] + op * s;
            }
        }
        return new Matrix(nm);
    }

    // Matrix + Scalar = Matrix
    private Var addScal(Var other) {
        return addOrSubScal(other, true);
    }

    // Matrix - Scalar = Matrix
    private Var subScal(Var other) {
        return addOrSubScal(other, false);
    }

    // Matrix + Vector = null
    private Var addVec(Var other) {
        return super.add(other);
    }

    // Matrix - Vector = null
    private Var subVec(Var other) {
        return super.sub(other);
    }

    // Matrix +- Matrix = Matrix or null (true - add; false - subtract)
    private Var addOrSubMatr(Var other, boolean operation) {
        int op = operation ? 1 : -1;
        Matrix m = (Matrix) other;
        double[][] nm = new double[value.length][];
        if (m.value.length != value.length) {
            return operation ? super.add(other) : super.sub(other);
        }
        for (int i = 0; i < value.length; i++) {
            if (m.value[i].length != value[i].length) {
                return operation ? super.add(other) : super.sub(other);
            }
            nm[i] = new double[value[i].length];
            for (int j = 0; j < value[i].length; j++) {
                nm[i][j] = value[i][j] + op * m.value[i][j];
            }
        }
        return new Matrix(nm);
    }

    // Matrix + Matrix = Matrix or null
    private Var addMatr(Var other) {
        return addOrSubMatr(other, true);
    }

    // Matrix - Matrix = Matrix or null
    private Var subMatr(Var other) {
        return addOrSubMatr(other, false);
    }

    // Matrix (*/) Scalar = Matrix (true - multiply; false - division)
    private Var mulOrDivScal(Var other, boolean operation) {
        double s = ((Scalar) other).getValue();
        double[][] a = new double[value.length][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new double[value[i].length];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = operation ? value[i][j] * s : value[i][j] / s;
            }
        }
        return new Matrix(a);
    }

    // Matrix * Scalar = Matrix
    private Var mulScal(Var other) {
        return mulOrDivScal(other, true);
    }

    // Matrix / Scalar = Matrix
    private Var divScal(Var other) {
        return mulOrDivScal(other, false);
    }

    // Matrix * Vector = Vector or null
    private Var mulVec(Var other) {
        Vector v = (Vector) other;
        int vLen = v.getValue().length; // "other" length
        int nvLen = value.length; // new vector length
        double[] otherVec = v.getValue();
        double[] nv = new double[nvLen];
        for (int i = 0; i < nvLen; i++) {
            if (value[i].length != vLen) return super.mul(other);
            nv[i] = 0; // Not necessary, but just in case
            for (int j = 0; j < vLen; j++) {
                nv[i] += value[i][j] * otherVec[j];
            }
        }
        return new Vector(nv);
    }

    // Matrix / Vector = null
    private Var divVec(Var other) {
        return super.div(other);
    }

    // Matrix * Matrix = Matrix or null
    private Var mulMatr(Var other) {
        Matrix m = (Matrix) other;
        int rows1 = value.length;
        if (rows1 == 0) return super.mul(other);
        int cols1 = value[0].length;
        int rows2 = m.value.length;
        if (rows2 == 0) return super.mul(other);
        int cols2 = m.value[0].length;
        if (cols1 != rows2) return super.mul(other);
        double[][] nm = new double[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    nm[i][j] += value[i][k] * m.value[k][j];
                }
            }
        }
        return new Matrix(nm);
    }

    // Matrix / Matrix = null
    private Var divMatr(Var other) {
        return super.div(other);
    }

    @Override
    public Var add(Var other) {
        if (other.getType() == "Scalar") return addScal(other);
        else if (other.getType() == "Vector") return addVec(other);
        else if (other.getType() == "Matrix") return addMatr(other);
        else return other.add(this); // For the future possible extend
    }

    @Override
    public Var sub(Var other) {
        if (other.getType() == "Scalar") return subScal(other);
        else if (other.getType() == "Vector") return subVec(other);
        else if (other.getType() == "Matrix") return subMatr(other);
        else return other.sub(this).mul(new Scalar(-1)); // For the future possible extend
    }

    @Override
    public Var mul(Var other) {
        if (other.getType() == "Scalar") return mulScal(other);
        else if (other.getType() == "Vector") return mulVec(other);
        else if (other.getType() == "Matrix") return mulMatr(other);
        else return other.mul(this); // For the future possible extend
    }

    @Override
    public Var div(Var other) {
        if (other.getType() == "Scalar") return divScal(other);
        else if (other.getType() == "Vector") return divVec(other);
        else if (other.getType() == "Matrix") return divMatr(other);
        else return super.div(other); // For the future possible extend
    }

    /*@Override
    public Var add(Var other) {
        if (other instanceof Scalar) return addScal(other);
        else if (other instanceof Vector) return addVec(other);
        else if (other instanceof Matrix) return addMatr(other);
        else return other.add(this); // For the future possible extend
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) return subScal(other);
        else if (other instanceof Vector) return subVec(other);
        else if (other instanceof Matrix) return subMatr(other);
        else return other.sub(this).mul(new Scalar(-1)); // For the future possible extend
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) return mulScal(other);
        else if (other instanceof Vector) return mulVec(other);
        else if (other instanceof Matrix) return mulMatr(other);
        else return other.mul(this); // For the future possible extend
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) return divScal(other);
        else if (other instanceof Vector) return divVec(other);
        else if (other instanceof Matrix) return divMatr(other);
        else return super.div(other); // For the future possible extend
    }*/
}


















