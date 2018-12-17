package by.it.mnovikov.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by user on 15.12.2018.
 */
public class TaskA {
    public static void main(String[] args) {
        int[][] arr = new int[6][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] =-15+(int) (Math.random()*31);
            }
        }

        try (PrintWriter out = new PrintWriter(new FileWriter("matrix.txt"))){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
