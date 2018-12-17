package by.it.lobkova.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    public static void main(String[] args) throws Exception {
        String filename = Util.getPath("dataTaskA.bin");
        ArrayList<Integer> list = new ArrayList<>();
        writeNumbers(filename);
        readInArray(filename, list);
        calcIntegers(list);
    }

    private static void writeNumbers(String filename) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);
        for (int i = 0; i < 20; i++) {
            dos.writeInt((int) Math.random() * 100);
        }
    }

    private static void readInArray(String file, ArrayList<Integer> arrayList) throws Exception {
        try (DataInputStream fis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                ))) {
            while (fis.available() > 0) {
                arrayList.add(fis.readInt());
            }
        }
    }

    private static void calcIntegers(ArrayList<Integer> list) throws IOException {
        try (PrintWriter out=new PrintWriter(
                new FileWriter(Util.getPath("resultTaskA.txt"))
        )){
            double sum = 0;
            for (Integer element : list) {
                System.out.print(element + " ");
                out.print(element + " ");
                sum += element;
            }
            System.out.println("\navg=" + sum / list.size());
            out.println("\navg=" + sum / list.size());
        }
    }

}
