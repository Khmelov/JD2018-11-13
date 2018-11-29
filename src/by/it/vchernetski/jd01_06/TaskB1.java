package by.it.vchernetski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static void check(String[] words){
        char[] sl = {'Б', 'б', 'В', 'в', 'Г', 'г', 'Д', 'д', 'Ж', 'ж', 'З', 'з','Й', 'й', 'К', 'к', 'Л', 'л', 'М', 'м', 'Н',
                'н', 'П', 'п', 'Р', 'р', 'С', 'с', 'Т', 'т', 'Ф', 'ф', 'Х', 'х', 'Ц', 'ц', 'Ч', 'ч', 'Ш', 'ш', 'Щ', 'щ'};
        char[] gl = {'а','е','ё','и','о','у','ы','э','ю','я'};
        for (int i = 0; i < words.length; i++) {
            char ch;
            for (int j = 0; j < sl.length; j++) {
                ch=words[i].charAt(0);
                if(ch  == sl[j]){
                    System.out.println(i + " " + "ok "+  words[i]);
                    break;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            char ch;
            for (int j = 0; j < sl.length; j++) {
                ch=words[i].charAt(words[i].length()-1);
                if(ch  == gl[j]){
                    System.out.println(i + " "+"ok "+  words[i]);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        String[] words = new String[0];
        StringBuilder sd = new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[\\p{Punct}|\\s]+");
        Matcher m1 = p1.matcher(sd);
        int counter = 0;
        int[] mas = new int[300];
        while(m1.find()){
            mas[counter++] = m1.end();
        }
        counter=0;
        for (int i = 0; i < mas.length; i++) {
            sd.insert(mas[i]+counter++,' ');
            if(mas[i+1]==0) break;
        }
        Pattern p = Pattern.compile("\\s[БбВвГгДдЖжЗзЙйКкЛлМмНнПпРрСсТтФфХхЦцЧчШшЩщ][а-яА-ЯёЁ]*[аеёиоуыэюя][\\p{Punct}|\\s]");
        Matcher m = p.matcher(sd);
        while (m.find()){
            String[] temp = new String[words.length+1];
            System.arraycopy(words,0,temp,0,words.length);
            String str = m.group();
            str=str.trim();
            Pattern p0=Pattern.compile("\\p{Punct}+");
            Matcher m0 = p0.matcher(str);
            if(m0.find())
                str=str.substring(0,m0.start());
            temp[words.length]=str;
            words=temp;
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        check(words);
    }
}
