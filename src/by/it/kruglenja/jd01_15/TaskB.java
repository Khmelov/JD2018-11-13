package by.it.kruglenja.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskB {
    StringBuilder sb = new StringBuilder();
    /**/
    private static void writer(String fileName) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(fileName))) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) { // комментарий 1
            e.printStackTrace();
        }
    }






    private static void txtFileReader(String fileName) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(fileName))) {
          while (in.ready()) {
              boolean isCommentary = false;
              // комментарий 2
                System.out.println(in.readLine());
                while (in.ready()){
                    System.out.println(in.read());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String fileName = Util.getPath("TaskB.txt");
        txtFileReader(fileName);
        /**Жавадок
         * коментарий
         */
//        writer(fileName);

    }
}
