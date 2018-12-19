package by.it.markelov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {

        Class<TaskA> taskAClass = TaskA.class;
        Package aPackage = taskAClass.getPackage();//пакет
        String namePackage = aPackage.getName();//имя пакета
        String pathPackage = namePackage.replaceAll("\\.", "\\\\");//замена точек на \

        String property = System.getProperty("user.dir");//путь к папке проекта

        File file = new File(property + File.separator + "src" + File.separator + pathPackage + File.separator + "dataTaskA.bin");//объект класса File для файла
        String absolutePath = file.getAbsolutePath();//путь к файлу

        List<Integer> list = new ArrayList<>();

        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {//запись байтов в файл
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 100);
                dos.writeInt(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {//чтение байтов из файла

            while (dis.available() > 0) {
                int value = dis.readInt();
                list.add(value);//сохраненние в дин. массив
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = 0;
        double sum = 0;
        for (Integer element : list) {
            System.out.print(element + " ");//вывод в консоль эл. массива
            count++;
            sum += element;
        }
        System.out.println("\navg=" + sum / count);//вывод ср. ариф.

        File file2 = new File(property + File.separator + "src" + File.separator + pathPackage + File.separator + "resultTaskA.txt");//новый файл
        try (PrintWriter pr = new PrintWriter(new FileWriter(file2))) {

            for (Integer element : list) {
                pr.print(element + " ");//запись чисел в файл
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

