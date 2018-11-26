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
            //System.out.println(s2);//выводим результат

        }
        System.out.println("Ожидается:\n" +
                "Там королевич мимоходом Пленяет грозного царя\n" +
                "Там ступа с Бабою Ягой Идёт бредёт сама собой\n" +
                "У лукоморья дуб зелёный Златая цепь на дубе том\n" +
                "Идёт направо песнь заводит Налево сказку говорит\n" +
                "Там на неведомых дорожках Следы невиданных зверей\n" +
                "И днём и ночью кот учёный Всё ходит по цепи кругом\n" +
                "Там чудеса там леший бродит Русалка на ветвях сидит\n" +
                "Избушка там на курьих ножках Стоит без окон без дверей\n" +
                "В темнице там царевна тужит А бурый волк ей верно служит\n" +
                "Там в облаках перед народом Через леса через моря Колдун несёт богатыря\n" +
                "Там лес и дол видений полны Там о заре прихлынут волны На брег песчаный и пустой И тридцать витязей прекрасных Чредой из вод выходят ясных И с ними дядька их морской\n" +
                "Там царь Кащей над златом чахнет Там русский дух\n" +
                "там Русью пахнет И там я был и мёд я пил У моря видел дуб зелёный Под ним сидел и кот учёный Свои мне сказки говорил\n");
    }
}






