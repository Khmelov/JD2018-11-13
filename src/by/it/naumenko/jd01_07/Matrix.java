package by.it.naumenko.jd01_07;

public class Matrix extends Var {
    private double[][] value;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        for (int i = 0; i < value.length; i++) {
            String del = "";
            for (int j = 0; j < value[i].length; j++) {
                stringBuilder.append(del).append(value[i][j]);
                del = ", ";
            }
            if (i != value.length - 1) {
                del = "},{";
                stringBuilder.append(del);
            } else
                stringBuilder.append("}}");
        }

        return stringBuilder.toString();
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix){
        value=matrix.value;
    }

    Matrix(String strMatrix){
        strMatrix=strMatrix.replaceAll("[},{]"," ");
        strMatrix=strMatrix.trim();
        String[] mas = strMatrix.split("\\s{2,}");
        String [] masCol=mas[0].split("\\s");//узнать количество столбцов
        int rowCount = mas.length;//количество строк
        int colCount = masCol.length;//количество столбцов

        double massiv[][]=new double[rowCount][colCount];
        for (int i = 0; i < mas.length; i++) {
            String massivel[]=mas[i].split("\\s+");
            for (int j = 0; j <massivel.length ; j++) {
                massiv[i][j]=Double.parseDouble(massivel[j]);
            }
        }
        this.value=massiv;
    }
}
