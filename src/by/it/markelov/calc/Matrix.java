package by.it.markelov.calc;

public class Matrix extends Var {
    private double[][] value;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        for (int i = 0; i < value.length; i++) {
            String delimiter = "";
            for (int j = 0; j < value[i].length; j++) {
                stringBuilder.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i != value.length - 1) {
                delimiter = "}, {";
                stringBuilder.append(delimiter);
            } else
                stringBuilder.append("}}");
        }
        return stringBuilder.toString();
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        value = matrix.value;
    }

    Matrix(String str) {
        str = str.replaceAll("[},{]", " ");
        str = str.trim();
        String[] mas = str.split("\\s{3,}");
        String[] masCol = mas[0].split("\\s+");
        int rowCount = mas.length;
        int colCount = masCol.length;
        double masResult[][] = new double[rowCount][colCount];
        for (int i = 0; i < mas.length; i++) {
            String mass[] = mas[i].split("\\s+");
            for (int j = 0; j < mass.length; j++) {
                masResult[i][j] = Double.parseDouble(mass[j]);
            }
        }
        this.value = masResult;
    }

    @Override
    public Var add(Var other) throws CalcExeption {

        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double[][] masResult = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    masResult[i][j] = this.value[i][j] + operand2.value;
                }
            }
            return new Matrix(masResult);
        }

        if (other instanceof Vector)
            throw new CalcExeption("Сложение матрицы и вектора невозможно");

        if (other instanceof Matrix) {
            Matrix operand2 = (Matrix) other;
            if ((this.value.length != operand2.value.length) || (this.value[0].length != operand2.value[0].length))
                throw new CalcExeption("Размеры матриц несовместимы");
            double[][] masResult = new double[this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    masResult[i][j] = this.value[i][j] + operand2.value[i][j];
                }
            }
            return new Matrix(masResult);
        }

        return other.add(this);
    }

    public Var sub(Var other) throws CalcExeption {

        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double[][] massiv = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    massiv[i][j] = this.value[i][j] - operand2.value;
                }
            }
            return new Matrix(massiv);
        }

        if (other instanceof Vector)
            throw new CalcExeption("Вычитание вектора из матрицы невозможно");

        if (other instanceof Matrix) {
            Matrix operand2 = (Matrix) other;
            if ((this.value.length != operand2.value.length) || (this.value[0].length != operand2.value[0].length))
                throw new CalcExeption("Размеры матриц несовместимы");
            double[][] masResult = new double[this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    masResult[i][j] = this.value[i][j] - operand2.value[i][j];
                }
            }
            return new Matrix(masResult);
        }

        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcExeption {

        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double[][] matrixResult = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrixResult[i][j] = this.value[i][j] * operand2.value;
                }
            }
            return new Matrix(matrixResult);
        }

        if (other instanceof Vector) {
            Vector operand2 = (Vector) other;
            if (this.value[0].length != operand2.value.length)
                throw new CalcExeption("Матрица и вектор не совместимы");
            double[] vector = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < operand2.value.length; j++) {
                    vector[i] += this.value[i][j] * operand2.value[j];
                }
            }
            return new Vector(vector);
        }

        if (other instanceof Matrix) {
            Matrix operand2 = (Matrix) other;
            if (this.value[0].length != operand2.value.length)
                throw new CalcExeption("Размеры матриц несовместимы");
            double[][] matrixResult = new double[this.value.length][operand2.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < operand2.value[0].length; j++) {
                    for (int k = 0; k < operand2.value.length; k++) {
                        matrixResult[i][j] += this.value[i][k] * operand2.value[k][j];
                    }
                }
            }
            return new Matrix(matrixResult);
        }
       throw new CalcExeption("Умножение вектора на матрицу невозможно");
    }

    public Var div(Var other) throws CalcExeption {

        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double[][] matrixResult = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrixResult[i][j] = this.value[i][j] / operand2.value;
                }
            }
            return new Matrix(matrixResult);
        }

        if (other instanceof Vector) {
            throw new CalcExeption("Деление матрицы на вектор невозможно");
        }

        if (other instanceof Matrix) {
            throw new CalcExeption("Деление матрицы на матрицу невозможно");
        }

        throw new CalcExeption("Деление числа на матрицу невозможно");
    }
}
