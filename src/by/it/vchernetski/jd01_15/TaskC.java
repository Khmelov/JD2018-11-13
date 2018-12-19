package by.it.vchernetski.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    public static Path path = Paths.get(Util.getPath());
    private static void parser(String command) throws IOException {
        command.trim();
        Matcher mcd = Pattern.compile("^cd[ ]+.+").matcher(command);
        if(mcd.find()){
            cd(command);
        }
        else if(command.equals("dir")){
            dir();
        }
        else System.out.println("command didn't find");
    }
    private static void cd(String command){
        Path temp;
        command=command.replaceAll("^cd[ ]+","");
        while(true) {
            Matcher m1 = Pattern.compile("^[A-z]:.+").matcher(command);
            if (m1.find()) {
                temp = Paths.get(command);
                File tempf = temp.toFile();
                if (tempf.exists()) {
                    path = temp;
                    System.out.println(path.toString());
                }
                else System.out.println("Direcrtory doesn't exist");
                break;
            }
            m1 = Pattern.compile("\\.\\.").matcher(command);
            if (m1.find()) {
                path = path.getParent();
                System.out.println(path.toString());
                break;
            }
            m1 = Pattern.compile(".+").matcher(command);
            if(m1.find()){
                path = Paths.get(path.toString()+"\\"+command);
                File tempf = path.toFile();
                if(tempf.exists()) System.out.println(path.toString());
                else System.out.println("Direcrtory doesn't exist");
                break;
            }
        }
    }
    private static void dir () throws IOException {
        File temp = path.toFile();
        int sumdir = 2;
        int sumfiles = 0;
        int sumlenth=0;
        File temp1 =path.getParent().toFile();
        BasicFileAttributes view0 = Files.getFileAttributeView(path, BasicFileAttributeView.class).readAttributes();
        FileTime creationTime0=view0.creationTime();
        System.out.print(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(creationTime0.toMillis()));
        if(temp.isDirectory()) System.out.println("\t\t<Dir>\t\t\t.");
        BasicFileAttributes view1 = Files.getFileAttributeView(path.getParent(), BasicFileAttributeView.class).readAttributes();
        FileTime creationTime1=view1.creationTime();
        System.out.print(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(creationTime1.toMillis()));
        if(temp.isDirectory()) System.out.println("\t\t<Dir>\t\t\t..");
        File[] list = temp.listFiles();
        for (File f:list) {
            Path tempp = Paths.get(f.getAbsolutePath());
            BasicFileAttributes view = Files.getFileAttributeView(tempp, BasicFileAttributeView.class).readAttributes();
            FileTime creationTime=view.creationTime();
//            System.out.print(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(creationTime.toMillis()));
            System.out.printf("%s\t",new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(creationTime.toMillis()));
            if(f.isDirectory()) {
                System.out.print("\t<Dir>\t");
                sumdir++;
            }
            else {
                System.out.print("\t\t\t");
                sumfiles++;
            }
            System.out.printf("%5d %s\n",f.length(),f.getName());
            sumlenth+=f.length();
        }
        if(sumfiles>0) {
            System.out.print("\t\t\t\t" + sumfiles + " файлов");
            System.out.println("\t\t" + sumlenth);
        }
        if (sumdir>0){
            System.out.print("\t\t\t\t"+sumdir + " папок");
        }
        System.out.println(" "+temp.getFreeSpace()+ " свободно");
    }
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            String command;
            while (!((command = in.readLine()).equals("end"))) {
                parser(command);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
