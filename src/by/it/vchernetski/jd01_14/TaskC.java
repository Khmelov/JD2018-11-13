package by.it.vchernetski.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    private static ArrayList<String> dir = new ArrayList<>();
    private static ArrayList<String> files = new ArrayList<>();
    private static String finalpath;
    private static void getfullpath(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().equals("vchernetski")) {
                boolean test = true;
                File[] fmas = f.listFiles();
                for (File fm:fmas) {
                    File f1 =new File(fm.getAbsolutePath());
                    File[] f1mas = f1.listFiles();
                    for (File f1m:f1mas) {
                        Matcher m = Pattern.compile("[A-z]+\\.class").matcher(f1m.getName());
                        if(m.find()) {
                            test = false;
                            break;
                        }
                    }
                    if(!(test)) break;
                    else{
                        finalpath = f.getAbsolutePath();
                    }
                }
            } else if (f.isDirectory())
                getfullpath(path + "\\" + f.getName());
        }
    }
    private static void getdirandfiles(String path){
        File f = new File(path);
        File[] fmas = f.listFiles();
        for (File f1:fmas) {
            if(f1.isDirectory()){
                dir.add(f1.getName());
                getdirandfiles(f1.getAbsolutePath());
            }
            else{
                files.add(f1.getName());
            }
        }
    }
    public static void main(String[] args) {
        String path=System.getProperty("user.dir");
        getfullpath(path);
        try(PrintWriter wr = new PrintWriter(new FileWriter(Util.getPath("resultTaskC.txt")))){
            getdirandfiles(finalpath);
            for (String d:dir) {
                wr.print(d);
                System.out.println("dir:"+d);
            }
            for (String f:files) {
                wr.print(f);
                System.out.println("file:"+f);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
