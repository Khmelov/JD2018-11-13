package by.it.seroglazov.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TaskC {
    public static void main(String[] args) {
        File projDir = new File("");
        String path = projDir.getAbsolutePath();
        String pack = TaskC.class.getName();
        pack = pack.replaceAll("\\.", "/");
        String classPath = path + "/src/" + pack;
        File mydir = new File(classPath).getParentFile().getParentFile();
        ArrayList<String> files  = getAllFiles(mydir);
        files.forEach(System.out::println);
        File outf = TaskA.getTargetFile("resultTaskC.txt");
        writeToFile(outf, files);
    }

    static ArrayList<String> getAllFiles(File dir) {
        ArrayList<String> list = new ArrayList<>();
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                list.add("file:" + f.getName());
            } else if (f.isDirectory()) { // Избыточное?
                list.add("dir:" + f.getName());
                list.addAll(getAllFiles(f));
            }
        }
        return list;
    }

    static void writeToFile(File f, ArrayList<String> list) {
        try (BufferedWriter stream = new BufferedWriter(new FileWriter(f))) {
            for (String str : list) {
                stream.write(str);
                stream.newLine();
            }
        } catch (IOException e) {
            System.out.println("Не могу записать файл " + f.getAbsolutePath());
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
