package by.it.markelov.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        Class<TaskB> taskAClass = TaskB.class;
        Package aPackage = taskAClass.getPackage();//пакет
        String namePackage = aPackage.getName();//имя пакета
        String pathPackage = namePackage.replaceAll("\\.", "\\\\");//замена точек на \

        String property = System.getProperty("user.dir");//путь к папке проекта

        File file = new File(property + File.separator + "src" + File.separator + pathPackage + File.separator + "TaskB.txt");//объект класса File для файла
        File file2 = new File(property + File.separator + "src" + File.separator + pathPackage + File.separator + "resultTaskB.txt");//объект класса File для файла


        int countPuncts = 0;
        int countWords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            StringBuilder sb = new StringBuilder();
            while (br.ready()) {
                s = br.readLine();
                sb.append(s).append(" ");
            }
            String s1 = sb.toString();
            s1 = s1.trim().replaceAll("[\\n.,;:!?-]", "");
            s1 = s1.replaceAll("  ", " ");

            String[] words = s1.split(" ");
            countWords = words.length;
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader br1 = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new PrintWriter(file2))) {
            while (br1.ready()) {
                char c = (char) br1.read();
                if (c == '.' || c == ',' || c == ':' || c == ';' || c == '!' || c == '?') {
                    countPuncts++;
                }
            }
            System.out.println("words=" + countWords + ", punctuation marks=" + countPuncts);
            bw.write("words=" + countWords + ", punctuation marks=" + countPuncts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}