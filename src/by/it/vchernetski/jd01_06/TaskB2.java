package by.it.vchernetski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String[] mas = getStrmas(Poem.text);
        sortbylength(mas);
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]);
        }
    }

    private static String[] getStrmas(String text) {
        StringBuilder sd= new StringBuilder(text);
        Matcher m = Pattern.compile("[:А-яё\\s,!-]+([\\.]{3})?").matcher(sd);
        String[] sentences=new String[0];
        while(m.find()){
            String[] temp = new String[sentences.length+1];
            System.arraycopy(sentences,0,temp,0,sentences.length);
            String s = m.group();
            s=s.replaceAll("[\\s\\p{Punct}]+"," ");
            s=s.trim();
            temp[sentences.length]=s;
            sentences=temp;
        }
        return sentences;
    }
    private static void sortbylength(String[] mas){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas.length; j++) {
                if(mas[j].length()<mas[j-1].length()){
                    String temp=mas[j];
                    mas[j]=mas[j-1];
                    mas[j-1]=temp;
                }
            }
        }
    }
}
