package by.it.nickgrudnitsky.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        checkRule();
    }

    private static void checkRule() {
        Pattern pattern = Pattern.compile("[йцкнгшщзхъждлрпвфячсмтьбЙЦКНГШЩЗХЪЖДЛРПВФЧМТЬБС]+[а-яА-ЯёЁ]*[уеёэоаыяиюУЕЁЭОАЫЯИЮ]+[ ;:,.!?\\n]");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
