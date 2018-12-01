package by.it.naumenko.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n;
        n = x.nextInt();
        Random rnd = new Random();
        double[][] m = new double[n][n];
        double[][] m1 = new double[n - 1][n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = rnd.nextInt(n * 2 + 1) - n;
                ;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "    ");
            }
            System.out.println();
        }
        double max = m[0][0];
        int ind_i = 0;
        int ind_j = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                    ind_i=i;
                    ind_j=j;
                }
            }
            System.out.println();
        }
        System.out.println(ind_i+" "+ind_j);
        //int deli, delj;
        //deli = x.nextInt();
        //delj = x.nextInt();
        for (int i = 0, str = 0; str < m.length - 1; ) {
            if (i != ind_i) {
                for (int j = 0, stb = 0; stb < m.length - 1; j++, stb++) {
                    if (j == ind_j) j++;
                    m1[str][stb] = m[i][j];
                }
                i++;
                str++;
            } else i++;
        }
        //m = m1;
        for (int i = 0; i < m.length - 1; i++) {
            for (int j = 0; j < m.length - 1; j++) {
                System.out.print(m1[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
