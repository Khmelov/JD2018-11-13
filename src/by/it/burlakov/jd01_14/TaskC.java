package by.it.burlakov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskC {

    private static  ArrayList<String> cat = new ArrayList<>();

    public static void main(String[] args) {

        String pathWrite = Util.getPath("resultTaskC.txt",false);
        String path = Util.getPath("\\by\\it\\burlakov",true);
        System.out.println(path);

        createCatalog(path);
        printToConsole(cat);

        try {
            printToFile(cat, pathWrite);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void printToFile(List<?> list, String path) throws IOException {

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            for (Object str : list){
                out.println(str);
            }
        }
    }

    private static void printToConsole(List<?> list) {
        for (Object str : list){
            System.out.println(str);
        }
    }

    private static void createCatalog(String path) {

        File dir = new File(path);
        File[] files = dir.listFiles();

        if (dir.isFile()) {
            cat.add("file:" + dir.getName());
        } else if (dir.isDirectory()) {
            cat.add("dir:" + dir.getName());
            if (files != null) {
                for (File file : files) {
                    createCatalog(file.getAbsolutePath());
                }
            }
        }
    }
}