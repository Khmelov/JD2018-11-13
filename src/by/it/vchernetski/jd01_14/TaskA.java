package by.it.vchernetski.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static void main(String[] args) throws IOException {
        String filename = Util.getPath("dataTaskA.bin");
        List<Integer> list = new ArrayList<>();
        writeIntegers(filename);
        readIntegers(filename, list);
        calcIntegers(list);
    }

    private static void calcIntegers(List<Integer> list) throws IOException {
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

    private static void readIntegers(String filename, List<Integer> list) throws IOException {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)
                ))) {
            while (dis.available() > 0) {
                list.add(dis.readInt());
            }
        }
    }

    private static void writeIntegers(String filename) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream(filename);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                DataOutputStream dos = new DataOutputStream(bos)
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        }
    }


}
