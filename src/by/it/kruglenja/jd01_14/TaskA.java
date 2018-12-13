package by.it.kruglenja.jd01_14;

import java.io.*;

/**
 * Created by user on 13.12.2018.
 */
public class TaskA {
    public static void main(String[] args) {
        String fileName = Util.getPath("dataTaskA.bin");
        try {
            FileOutputStream fOs = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fOs);
            DataOutputStream dos = new DataOutputStream(bos);
            {}
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 100));
            }
        } catch (Exception e) {
            System.out.println("Error " + fileName + " inpput");
        }
    }
}
