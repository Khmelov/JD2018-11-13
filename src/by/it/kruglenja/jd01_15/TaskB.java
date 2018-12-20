package by.it.kruglenja.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskB {
    static StringBuilder sb = new StringBuilder();

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
                char c = (char) in.read();
                if (c == '/' && isCommentary){
                    continue;
                }
                if (c == '/'){
                    isCommentary = true;
                }
                if (c != '/' && !isCommentary) {
                    sb.append(c);
                }

            }
            System.out.println(sb.toString());
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
