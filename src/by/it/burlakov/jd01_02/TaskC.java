package by.it.burlakov.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        int[][] matrix = step1(inputSize());

        int sum = step2(matrix);

        int[][] shortMatrix = step3(matrix);

    }
    static int[][] step1(int n){
        boolean isNumbers = false;
        int[][] result = null;

        while(!isNumbers){
            boolean flagPos = false;
            boolean flagNeg = false;

            result = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = randomNumber(n);

                    if(!flagPos && result[i][j] == n){
                        flagPos = true;
                    }
                    if (!flagNeg && result[i][j] == -n){
                        flagNeg = true;
                    }
                }
            }
            if(!flagPos || !flagNeg){
                isNumbers = false;
            } else {
                isNumbers = true;
            }
        }
        printMatrix(result);
        return result;
    }

    static int step2(int[][] mas){
        int sum = 0;

        for (int i = 0; i < mas[0].length; i++) {
            int sumRow = 0;
            int count = 0;
            int[] index = new int[2];

            for (int j = 0; j < mas[0].length; j++) {
                if(mas[i][j] > 0){
                   index[count++] = j;

                   if(count == 2){
                        for (int k = ++index[0]; k < index[1]; k++) {
                            sumRow += mas[i][k];
                        }
                        break;
                   }
                }
            }
            sum += sumRow;
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][]mas){

        int[][] indexDel = new int[2][mas.length];//array for del rows & columns
        int max = mas[0][0];
        //find maximum
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
               if(mas[i][j] > max){
                   max = mas[i][j];
               }
            }
        }
        //find index
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j] == max){
                    indexDel[0][j]++;
                    indexDel[1][i]++;
                }
            }
        }
        //calc size result array
        int column = 0;
        int row = 0;
        for (int i = 0; i < mas.length; i++) {
                if(indexDel[0][i] == 0){
                    column++;
                }
                if(indexDel[1][i] == 0){
                    row++;
                }
        }
        //create result array
        int[][] result = new int[row][column];
        int indexRow = 0;

        for (int i = 0; i < mas.length; i++) {
                int indexColum = 0;
                if(indexDel[1][i] == 0){
                    for (int j = 0; j < mas.length; j++) {
                        if(indexDel[0][j] == 0){
                            result[indexRow][indexColum] = mas[i][j];
                            indexColum++;
                        }
                    }
                } else {
                    indexRow--;
                }
                indexRow++;
        }

        printMatrix(result);
        return result;
    }

    private static int randomNumber(int sizeMatrix) {
        int number = (int) (Math.random() * (sizeMatrix * 2 + 1)) - sizeMatrix;
        return number;
    }

    private static int inputSize() {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        return size;
    }

    private static void printMatrix(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
