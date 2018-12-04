package by.it.kruglenja.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double value[][];

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix) {
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    sum[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sum);
        }
        if (other instanceof Scalar) {
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    sum[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(sum);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix) {
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    sub[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub);
        }
        if (other instanceof Scalar) {
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    sub[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);

        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix) {
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    for (int k = 0; k < this.value.length; k++) {
                        mul[i][j] += this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mul);
        }
        if (other instanceof Vector) {
            double[] mul = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    mul[i] += this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(mul);
        }
        if (other instanceof Scalar) {
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    mul[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] div = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    for (int k = 0; k < this.value.length; k++) {
                        div[i][j] += this.value[i][k] / ((Scalar) other).getValue();
                    }
                }
            }
            return new Matrix(div);
        }
        return other.div(this);
    }

     Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix2) {
        this.value = new double[matrix2.value.length][matrix2.value[0].length];

        for (int i = 0; i < value.length; i++) {
            System.arraycopy(matrix2.value[i], 0, this.value[i], 0, matrix2.value[i].length);
        }
    }

    Matrix(String strMatrix) {
        Pattern extractor = Pattern.compile("[0-9[^}{]]+");
        Matcher extrMatch = extractor.matcher(strMatrix);
        Pattern clean = Pattern.compile("[0-9[^, ]]+");
        String temCount = " ";
        int rowCount = 0;
        int colCount = 0;
        while (extrMatch.find()) {
            if ((", ".equals(extrMatch.group())) || (",".equals(extrMatch.group()))) {
                continue;
            }
            temCount = extrMatch.group();
            rowCount++;
        }
        extrMatch.reset();
        Matcher cleaner = clean.matcher(temCount);
        while (cleaner.find()) {
            colCount++;
        }
        String[] arrLines = new String[rowCount];
        int countLines = 0;
        while (extrMatch.find()) {
            if ((", ".equals(extrMatch.group())) || (",".equals(extrMatch.group()))) {
                continue;
            }
            arrLines[countLines] = extrMatch.group();
            countLines++;
        }
        this.value = new double[rowCount][colCount];
        for (int i = 0; i < arrLines.length; i++) {
            int countColumns = 0;
            Matcher cleaner2 = clean.matcher(arrLines[i]);
            while (cleaner2.find()) {
                this.value[i][countColumns] = Double.parseDouble(cleaner2.group());
                countColumns++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        String curlBrac1 = "{";
        String curlBrac2 = "}, ";
        for (int i = 0; i < value.length; i++) {
            res.append(curlBrac1);
            for (int j = 0; j < value[i].length; j++) {
                res.append(value[i][j]);
                if (j != value[i].length - 1) {
                    res.append(", ");
                }
            }
            if (i == value.length - 1) {
                res.append("}}");
            } else {
                res.append(curlBrac2);
            }
        }
        return res.toString();
    }
}
