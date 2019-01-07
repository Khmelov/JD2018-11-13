package by.it.denisova.jd01_15;

import java.io.*;

public class TaskB {

    /**
     * * bla - bla
     **/

    /*
   B
   u
   fjjfodjfkl
        */

    // other comment

    public static void main(String[] args) {
        String file = System.getProperty("user.dir") + "\\src\\" + TaskB.class.getName().replace(".", File.separator);
        String fileIn = file + ".java";
        String fileOut = file + ".txt";
        StringBuilder convert = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileIn))) {
            Boolean commentOne = false;
            Boolean commentTwo = false;
            String chars = "";

            // text

            while (reader.ready()) {
                if (reader.ready()) {
                    char currchar = (char) reader.read();
                    chars = chars + currchar;

                    if (chars.equals("/" + "*")) {
                        commentOne = true;
                        commentTwo = true;
                        convert.deleteCharAt(convert.length() - 1);
                    }

                    if (chars.equals("/" + "/")) {
                        commentOne = true;
                        commentTwo = false;
                        convert.deleteCharAt(convert.length() - 1);
                    }

                    // text

                    if (!commentOne) {
                        convert.append(chars.substring(chars.length() - 1));
                    }

                    if (chars.equals("\r\n") && commentOne && !commentTwo) {
                        commentOne = false;
                        commentTwo = false;
                        convert.append(chars);
                    }

                    if (chars.equals("*" + "/") && commentOne && commentTwo) {
                        commentOne = false;
                        commentTwo = false;
                    }
                    chars = Character.toString(currchar);
                }

                /*
may be the end
 */
            }
            PrintWriter out = new PrintWriter(new FileWriter(fileOut));
            System.out.print(convert);
            out.print(convert);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
            // the end!
        }
    }
}