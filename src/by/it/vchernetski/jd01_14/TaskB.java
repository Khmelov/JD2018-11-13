package by.it.vchernetski.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static int countwords;//количество слов
    private static int countsigns;//количество знаков
    private static String getText(String filename){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader rd = new BufferedReader(new FileReader(Util.getPath(filename)))) {
            while(rd.ready())
                sb.append(rd.readLine()+"\n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static void writeFile() {
        try (PrintWriter wr = new PrintWriter(new FileWriter(Util.getPath("resultTaskB.txt")))) {
            wr.print("words="+countwords+"\nmarks="+countsigns);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countWords(String tetx){
        Matcher m = Pattern.compile("[\\p{Punct}]+").matcher(tetx);
        while(m.find()){
            countsigns++;
        }
    }
    private static void countSign(String tetx){
        Matcher m = Pattern.compile("[А-яЁё]+").matcher(tetx);
        while(m.find()){
            countwords++;
        }
    }
    public static void main(String[] args) {
        String text = getText("text.txt");
        countSign(text);
        countWords(text);
        writeFile();
        System.out.println("words="+countwords);
        System.out.println("marks="+countsigns);
    }
}
