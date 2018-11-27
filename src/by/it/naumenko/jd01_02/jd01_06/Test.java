package by.it.naumenko.jd01_02.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = "Повседневная? практика\n показывает. Что постоянный< количественный\n рост9 и сфера! Нашей активности: обеспечивает; широкому кругу специалистов участие в формировании систем массового участия. Равным образом постоянный количественный! рост и сфера нашей активности позволяет оценить значение позиций, занимаемых участниками в отношении поставленных задач.";
        //String text = new String(Poem.text);
       String[] wordArray = text.split("[.!?]");

        for (int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i].toString());
        }
        System.out.println(wordArray[1]);
        StringBuilder textSB=new StringBuilder(text);
        StringBuilder[] sbArray = new StringBuilder[wordArray.length];
        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i]=new StringBuilder(wordArray[i]);
        }

        System.out.println("-----------------------------------");
        for (int i = 0; i < sbArray.length; i++) {
            System.out.println(sbArray[i].toString());
        }
        //System.out.println(textSB);
        //Pattern pattern = Pattern.compile("^[^аоэиуыеёюя].*[аоэиуыеёюя]$");
        //Pattern pattern = Pattern.compile("^[^аоэиуыеёюяАОЭИУЫЕЁЮЯ][а-яё]+[аоэиуыеёюя]$");
        Pattern pattern = Pattern.compile("[^А-Яа-яЁё]");
        for (StringBuilder v : sbArray) {
            Matcher matcher = pattern.matcher(v);
            while (matcher.find()){
                int position=matcher.start();
                v.setCharAt(position,' ');
            }
        }
        System.out.println("-----------------------------------");
        for (int i = 0; i < sbArray.length; i++) {
            System.out.println(sbArray[i].toString());
        }


//        System.out.println(textSB.toString());

        //System.out.println(text);
//        int col = 0;
//        for (String word : wordArray) {
//            Matcher matcher = pattern.matcher(word);
//            if (matcher.find()) {
//                System.out.println(word);
//                col++;
//            }
//        }
        //System.out.println(col);
    }
}
