package by.it.nickgrudnitsky.jd01_14;

import java.io.*;


public class TaskA {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(Util.getPath("dataTaskA.bin"))));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 101));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        int sum = 0;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(Util.getPath("dataTaskA.bin"))))) {
            while (dis.available() > 0) {
                i = dis.readInt();
                System.out.println(i);
                sum += i;
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

