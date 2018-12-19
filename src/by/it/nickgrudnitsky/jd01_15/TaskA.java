package by.it.nickgrudnitsky.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        writeMatrix();
        readMatrix();
    }

    private static void readMatrix() {
        try (BufferedReader in = new BufferedReader(
                new FileReader(Util.getPath("matrix.txt"
                ))
        )) {
            while (in.ready()) {
                System.out.println(in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeMatrix() {
        int[][] arr = new int[6][4];
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[0].length; i1++) {
                arr[i][i1] = (int) (Math.random() * 31 - 15);
            }
        }
        try (PrintWriter out = new PrintWriter(
                new FileWriter(Util.getPath("matrix.txt"))
        )) {
            for (int[] row : arr) {
                for (int element : row) {
                    out.printf(" %3d", element);
                }
                out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
