package by.it.kruglenja.jd01_15;

import java.io.*;
import java.util.List;

import static java.lang.System.out;

public class TaskA {

    private static void writer(int[][] matrix, String fileName) {

        try (PrintWriter out = new PrintWriter(
                new FileWriter(fileName))) {
            for (int[] rows : matrix) {
                for (int cols : rows) {
                    out.printf("%3d ", cols);
                }
                out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reader(String fileName) {

        try (BufferedReader in = new BufferedReader(
                new FileReader(fileName))) {
            while (in.ready()){
                System.out.println(in.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String fileName = Util.getPath("TaskB.txt");
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 31) - 15;
            }
        }
        writer(matrix, fileName);
        reader(fileName);
    }
}

