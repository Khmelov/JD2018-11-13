package by.it.seroglazov.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        String start = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd01_15";
        File curDirF = new File(start);
        Scanner sc = new Scanner(System.in);
        String cmd;

        while (true) {
            System.out.print(curDirF.toString());
            System.out.print('>');
            cmd = sc.nextLine();
            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("dir")) {
                dir(curDirF);
            } else if (cmd.equals("cd ..")) {
                File newFile = curDirF.getParentFile();
                if (newFile != null) {
                    curDirF = newFile;
                }
            } else if (cmd.startsWith("cd ") && cmd.length() > 3) {
                String sub = cmd.substring(3);
                String s = curDirF.toString() + '/' + sub;
                File newFile = new File(s);
                if (newFile.isDirectory()) {
                    curDirF = newFile;
                } else {
                    System.err.println("Папка "+sub + " не найдена.");
                }

            }
        }
    }

    static void dir(File curDirF) {
        File[] files = curDirF.listFiles();
        if (files != null) {
            System.out.println();
            int fileCount = 0;
            int dirCount = 0;
            long totalSize = 0;
            for (File file : files) {
                try {
                    BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    // Time
                    long millis = attr.creationTime().toMillis();
                    SimpleDateFormat date = new SimpleDateFormat("MM.dd.yyyy");
                    SimpleDateFormat time = new SimpleDateFormat("HH:mm");
                    String dateStr = date.format(millis);
                    String timeStr = time.format(millis);
                    System.out.print(dateStr);
                    System.out.print(' ');
                    System.out.print(timeStr);

                    if (file.isDirectory()) {
                        System.out.print("    <DIR>         ");
                        dirCount++;
                    } else {
                        System.out.format("%,18d", attr.size());
                        fileCount++;
                        totalSize += attr.size();
                    }
                    System.out.print(' ');
                    System.out.println(file.getName());

                } catch (IOException e) {
                    System.err.println("Ошибка чтения атрибутов файла/папки " + file.getName());
                }
            }
            System.out.format("%16d файлов", fileCount);
            System.out.format("%,16d байт%n", totalSize);
            System.out.format("%16d папок ", dirCount);
            System.out.format("%,16d байт свободно%n", curDirF.getFreeSpace());
            System.out.println();
        }
    }
}
