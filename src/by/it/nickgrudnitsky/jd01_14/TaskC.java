package by.it.nickgrudnitsky.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {
    public static void main(String[] args) throws IOException {
        try (FileWriter wrtr = new FileWriter(Util.getPath("resultTaskC.txt"));
             BufferedWriter bwrtr = new BufferedWriter(wrtr)) {
            String dirPath = "/IT-Academy/JD2018-11-13/src/by/it/nickgrudnitsky";
            File manePackage = new File(dirPath);
            File[] packages = manePackage.listFiles();
            if (packages != null) {
                for (File task : packages) {
                    if (task.getName().equals(".DS_Store")) continue;
                    bwrtr.write("dir:" + task.getName() + "\n");
                    System.out.println("dir:" + task.getName());
                    File[] files = task.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            bwrtr.write("file:" + file.getName() + "\n");
                            System.out.println("file:" + file.getName());
                        }
                    }
                }
            }
        }
    }
}
