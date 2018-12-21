package by.it.skarpovich.jd01_15;

import javafx.concurrent.Task;

import java.io.*;

public class TaskA {
    public static void main(String[] args)  {

        String clDir = TaskA.class.getName().replace(TaskA.class.getSimpleName(), "").replace(".", File.separator);
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + clDir;
        int[][] matrix = new int[6][4];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = -15 + (int) ((Math.random() * 31));
            }
        }
        try (PrintWriter prw = new PrintWriter(new FileWriter(path + "matrix.txt"))) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    prw.printf("%3d%s", matrix[i][j], " ");
                    //System.out.printf("%3d", matrix[i][j]);
                }
                // System.out.println();
                prw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(path + "matrix.txt"))) {
           StringBuilder sbuilder=new StringBuilder(); //Реализация через StringBuilder.
            while (bfr.ready()) {
                //String str = bfr.readLine(); //Реализация через String
                //System.out.println(str);
                sbuilder.append(bfr.readLine()).append("\n");
            }   System.out.println(sbuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
