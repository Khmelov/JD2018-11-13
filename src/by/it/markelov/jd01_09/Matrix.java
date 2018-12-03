package by.it.markelov.jd01_09;

import java.util.Arrays;

class Matrix extends Var {
    double[][] value;

    //конструктор 1
    public Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value.length);
        }
    }

    //конструктор 2
    public Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i], 0, this.value[i], 0, matrix.value.length);
        }
    }

    //конструктор 3
    public Matrix(String strMatrix) {
        String[] strings = strMatrix.split("},\\{");//сплитуем строку в массив
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll("[}{]", "").trim();//убираем фиг. скобки и пробелы в элементах массива
        }
        String splitstrings[][] = new String[strings.length][strings.length];//создаем двумерный массив и заполняем его
        for (int i = 0; i < strings.length; i++) {
            String[] split = strings[i].split(",");
            System.arraycopy(split, 0, splitstrings[i], 0, split.length);
        }

        value = new double[splitstrings.length][splitstrings[0].length];//преобразуем строки в double и заполняем массив
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                value[i][j] = Double.parseDouble(splitstrings[i][j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        for (int i = 0; i < value.length; i++) {
            String delimeter = "";
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimeter).append(value[i][j]);
                delimeter = ", ";
            }
            if(i==value.length-1) break;
            sb.append("}, {");
        }
        sb.append("}}");

/*
        int i = 0;
        String delimetr = ",";
        for (int j = 0; j < value.length; j++) {
            sb.append(value[i][j]).append(delimetr);
            delimetr = "},{";
        }
        i = 1;
        delimetr = ",";
        for (int j = 0; j < value.length; j++) {
            sb.append(value[i][j]).append(delimetr);
            delimetr = "}}";
        }
*/
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double resAdd[][] = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                resAdd[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resAdd.length; i++) {
                for (int j = 0; j < resAdd.length; j++) {
                    resAdd[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(resAdd);
        }
        if (other instanceof Vector) {
            return super.add(other);
        }
        if (other instanceof Matrix) {
            double resAdd[][] = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                resAdd[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resAdd.length; i++) {
                for (int j = 0; j < resAdd.length; j++) {
                    resAdd[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(resAdd);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double resSub[][] = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                resSub[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resSub.length; i++) {
                for (int j = 0; j < resSub.length; j++) {
                    resSub[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(resSub);
        }
        if (other instanceof Vector) {
            return super.add(other);
        }
        if (other instanceof Matrix) {
            double resSub[][] = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                resSub[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resSub.length; i++) {
                for (int j = 0; j < resSub.length; j++) {
                    resSub[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(resSub);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double resMul[][] = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                resMul[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resMul.length; i++) {
                for (int j = 0; j < resMul.length; j++) {
                    resMul[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(resMul);
        }
        if (other instanceof Vector) {
            double resMul[] = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    resMul[i] = resMul[i] + value[i][j] * ((Vector) other).value[j];
                }
            }
            return new Vector(resMul);
        }
        if (other instanceof Matrix) {
            double resMul[][] = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        resMul[i][j] += value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(resMul);
        }
        return super.mul(other);
    }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double resDiv[][] = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                resDiv[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < resDiv.length; i++) {
                for (int j = 0; j < resDiv.length; j++) {
                    resDiv[i][j] /= ((Scalar) other).getValue();
                }
            }
            return new Matrix(resDiv);
        }
        return super.div(other);
    }
}


    /*public Matrix(String strMatrix) {
        String[] strings = strMatrix.split("},");//сплитуем строку в массив
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll("[}{]", "");//убираем фиг. скобки в элементах массива
        }
        String splitstrings1[] = new String[2];//создаем допмассив 1
        splitstrings1 = strings[0].split(",");//сплитуем туда строку 1 из массива выше

        String splitstrings2[] = new String[2];//создаем допмассив 2
        splitstrings2 = strings[1].split(",");//сплитуем туда строку 2 из массива выше

        double masdouble1[] = new double[2];//создаем два дабловых массива
        double masdouble2[] = new double[2];

        for (int i = 0; i < 2; i++) {//переносим, с преобразованием, в дабловые массивы элементы доп. строковых массивов
            masdouble1[i] = Double.parseDouble(splitstrings1[i]);
            masdouble2[i] = Double.parseDouble(splitstrings2[i]);
        }

        value = new double[2][2];//создаем матрицу
        int i = 0;
        for (int j = 0; j < value.length; j++) {//инициализируем первую строку матрицы
            value[i][j] = masdouble1[j];
        }

        i = 1;
        for (int j = 0; j < value.length; j++) {//инициализируем вторую строку матрицы
            value[i][j] = masdouble2[j];
        }
    }
*/



