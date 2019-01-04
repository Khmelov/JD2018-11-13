package by.it.malishevskiy.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 31) - 15;
            }
        }

        // Write file
        String part1 = System.getProperty("user.dir");
        String part2 = "/src/by/it/malishevskiy/jd01_15/matrix.txt";
        Path path = Paths.get(part1, part2);
        try (PrintWriter pw = new PrintWriter(new FileWriter(path.toString()))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    pw.format("%3d ", matrix[i][j]);
                }
                pw.println();
            }
        } catch (IOException e) {
            System.err.format("Ошибка записи файла %s%n", path);
        }
        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.format("Ошибка чтения файла %s%n", path);
        }

    }
}