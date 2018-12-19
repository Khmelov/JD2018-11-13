package by.it.mnovikov.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
//        String filename = Util.getPath("matrix.txt");

        int[][] arr = new int[6][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = -15 + (int)(Math.random() * 31);
            }
        }

        try (PrintWriter out = new PrintWriter(
                new FileWriter(Util.getPath("matrix.txt")))){
            for (int[] ints : arr) {
                for (int anInt : ints) {
                    out.printf("%3d ", anInt);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(
                new FileReader(Util.getPath("matrix.txt")))){
            while (in.ready()){
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}