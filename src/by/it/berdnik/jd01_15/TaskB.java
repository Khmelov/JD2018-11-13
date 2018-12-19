package by.it.berdnik.jd01_15;

import java.io.*;

public class TaskB {

    /**
     * * bla - bla
     **/

    /*
   B
   u
   eeeeee
        */

    // other comment

    public static void main(String[] args) {
        String file = System.getProperty("user.dir") + "\\src\\" + TaskB.class.getName().replace(".", File.separator);
        String fileIn = file + ".java";
        String fileOut = file + ".txt";
        StringBuilder convert = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileIn))) {
            Boolean comOne = false;
            Boolean comTwo = false;
            String chars = "";

            // text

            while (reader.ready()) {
                if (reader.ready()) {
                    char currchar = (char) reader.read();
                    chars = chars + currchar;

                    if (chars.equals("/" + "*")) {
                        comOne = true;
                        comTwo = true;
                        convert.deleteCharAt(convert.length() - 1);
                    }

                    if (chars.equals("/" + "/")) {
                        comOne = true;
                        comTwo = false;
                        convert.deleteCharAt(convert.length() - 1);
                    }

                    // text

                    if (!comOne) {
                        convert.append(chars.substring(chars.length() - 1));
                    }

                    if (chars.equals("\r\n") && comOne && !comTwo) {
                        comOne = false;
                        comTwo = false;
                        convert.append(chars);
                    }

                    if (chars.equals("*" + "/") && comOne && comTwo) {
                        comOne = false;
                        comTwo = false;
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
