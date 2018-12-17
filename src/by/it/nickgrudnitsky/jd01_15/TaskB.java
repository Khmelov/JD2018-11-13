
package by.it.nickgrudnitsky.jd01_15;

import java.io.*;

public class TaskB {
    /*
comment
 */
//comment
//comment

    /**
     * comment
     */
/*
comment
comment
 */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        readAndClean(sb);
        write(sb);
    }

    private static void write(StringBuilder sb) {
        try (PrintWriter in = new PrintWriter(
                new FileWriter(Util.getPath("TaskB.txt")))) {
            in.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndClean(StringBuilder sb) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(Util.getPath("TaskB.java")))) {
            while (in.ready()) {
                char read1 = (char) in.read();
                if (read1 == '/') {
                    char read2 = (char) in.read();
                    if (read2 == '/') {
                        while (in.ready()) {
                            char read5 = (char) in.read();
                            if (read5 == '\n') {
                                sb.append(read5);
                                break;
                            }
                        }
                    } else {
                        if (read2 == '*') {
                            while (in.ready()) {
                                if ((char) in.read() == '*') {
                                    char read3 = (char) in.read();
                                    if (read3 == '/') {
                                        char read4 = (char) in.read();
                                        if (read4 == '\n') {
                                            sb.append(read4);
                                            break;
                                        }
                                    }
                                }
                            }
                            continue;
                        }
                    }
                    if (read2 != '/') {
                        sb.append(read1);
                        sb.append(read2);
                    }
                } else {
                    sb.append(read1);
                }
            }
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
