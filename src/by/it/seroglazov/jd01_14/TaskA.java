package by.it.seroglazov.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskA {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            writeFile();
            list = readFile();
            printListAndAver(list);
            printListAndAverToFile(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    private static ArrayList<Integer> readFile() throws IOException {
        File tarf = getTargetFile("dataTaskA.bin");
        ArrayList<Integer> list = new ArrayList<>();
        try (DataInputStream stream = new DataInputStream(new BufferedInputStream(new FileInputStream(tarf)))) {
            while (stream.available() > 0){
                list.add(stream.readInt());
            }
        }
        return list;
    }

    private static void printListAndAver(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(x -> sb.append(x).append(' '));
        System.out.println(sb);
        int sum = 0;
        for (Integer x : list) sum += x;
        double aver = (double) sum / list.size();
        System.out.println("avg=" + aver);
    }

    private static void printListAndAverToFile(ArrayList<Integer> list) throws IOException {
        File tarf = getTargetFile("resultTaskA.txt");
        try (BufferedWriter stream = new BufferedWriter(new FileWriter(tarf))) {

            for (Integer x : list) {
                stream.write(String.valueOf(x));
                stream.write(' ');
            }
            stream.newLine();
            int sum = 0;
            for (Integer x : list) sum += x;
            double aver = (double) sum / list.size();
            stream.write("avg=" + String.valueOf(aver));
        }
    }

    private static void writeFile() throws IOException {
        File tarf = getTargetFile("dataTaskA.bin");
        try (DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tarf)))){

            for (int i = 0; i < 20; i++) {
                int a = (int) (Math.random()*100);
                stream.writeInt(a);
            }
        }
    }

    static File getTargetFile(String name) {
        File projDir = new File("");
        String path = projDir.getAbsolutePath();
        String pack = TaskA.class.getName();
        pack = pack.replaceAll("\\.", "/");
        String classPath = path + "/src/" + pack;
        File classDir = new File(classPath).getParentFile();
        String fullName = classDir + "/" + name;
        return new File(fullName);
    }
}
