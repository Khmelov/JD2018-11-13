package by.it.baidak.jd01_06;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("[а-яА-яёЁ]{2,}");
        Matcher m = p.matcher(Poem.text);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group());
        }
        for (String word : list) {
            if(!checkVow(word.charAt(0))){
                if (checkVow(word.charAt(word.length() - 1))){
                    System.out.println(word);
                }
            }
        }
    }

    private static boolean checkVow (char c){
        switch (c) {
            case 'А':
            case 'а':
            case 'Е':
            case 'е':
            case 'Ё':
            case 'ё':
            case 'И':
            case 'и':
            case 'О':
            case 'о':
            case 'У':
            case 'у':
            case 'Ы':
            case 'ы':
            case 'Э':
            case 'э':
            case 'Ю':
            case 'ю':
            case 'Я':
            case 'я':return true;
            default: return false;
        }
    }
}
