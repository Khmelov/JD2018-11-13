package by.it.nickgrudnitsky.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    public static void main(String[] args) throws IOException {
        String catalog = Util.getPath("");
        Scanner scanner = new Scanner(System.in);
        String line;
        File file = new File(catalog);
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            Matcher mcd = Pattern.compile("^cd[ ]+.+").matcher(line);
            if (mcd.find()) {
                if (line.substring(3).equals("..")) {
                    file = file.getParentFile();
                    System.out.println(file.getPath());
                } else {
                    file = new File(file.getPath() + "/" + line.substring(3));
                    System.out.println(file.getPath());
                }
            }
            if (line.equals("cd")) {
                System.out.println(file.getPath());
            }
            if (line.equals("dir")) {
                getAtributs(file);
            }
        }
    }


    private static void getAtributs(File file) throws IOException {
        File[] files = file.listFiles();
        int foldersNumber = 0;
        int filesNumber = 0;
        long filesSize = 0;
        long foldersSizeAvailable = 0;
        System.out.println("          Содержимое папки " + file.getPath() + "\n");
        if (files != null) {
            for (File file1 : files) {
                if (file1.isFile()) {
                    Path p = Paths.get(file1.getPath());
                    Object creationTime = Files.getAttribute(p, "creationTime", LinkOption.NOFOLLOW_LINKS);
                    System.out.printf("%s         %8d %s\n", creationTime, file1.length(), p.getFileName());
                    filesSize += file1.length();
                    filesNumber++;
                } else {
                    if (file1.isDirectory()) {
                        Path p = Paths.get(file1.getPath());
                        Object creationTime = Files.getAttribute(p, "creationTime", LinkOption.NOFOLLOW_LINKS);
                        System.out.printf("%s    <DIR>         %s\n", creationTime, file1.getName());
                        foldersSizeAvailable += file1.getFreeSpace();
                        foldersNumber++;
                    }
                }
            }
        }
        System.out.printf("                  %d файлов %10d байт\n", filesNumber, filesSize);
        System.out.printf("                  %d папок%12d байт свободно\n", foldersNumber, foldersSizeAvailable);
    }
}
