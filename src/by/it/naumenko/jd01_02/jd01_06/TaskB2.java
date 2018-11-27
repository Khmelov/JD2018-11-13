package by.it.naumenko.jd01_02.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] sortStr(String[] mas) {
        String s;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i].length() < mas[j].length()) { //&&(mas[i].length()!=0||mas[j].length()!=0)){
                    s = mas[i];
                    mas[i] = mas[j];
                    mas[j] = s;

                }
            }
        }
        return mas;
    }

    public static void main(String[] args) {
        //String text = "Повседневная? практика показывает. Что постоянный< количественный рост9 и сфера! Нашей активности: обеспечивает; широкому кругу специалистов участие в формировании систем массового участия. Равным образом постоянный количественный! рост и сфера нашей активности позволяет оценить значение позиций, занимаемых участниками в отношении поставленных задач.";
        String text = new String(Poem.text);
        String[] wordArray = text.split("[.?]");

//        for (int i = 0; i < wordArray.length; i++) {
//            System.out.println(wordArray[i]);
//        }
        //System.out.println(wordArray[0]);
        StringBuilder textSB = new StringBuilder(text);
        StringBuilder[] sbArray = new StringBuilder[wordArray.length-2];
        int k = 0;
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i].length() != 0) {
                sbArray[k] = new StringBuilder(wordArray[i]);
                k++;
            }
        }

//        System.out.println("-----------------------------------");
//        for (int i = 0; i < sbArray.length; i++) {
//            System.out.println(sbArray[i].toString());
//        }
        //System.out.println(textSB);
        //Pattern pattern = Pattern.compile("^[^аоэиуыеёюя].*[аоэиуыеёюя]$");
        //Pattern pattern = Pattern.compile("^[^аоэиуыеёюяАОЭИУЫЕЁЮЯ][а-яё]+[аоэиуыеёюя]$");
        Pattern pattern = Pattern.compile("[^А-Яа-яЁё]");
        //Pattern pattern = Pattern.compile("[^А-Яа-яЁё][\\s{1,}\\.{2,}]");
        for (StringBuilder v : sbArray) {
            Matcher matcher = pattern.matcher(v);
            while (matcher.find()){
                int position=matcher.start();
                v.setCharAt(position,' ');
//                if (matcher.group(2).length()>2)
//                   v.setCharAt(position+1,' ');
            }
        }

//        Pattern pattern2 = Pattern.compile("^\\s{1}.*");
//        for (StringBuilder v : sbArray) {
//            Matcher matcher = pattern2.matcher(v);
//            while (matcher.find()){
//                int position=matcher.start();
//                //v.setCharAt(position,'@');
//                v.deleteCharAt(position);
//            }
//        }
//
//        Pattern pattern3 = Pattern.compile("[\\s{1,}\\.{2,}]");
//        for (StringBuilder v : sbArray) {
//            Matcher matcher = pattern3.matcher(v);
//            while (matcher.find()){
//                int position=matcher.start();
//                v.delete(position,position+1);
//
//            }
//        }




//

//        Pattern pattern3 = Pattern.compile("\\s{2,}");
//        for (StringBuilder v : sbArray) {
//            Matcher matcher = pattern3.matcher(v);
//            while (matcher.find()){
//                int position=matcher.start();
//                v.setCharAt(position,'@');
//                //v.delete(position,position);
//                //v.deleteCharAt(position);
////                if (matcher.group().length()>2)
////                    v.setCharAt(position+1,'@');
//                    //v.deleteCharAt(position+1);
//                //v.deleteCharAt(position);
//            }
//        }
//        System.out.println("-----------------------------------");
//        for (int i = 0; i < sbArray.length; i++) {
//            System.out.println(sbArray[i].toString());
//        }

        String[] array  = new String[sbArray.length];
        for (int i = 0; i < sbArray.length; i++) {
            array[i]=sbArray[i].toString();
        }
        System.out.println("--------------------отсортированный--------------------");
        sortStr(array);
        String[] mas2= new String[array.length+1];
        for (int i = 0; i < array.length; i++) {
            mas2[i]=array[i];
        }
        for (int i = 0; i < mas2.length; i++) {
            if (mas2[i]==null)
                mas2[i]="";
        }
        for (String s : mas2) {
            System.out.printf("%s    %d\n",s,s.length());
        }

    }
}
