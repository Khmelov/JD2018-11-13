package by.it.nickgrudnitsky.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TaskA {
    public static void main(String[] args) throws IOException {
        String fileName = Util.getPath("dataTaskA.bin");
        List<Integer> list = new ArrayList<>();
        fileWriter(fileName);
        fileReader(fileName, list);
        calc(fileName, list);
    }

    private static void calc(String fileName, List<Integer> list) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(Util.getPath("resultTaskA.txt")))) {
            double sum = 0;
            for (Integer integer : list) {
                System.out.print(integer + " ");
                printWriter.print(integer + " ");
                sum += integer;

            }
            System.out.println("\navg=" + sum / list.size());
            printWriter.println("\navg=" + sum / list.size());
        }
    }

    private static void fileReader(String fileName, List<Integer> list) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream dis = new DataInputStream(bis)) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }

        }
    }

    private static void fileWriter(String fileName) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                DataOutputStream dos = new DataOutputStream(bos)) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }

        }
    }
}
