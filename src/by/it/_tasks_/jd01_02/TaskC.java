package by.it._task_.jd01_02;


import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        step1(n);
    }

    private static void step1(int l){
        Random random = new Random();
        int[][]mas;
       // l = (int)(l);

        mas = new int[l][l];
        int i, z, k  = 0 ;

            for (i = 0; i < l ; i++) {
                for (z = 0; z < l ; z++) {
                    if(mas [i][z] != l & mas [i][z] != -l){
                        mas [i][z] = Rgen.getRandomIntegerBetweenRange((l*(-1)),l);
                    }
            }
        }


        for (i = 0; i < l ; i++) {
            for (z = 0; z < l ; z++)
                System.out.print(mas[i][z] + " ");
            System.out.println();

        }



    }

    private static void step2(){

    }
    private static void step3(){

    }
}
