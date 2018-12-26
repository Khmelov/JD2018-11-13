package by.it.karnilava.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA {
    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/karnilava/";
        String filename = src + "jd01_14/dataTaskA.bin";
        File f = new File(filename);
        f.getParentFile().mkdirs();
        f.createNewFile();
        List<Integer> arrlst = new ArrayList<>(20);
        Double avg = null;



        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*20+10));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } finally {
            if (dos != null) {
                dos.close();
            }
        }

        try (DataInputStream inp = new DataInputStream(new BufferedInputStream
                (new FileInputStream(filename)))){

            while (inp.available()>0){
                arrlst.add(inp.readInt());

            }

            Iterator<Integer> iter = arrlst.iterator();
            while (iter.hasNext()){
                System.out.print(iter.next());
                if (iter.hasNext()) {
                    System.out.print(" ");
                }
            }
            int sum = 0;
            iter = arrlst.iterator();
            while (iter.hasNext()){
                sum=sum+iter.next();
            }
             avg=sum/20.0;
            System.out.println();
            System.out.println("avg="+avg);

        }
        catch (IOException e){
            e.printStackTrace();
        }

        String filename1 = src + "jd01_14/resultTaskA.txt";
        File f1 = new File(filename1);
        f1.getParentFile().mkdirs();
        f1.createNewFile();

        DataOutputStream dos1 = null;
        try {
            dos1 = new DataOutputStream(new FileOutputStream(f1));

            Iterator<Integer> iter = arrlst.iterator();
            while (iter.hasNext()){
                dos1.writeBytes(iter.next().toString());
                if (iter.hasNext()) {
                    dos1.writeBytes(" ");
                }

            }
           dos1.writeBytes("\n");
            dos1.writeBytes("avg="+avg);


        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename1);
        } finally {
            if (dos1 != null) {
                dos1.close();
            }
        }
    }
}
