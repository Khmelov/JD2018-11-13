package by.it.markelov.jd01_03;

public class Runnner {
    public static void main(String[] args) {
        String line = " 12 56 54 411 -25 355 3.22 -5.11 ";

        double resultMassive[] = InOut.getArray(line);  //преобразуем строку в массив типа double

        InOut.printArray(resultMassive); //вывод массива на консоль
        System.out.println();

        InOut.printArray(resultMassive, "RM", 3); //форматированный вывод  массива на консоль
        System.out.println();

        double minValue = Helper.findMin(resultMassive); //поиск мин. значения в массиве
        System.out.println(minValue);

        double maxValue = Helper.findMax(resultMassive); //поиск макс. занчения в массиве
        System.out.println(maxValue);
        System.out.println();

        Helper.sort(resultMassive); //сортировка массива
        InOut.printArray(resultMassive, "RA", 3); //вывод массива на консоль
        System.out.println("\n");

        double mas1[][] = {
                {1.23, -2.35},
                {-3.5521, 5.11},
        };

        double mas2[][] = {
                {2.55, -1.89},
                {6.555, 2.12},
        };

        double vec[] = {4.33, 8.24};


        double resVector[] = Helper.mul(mas1, vec); //умножение матрицы на вектор
        InOut.printArray(resVector, "RV", 2); //вывод результата на консоль
        System.out.println();

        double resMatrix[][] = Helper.mul(mas1, mas2); //умножение матрицы на матрицу
        for (double[] array : resMatrix) {
            InOut.printArray(array, "RM", 2); //форматированный матрицы вывод на консоль
//            for (double element : array) {                    //простой вывод матрицы на консоль
//                System.out.print(element+" ");
            }

        }

    }


