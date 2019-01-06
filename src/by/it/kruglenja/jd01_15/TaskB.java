package by.it.kruglenja.jd01_15;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        /*123
         *456*/

        try (BufferedReader in = new BufferedReader(
                new FileReader(Util.getPath("TaskB.java")))) {
            boolean multiStringCommentary = false;
            char temp = '?';
            while (in.ready()) {// комментарий 2
                char c = (char) in.read();

                if (c == '/') {
                    temp = c;// комментарий 3
                    //123456
                    c = (char) in.read();
                    /**123
                     *456*/
                    if (c == '/') {
                        while (c != '\n') {
                            c = (char) in.read();// комментарий 4
                        }
                    } else if (c == '*') {
                        multiStringCommentary = true;
                        while (multiStringCommentary) {
                            c = (char) in.read();
                            if (c == '/') {
                                multiStringCommentary = false;
                                c = (char) in.read();
                            }
                        }
                        /*123
                         *456*/
                    } else {
                        sb.append(temp);
                    }
                }
                sb.append(c);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            /**123
             *456*/
        } catch (IOException e) {
            //sdfsdf
            e.printStackTrace();
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(Util.getPath("TaskB.txt")))) {
            out.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
