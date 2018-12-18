package by.it.skarpovich.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    static String dir(Class<?> cl) {
        String mypath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "skarpovich" + File.separator;


        return mypath;
    }

    public static void main(String[] args) {
        File folder = new File(dir(TaskC.class));
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isDirectory()) {
            System.out.println("dir:" + listOfFiles[i].getName());
        } else if (listOfFiles[i].isFile()) {
                System.out.println("file:"+ listOfFiles[i].getName());

            }
        }
    }
}