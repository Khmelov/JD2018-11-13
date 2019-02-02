package by.it.zhivov.jd01_15;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        String line;


        String src = System.getProperty("user.dir") + "/src/by/it/zhivov/";
        String filename = src + "jd01_15";

        File catalog = new File(filename);


        System.out.println(catalog.getAbsolutePath());
        while (!(line = scan.nextLine()).equals("end")) {


            if (line.equals("cd ..")) {
                filename = catalog.getParent();
                catalog = new File(filename);
                System.out.println(catalog.getAbsolutePath());

            }

            else {
                if (line.contains("cd ")){
                    String name = line.replaceAll("cd ","");
                   String [] list = catalog.list();

                    assert list != null;
                    List <String> l =  Arrays.asList(list);
                    if (l.contains(name)) {
                        filename=src+name;
                        catalog= new File(filename);
                        System.out.println(catalog.getAbsolutePath());
                    }
                    else {
                        System.out.println("Ошибка! Введите другое имя каталога");
                        System.out.println(filename);
                    }
                }
            }

            if (line.equals("dir")) {
                System.out.println("Содержимое папки " + catalog.getName());
                searchFiles(catalog);
            }
        }
    }

    private static void searchFiles(File object)  {
        int countDirectories =0;
        int cointFiles = 0;


        System.out.printf("%-20s%-10s%n",object.getName()," <DIR> ");
        countDirectories++;
        File[] filesOfObject = object.listFiles();
        assert filesOfObject != null;
        for (File el : filesOfObject) {
            if (el.isDirectory()) {
                searchFiles(el);
            }
            if (el.isFile()) {
                System.out.printf("%-20s%-10s%n" ,el.getName()," <FILE> ");
                cointFiles++;
            }
        }
        System.out.println("Количество файлов: "+cointFiles);
        System.out.println("Количество папок: "+countDirectories);
    }
}
