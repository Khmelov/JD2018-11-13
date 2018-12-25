package by.it.karnilava.jd01_15;

import java.io.*;
import java.math.*;
import java.util.Random;

public class TaskA {
    private static int[][] mas;
    static DataOutputStream dos1 = null;

    public static void main(String[] args) throws IOException {


        String src = System.getProperty("user.dir") + "/src/by/it/karnilava/";
        String filename = src + "jd01_15/matrix.txt";
        File f1 = new File(filename);
        f1.getParentFile().mkdirs();
        f1.createNewFile();


        try {
            dos1 = new DataOutputStream(new FileOutputStream(f1));
            mas = new int[6][4];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    mas[i][j] = new Random().nextInt(31) - 15;

                    // System.out.printf("%-3s", mas[i][j] + " ");
                    System.out.printf("%3d%1s", mas[i][j]," ");
                    dos1.writeBytes(String.format("%3d%1s", mas[i][j]," "));
                }
                System.out.println();
                dos1.writeBytes("\n");


            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } finally {
            if (dos1 != null) {
                dos1.close();
            }


//
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String res = bufferedReader.readLine();

        while (res != null) {
            System.out.println(res);
            res = bufferedReader.readLine();
        }


    }
}
