package by.it.vchernetski.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static StringBuilder[] getmas(){
        StringBuilder sb=new StringBuilder(Poem.text);
        StringBuilder[] mas = new StringBuilder[0];
        Matcher m = Pattern.compile(".+\\n").matcher(Poem.text);
        int i=0;
        while(m.find()){
            StringBuilder[] temp = new StringBuilder[mas.length+1];
            System.arraycopy(mas,0,temp,0,mas.length);
            temp[mas.length] = new StringBuilder(m.group().trim());
            mas = temp;
            i=m.end();
        }
        System.out.println();
        String str = sb.substring(i);
        StringBuilder[] masfin = new StringBuilder[mas.length+1];
        System.arraycopy(mas,0,masfin,0,mas.length);
        masfin[mas.length] = new StringBuilder(str);
        return masfin;
    }
    private static  void redmas(StringBuilder[] mas){
        int maxln=0; //максимальная длина
        for (int i = 0; i < mas.length; i++) {
            if(mas[i].length()>maxln) maxln=mas[i].length();
        }
        for (int i = 0; i < mas.length; i++) {
            while(true){
                Matcher m = Pattern.compile("[А-яё|\\p{Punct}] ").matcher(mas[i]);
                int x = mas[i].length();
                while(m.find()){
                    if(mas[i].length()==maxln)
                        break;
                    mas[i].insert(m.end()," ");
                }
                if(mas[i].length()==maxln)
                    break;
            }
            mas[i].append("\n");
        }
    }
    public static void main(String[] args) {
        StringBuilder[] mymas;
        mymas = getmas();
        redmas(mymas);
        int o = mymas[1].length();
        for (int i = 0; i < mymas.length; i++) {
            System.out.println(mymas[i].toString());
        }
    }
}
