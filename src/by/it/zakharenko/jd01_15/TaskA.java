package by.it.zakharenko.jd01_15;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {
        String filename = Util.getPath("matrix.txt");
        int[][] array = new int[6][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = -15 + (int) (Math.random() * 31);
            }
        }
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(filename))) {
            for (int[] row : array) {
                for (int elem : row) {
                    writer.printf("%3d ",  elem);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
