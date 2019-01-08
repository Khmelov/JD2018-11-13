package by.it.evenchik.jd01_14;
import java.io.*;
import java.util.Scanner;

public class TaskA {


    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;

        System.out.println("PATH----"+path);
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        System.out.println("clDir--------"+clDir);
        System.out.println("path + clDir--------- "+path+clDir);
        return path + clDir;


    }

    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin"))) ;
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20));

            }
            System.out.println("dos------"+dos);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }

        }


        try(DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
            PrintWriter out2= new PrintWriter(
                    new FileWriter(dir(TaskA.class)+"resultTaskA.txt")
            );



        ){
            double sum = 0;
            double count=0;
            while (inp.available()>0 ) {
                int i = inp.readInt();
                System.out.print(i+" ");
                out2.print( i +" ");
                sum = sum + i;
                count++;
            }
            System.out.println("\n avg="+sum/count );
            System.out.println("\navg" +sum/count);

        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }

}