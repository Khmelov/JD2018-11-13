package by.it.markelov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {

        String poemToLine = Poem.text.replaceAll("\n", " ");//перенос строки меняем на пробел
        // String poemToLine2 = poemToLine.replaceAll("...", "");//многоточие удалаем
        //System.out.println(poemToLine);//проверка

        Pattern pat = Pattern.compile("[\\.!]+");
        String[] s = pat.split(poemToLine);//разбиваем на предложения
        for (int i = 0; i < s.length; i++) {//убираем пробелы по краям
            String trim = s[i].trim();
            s[i] = trim;
            //System.out.println(s[i]);//проверка
        }
        StringBuilder[] sb = new StringBuilder[s.length];
        for (int i = 0; i < s.length; i++) {
            sb[i] = new StringBuilder(s[i]);//превращаем в массив предложений StringBuilder
            //System.out.println(sb[i]);//проверка
        }

        pat = Pattern.compile("[,-:]");
        Matcher mat;
        for (int i = 0; i < sb.length; i++) {
            mat = pat.matcher(sb[i]);
            while (mat.find()) {
                sb[i].setCharAt(mat.start(), ' ');//убираем знаки препинания
            }
            //System.out.println(sb[i]);//проверка
        }

        String[] s1 = new String[sb.length];
        for (int i = 0; i < s1.length; i++) {
            s1[i] = new String(sb[i]);
            String s2 = s1[i].replaceAll("   ", " ");//убираем три пробела подряд
            s1[i] = s2;
            //System.out.println(s1[i]);
        }

        for (int i = 0; i < s1.length; i++) {
            String s3 = s1[i].replaceAll("  ", " ");//убираем два пробела подряд
            s1[i] = s3;
            //System.out.println(s1[i]);
        }

        for (int i = 0; i < s1.length; i++) {//сортируем массив
            for (int j = i + 1; j < s1.length; j++) {
                if (s1[i].length() > s1[j].length()) {
                    String temp = s1[i];
                    s1[i] = s1[j];
                    s1[j] = temp;
                }

            }

        }

        for (String s2 : s1) {
            System.out.println(s2);//выводим результат

        }
    }
}






