package by.it.karnilava.jd01_15;

import java.io.*;

public class TaskB {

    static DataOutputStream dos1 = null;

    public static void main(String[] args) throws IOException {

        //Это одинострочный комментарий номер два
        String src = System.getProperty("user.dir") + "/src/by/it/karnilava/";
        String filename = src + "jd01_15/TaskB.java";
        //Это одинострочный комментарий номер два

        /*Это.
        многострочный.комментарийномер один*/
        StringBuilder sb = new StringBuilder();
        String filenameofNewFile = src + "jd01_15/TaskB.txt";
        File f1 = new File(filenameofNewFile);
        f1.getParentFile().mkdirs();
        f1.createNewFile();

        try {
            dos1 = new DataOutputStream(new FileOutputStream(f1));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String res = bufferedReader.readLine();

            while (res != null) {

                if (res.contains("/" + "**") && !res.contains("contains")) {
                    while (!res.contains("*" + "/")) {
                        res = bufferedReader.readLine();
                    }
                    res = bufferedReader.readLine();
                    continue;
                }

                if (res.contains("/" + "*") && !res.contains("contains")) {
                    while (!res.contains("*" + "/")) {
                        res = bufferedReader.readLine();
                    }
                    res = bufferedReader.readLine();
                    continue;
                }

                if (res.contains("/" + "/") && !res.contains("contains")) {
                    res = bufferedReader.readLine();
                    continue;
                }
                sb.append(res).append("\n");
                res = bufferedReader.readLine();
            }
            System.out.println(sb);
            dos1.writeBytes(sb.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        finally {
            if (dos1 != null) {
                dos1.close();
            }
        }
        /*Это.
       OOOOOO многострочный.OOO комментарий
               OOOOOOO номер два
               */
        /**
         * @author Natallia Karnilava
         * @version 1.0
         */
    }
}