package by.it._examples_.jd01_14;

import java.io.*;

public class Class02_IO_Int {
    public static void main(String[ ] args) throws IOException {
        String src=System.getProperty("user.dir")+"/src/by/it/_examples_/jd01_14/";
        String filename = src+"integer.dat";
        File f=new File(filename);
        //=============================================================
        //пример записи значений типа int в двоичный файл
        DataOutputStream dos = null;
        try {
            dos=new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                    dos.writeInt((int)(Math.random()*20+10));
                    }
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + filename);
        }
        finally {
            if (dos!=null) {dos.close();}
        }
        //=============================================================
        //пример чтения из файла
        try (DataInputStream inp=new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename))
                )
            )
        {
            double sum=0;
            double count=0;
            while (inp.available()>0) {
                int i=inp.readInt();
                sum=sum+i;
                count++;
            }
            System.out.println("Average=" + sum / count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
