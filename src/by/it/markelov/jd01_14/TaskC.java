package by.it.markelov.jd01_14;

import java.io.*;

public class TaskC {
    public static void main(String[] args) {
        Class<TaskC> taskCClass = TaskC.class;
        Package aPackage = taskCClass.getPackage();//пакет
        String namePackage = aPackage.getName();//имя пакета
        String pathPackage = namePackage.replaceAll("\\.", "\\\\");//замена точек на \

        String property = System.getProperty("user.dir");

        File path = new File(property + File.separator + "src" + File.separator + pathPackage + File.separator + "resultTaskC.txt");

//ШАГ 1
        File file = new File(property);
        File[] files = file.listFiles();//папку выгружаем в массив
        for (File element : files) {//пребираем папки
            if (element.getAbsolutePath().endsWith("src")) {//фильтруем папки по окончанию их абсол. пути
                file = element;//ссылаемся на эту папку
            }
        }
//АНАЛОГИЧНО ШАГ 2
        files = file.listFiles();
        for (File element : files) {
            if (element.getAbsolutePath().endsWith("by")) {
                file = element;
            }
        }
//АНАЛОГИЧНО ШАГ 3
        files = file.listFiles();
        for (File element : files) {
            if (element.getAbsolutePath().endsWith("it")) {
                file = element;
            }
        }
//АНАЛОГИЧНО ШАГ 4
        files = file.listFiles();
        for (File element : files) {
            if (element.getAbsolutePath().endsWith("markelov")) {
                file = element;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new PrintWriter(path))) {
            files = file.listFiles();//папку "markelov" выгружаем в массив
            for (File element : files) {//перебираем его
                if (element.isFile())//если элемент папки "markelov"-файл, выводим его имя на печать
                    System.out.println("file:" + element.getName());
                else if (element.isDirectory()) {//если элемент папки "markelov"-папка, выводим ее имя на печать
                    System.out.println("dir:" + element.getName());
                    bw.write("dir:" + element.getName() + "\n");

                    File[] files1 = element.listFiles();//и эту папку выгружаем в массив и повторяем с ней весь цикл операций
                    for (File file1 : files1) {
                        if (file1.isFile()) {
                            System.out.println("file:" + file1.getName());
                            bw.write("file:" + file1.getName() + "\n");
                        } else if (file1.isDirectory()) {
                            System.out.println("dir:" + file1.getName());
                            bw.write("dir:" + file1.getName() + "\n");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

