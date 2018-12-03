package by.it.markelov.jd01_09;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
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
        return sb.toString();
    }

    @Override
    public Var add(Var other) {

        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

}



