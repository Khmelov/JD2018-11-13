package by.it.naumenko.jd01_02.jd01_03;

import java.util.Random;

public class RannerC {
    public static void main(String[] args) {
        double[][] mas = new double[2][2];
        double[] vector = new double[2];
        Random rnd = new Random();
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = rnd.nextInt(10);
            }
        }

        for (int i = 0; i < vector.length; i++) {
            vector[i] = rnd.nextInt(10);
        }

        System.out.println("Исходная матрица:");
        for (double[] str : mas) {
            for (double element : str) {
                System.out.printf("%-5.1f",element);
                //System.out.printf(element+" ");
            }
            System.out.println();
        }

        System.out.println("Исходная вектор:");
        for (double element:vector) {
            System.out.printf("%-5.1f",element);
        }
        System.out.println();
        double []rez = new double[mas.length];
        rez=Helper.mul(mas,vector);

        System.out.println("итоговый вектор:");
        for (double element:rez) {
            System.out.printf("%-5.1f",element);
        }

        double rez2[][]=new double[mas.length][mas.length];
        Helper.mul(mas,mas);

        System.out.println();
        System.out.println("Итоговая матрица:");
        for (int i = 0; i <rez2.length ; i++) {
            for (int j = 0; j <rez2[i].length ; j++) {
                System.out.print(rez2[i][j]+"  ");
            }
            System.out.println();
        }
//        for (double[] str : rez2) {
//            for (double element : str) {
//                System.out.printf("%-5.1f",element);
//            }
//            System.out.println();
//        }



    }
}
