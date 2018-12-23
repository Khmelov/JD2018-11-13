package by.it.karnilava.jd01_15;

import java.io.*;

public class TaskB {

    static DataOutputStream dos1 = null;

    public static void main(String[] args) throws IOException {

        //Указываем путь к классу с кодом
        String src = System.getProperty("user.dir") + "/src/by/it/karnilava/";
        String filename = src + "jd01_15/TaskB.java";
        File f = new File(filename);


        /*Создаем стрингбилдер для записи в файл текста кода;
         Создаем новый новый текстовый файл*/
        StringBuilder sb = new StringBuilder();
        String filenameofNewFile = src + "jd01_15/TaskB.txt";
        File f1 = new File(filenameofNewFile);
        f1.getParentFile().mkdirs();
        f1.createNewFile();


        int b;
        FileReader is = null;


        try {

            dos1 = new DataOutputStream(new FileOutputStream(f1));
            is = new FileReader(f);

            while ((b = is.read()) != -1) { //пока не закончится программа надо делать:

                if ((char) b == '/') {
                    int q = is.read();
                    //Условия для однострочного комментария
                    if ((char) q == '/') {
                        while ((char) b != '\n') {
                            b = is.read();
                        }
                        sb.append("\n");
                        continue;
                    }
                    if ((char) q != '*') {
                        sb.append((char) b);
                        sb.append((char) q);
                        continue;
                    }
                    if ((char) q == '*') { /*условия начала
                    игнорирования комментария или джавадока*/

                        while ((char) b != '*') {
                            b = is.read();
                        }

                        while ((char) q != '/') {
                            q = is.read();
                        }
                        b = is.read();


                    }


                }


                sb.append((char) b);


            }
            System.out.println(sb);
            dos1.writeBytes(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } finally {
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

