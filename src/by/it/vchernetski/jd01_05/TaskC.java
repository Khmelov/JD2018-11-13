package by.it.vchernetski.jd01_05;
import by.it.vchernetski.jd01_04.TaskB;

import static java.lang.Math.*;
public class TaskC {
    private static void sort(long[ ] arr) {
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 1; j <arr.length ; j++) {
                if(arr[j]<arr[j-1]){
                    long temp;
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
    private static void fillArray(double[] A, int n) {
        double step = (9 - 5.33) / n;
        ;
        int counter = 0;
        for (double x = 5.33; x <= 9; x += step) {
            if (counter >= A.length) break;
            A[counter] = pow((x * x + 4.5), 1.0 / 3);
            counter++;
        }
    }

    private static double[] newArray(double[] A) {
        int size = 0;
        for (double i : A) {
            if (i > 3.5) size++;
        }
        double[] mas = new double[size];
        size = 0;
        for (double i : A) {
            if (i > 3.5) {
                mas[size] = i;
                size++;
            }
        }
        return mas;
    }

    private static void printtable (long [] A, int c, String name){ //печатате массив в таблице
        int coll = 10 * c + 1;
        double l = (double) A.length/c;
        int lines = ((int) ceil(((double)A.length/c))) * 2+1;
        char[][] matrix = new char[lines][coll];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if (i == 0 && j == 0){
                    matrix[i][j] = 0x2554;
                    continue;
                }
                if( i == 0 && j == matrix[i].length-1 ){
                    matrix[i][j] = 0x2557;
                    continue;
                }
                if ( j == 0 && i == matrix.length - 1 ){
                    matrix[i][j] = 0x255a;
                    continue;
                }
                if (j == matrix[i].length - 1 && i == matrix.length - 1){
                    matrix[i][j] = 0x255d;
                    continue;
                }
                if (i == 0 && j % 10 == 0 && j != 0 && j != matrix[i].length){
                    matrix[i][j] = 0x2566;
                    continue;
                }
                if (i  == matrix.length - 1 && j % 10 == 0 && j != 0 && j != matrix[i].length){
                    matrix[i][j] = 0x2569;
                    continue;
                }
                if (i % 2 == 0 && j % 10 == 0 && j != 0 && j != matrix[i].length - 1){
                    matrix[i][j] = 0x256c;
                    continue;
                }
                if (i == 0 && j != 0 && j != matrix[i].length -1 || i == matrix.length -1 && j != 0 && j != matrix[i].length - 1){
                    matrix[i][j] = 0x2550;
                    continue;
                }
                if (j == matrix[i].length-1 && i != 0 && i != matrix.length && i % 2 ==0){
                    matrix[i][j] = 0x2563;
                    continue;
                }
                if (i !=matrix.length - 1 && i != 0 && i % 2 == 0 && j == 0){
                    matrix[i][j] = 0x2560;
                    continue;
                }
                if (j == 0 && i != 0 && j != matrix.length -1 || j == matrix[i].length -1 && i != 0 && j != matrix.length -1){
                    matrix[i][j] = 0x2551;
                    continue;
                }
                if (i % 2 == 0 && j % 10 != 0 && j != 0 && j != matrix[i].length){
                    matrix[i][j] = 0x2550;
                    continue;
                }
                if (i % 2 != 0 && j % 10 == 0 && j != 0 && j != matrix[i].length){
                    matrix[i][j] = 0x2551;
                    continue;
                }
            }
        }
        int ac = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 != 0 && (j - 1) % 10 == 0){
                    if(ac<A.length){
                        System.out.printf("%s(%2d)=%3d",name, ac, A[ac]);
                        ac++;
                    }
                    else {
                        System.out.print("         ");
                    }
                }
                if (j % 10 == 0 && i % 2 != 0 || i % 2 == 0) {
                    System.out.print(matrix[i][j]);
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 20;
        double[] A1 = new double[n];
        fillArray(A1, n);
        System.out.println("Массив А[]");
        for (int i = 0; i < n; i++) {
            System.out.printf("    A[%2d] = %g", i, A1[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
        System.out.println();
        double[] B1 = newArray(A1);
        System.out.println("Массив B[] из элементов массива А > 3.5");
        for (int i = 0; i < B1.length; i++) {
            System.out.printf("    B[%2d] = %g", i, B1[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
        double pr = B1[0]; // произведение всех элементов массива В1
        for (int i = 1; i < B1.length; i++) {
            pr *= B1[i];
        }
        double sr = pow(pr, 1.0 / B1.length); //среднее геометрическое членов массива B1
        System.out.println(sr);
        //_____________________________________________________________________________
        long[] A = new long[31];
        for (int i = 0; i < A.length; i++) {
            A[i] = round((random() * 347 + 103));
        }
        int size2=0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] * 0.1 > i) size2++;
        }
        long[] B = new long[size2];
        int counter = 0;
        for (int i = 0; i < size2; i++) {
            if(A[i] * 0.1 > i) {
                B[counter] = A[i];
                counter++;
            }
        }
        sort(B);
        System.out.println("Massiv A");
        printtable(A, 8, "A");
        System.out.println("Massiv B");
        printtable(B, 3, "B");
    }

}