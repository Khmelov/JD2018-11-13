package by.it.kovalyova.jd01_15;

/**
 * javadoc comment
 */

import java.io.*;

//simple comment
//else


public class TaskB {
/*
multi
line
comment
 */
    public static void main(String[] args) {
        String filename = System.getProperty("user.dir") + "\\src\\" + TaskB.class.getName().replace(".", File.separator);
        String fname_in = filename + ".java";
        String fname_out = filename + ".txt";
        StringBuilder src = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fname_in))) {
            Boolean incomment = false;
            Boolean mcomment = false;
            String twochars = "";
            while (reader.ready()) {
                if (reader.ready()) {
                    char currchar = (char) reader.read();
                    twochars = twochars+currchar;
                    if (twochars.equals("/"+"*")) {
                        incomment = true;
                        mcomment = true;
                        src.deleteCharAt(src.length()-1);
                    }
                    if (twochars.equals("/"+"/")) {
                        incomment = true;
                        mcomment = false;
                        src.deleteCharAt(src.length()-1);
                    }

                    if (!incomment) {
                        src.append(twochars.substring(twochars.length()-1));
                    }
                    if (twochars.equals("\r\n") && incomment && !mcomment) {
                        incomment = false;
                        mcomment = false;
                        src.append(twochars);
                    }
                    if (twochars.equals("*"+"/") && incomment && mcomment) {
                        incomment = false;
                        mcomment = false;
                    }
                    twochars = Character.toString(currchar);
                }

            }

            PrintWriter out = new PrintWriter(new FileWriter(fname_out));
            System.out.print(src);
            out.print(src);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
over
 */