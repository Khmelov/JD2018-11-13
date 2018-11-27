package by.it.denisova.jd01_03;

import java.util.Random;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String line = scaner.nextLine();
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr);
        InOut.printArray(arr, "A", 5);
        Helper.findMin(arr);
        Helper.findMax(arr);
        Helper.sort(arr);
        double [][] matrix = generationRandomMatrix(scanInpotN(),scanInportM());
        double [] vector = generationRandomVector(scanInpotN());
        Helper.mul(matrix,vector);



       /* int n = scaner.nextInt();

       /* double[][] mas = new double[n][n];
       /* create_mas(mas);
       /* Helper.mul(mas);


    }

    public static double create_mas(double mas[][]) {
        Random rand = new Random();

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = rand.nextDouble();

            }
        }
        return create_mas(mas);

    }*/

    }

    private static int scanInpotN(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        return n;
    }

    private static int scanInportM(){
        Scanner scanner= new Scanner(System.in);
        int m = scanner.nextInt();

        return m;

    }
    private static double[][] generationRandomMatrix(int n, int m){
        Random rand = new Random();

        double [][] mas = new double[n][m];

        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j <mas.length; j++) {
                mas[i][j]= rand.nextDouble();
            }

        }
        return mas;

    }

    private static double[] generationRandomVector( int n){

        Random rand = new Random();

        double [] massiv = new double[n];

        for (int i = 0; i <massiv.length ; i++) {
            massiv[i]=rand.nextDouble();

        }
        return massiv;
    }



}
