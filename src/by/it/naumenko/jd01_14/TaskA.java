package by.it.naumenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        String name = "dataTaskA.bin";//имя файла в котором зоздаются числа
        String fileName = dir(TaskA.class) + name;
        writeFile(fileName); //создать файл для записи
        inputFile(list, fileName); //открыть файл для чтения
        calcAvg(list); //посчитать среднее арифметическое
    }

    private static void writeFile(String fileName) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName)))
        ) {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt((int) (Math.random() * 20));
            }
        }
    }

    private static void inputFile(List<Integer> list, String fileName) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName )
                )
        )
        ) {
            while (dataInputStream.available() > 0) {

                list.add(dataInputStream.readInt());
            }
        }
    }

    private static void calcAvg(List<Integer> list) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))
        ) {
            double summa = 0;
            for (Integer element : list) {
                System.out.print(element + " ");
                summa += element;
                printWriter.print(element + " ");
            }
            System.out.println("\navg=" + summa / list.size());
            printWriter.print("\navg=" + summa / list.size());
        }
    }
}

