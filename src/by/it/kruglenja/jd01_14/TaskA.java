package by.it.kruglenja.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 13.12.2018.
 */
public class TaskA {
    public static void main(String[] args) throws Exception {

        String fileName = Util.getPath("dataTaskA.bin");
        List<Integer> arr = new ArrayList<>();
        writer(fileName);
        reader(fileName, arr);
        avgCalc(arr);
    }

    private static void writer(String fileName) throws Exception {
        try (
                FileOutputStream fOs = new FileOutputStream(fileName);
                BufferedOutputStream bos = new BufferedOutputStream(fOs);
                DataOutputStream dos = new DataOutputStream(bos)
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        }
    }

    private static void reader(String fileName, List<Integer> arr) throws Exception {
        try (DataInputStream dataInput = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)))) {
            while (dataInput.available() > 0) {
                arr.add(dataInput.readInt());
            }
        }
    }

    private static void avgCalc(List<Integer> arr) throws Exception {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(Util.getPath("resultTaskA.txt")))) {
            double res = 0;
            for (Integer element : arr) {
                System.out.print(element + " ");
                printWriter.print(element + " ");
                res += element;
            }
            System.out.println("\navg=" + res / arr.size());
            printWriter.print("\navg=" + res / arr.size());
        }
    }
}
