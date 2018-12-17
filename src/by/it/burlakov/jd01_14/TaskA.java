package by.it.burlakov.jd01_14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static void main(String[] args) throws IOException {
        String filename = Util.getPath("dataTaskA.bin" , false);
        List<Integer> list = new ArrayList<>();
        //write integers
        writeIntegers(filename);
        //read integers
        readIntegers(filename, list);
        //calc
        calcIntegers(list);
    }

    private static void calcIntegers(List<Integer> list) throws IOException {
        try (PrintWriter out=new PrintWriter(
                new FileWriter(Util.getPath("resultTaskA.txt", false))
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