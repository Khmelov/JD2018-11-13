package by.it.baidak.jd01_14;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(new File(Util.getPath(),"text.txt"));
        FileWriter fw = new FileWriter(new File(Util.getPath(),"resultTaskB.txt"));
        StringBuilder sb = new StringBuilder();

        int codepoint;
        while ((codepoint = fr.read()) != -1) sb.append((char)codepoint);
        String txt = sb.toString();

        sb.delete(0,sb.length());
        sb.append("words=" + countUp(txt, Patterns.WORDS) + ", ");
        sb.append("marks=" + countUp(txt, Patterns.PUNCT));
        System.out.println(sb);

        fw.append(sb); fr.close(); fw.close();
    }

    private static int countUp(String txt, String regEx){
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(txt);
        int counter = 0;
        while (m.find()) counter++;
        return counter;
    }
}
