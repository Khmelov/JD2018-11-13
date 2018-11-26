package by.it.vchernetski.jd01_06;

import javax.print.DocFlavor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] lines = Poem.text.split("\n");
        StringBuilder[] lb = new StringBuilder[lines.length];
        for (int i = 0; i < lines.length; i++) {
            lb[i] = new StringBuilder(lines[i]);
        }
        int maxlen = 0;
        for (int i = 0; i <lines.length; i++) {
            if(lines[i].length()>maxlen) maxlen = lines[i].length();
        }
        for (int i = 0; i < lb.length; i++) {
            while(true){
                Matcher m = Pattern.compile("[А-яё|\\p{Punct}] ").matcher(lb[i]);
                if(lb[i].length() == maxlen) break;
                while(m.find()){
                    if(lb[i].length() == maxlen) break;
                    lb[i].insert(m.end(),' ');
                }
            }
        }
        for (int i = 0; i < lb.length-1; i++) {
            lb[i].append("\n");
        }
        StringBuilder[] mymas1 = new StringBuilder[lb.length];
        mymas1[0] = new StringBuilder("У     лукоморья     дуб     зелёный,\n");
        mymas1[1] = new StringBuilder("Златая    цепь    на    дубе    том.\n");
        mymas1[2] = new StringBuilder("И    днём   и   ночью   кот   учёный\n");
        mymas1[3] = new StringBuilder("Всё    ходит    по    цепи   кругом.\n");
        mymas1[4] = new StringBuilder("Идёт   направо   -   песнь  заводит,\n");
        mymas1[5] = new StringBuilder("Налево     -     сказку     говорит.\n");
        mymas1[6] = new StringBuilder("Там   чудеса:   там   леший  бродит,\n");
        mymas1[7] = new StringBuilder("Русалка     на     ветвях     сидит.\n");
        mymas1[8] = new StringBuilder("Там     на     неведомых    дорожках\n");
        mymas1[9] = new StringBuilder("Следы       невиданных       зверей.\n");
        mymas1[10] = new StringBuilder("Избушка   там   на   курьих   ножках\n");
        mymas1[11] = new StringBuilder("Стоит    без   окон,   без   дверей.\n");
        mymas1[12] = new StringBuilder("Там   лес   и   дол  видений  полны,\n");
        mymas1[13] = new StringBuilder("Там    о    заре   прихлынут   волны\n");
        mymas1[14] = new StringBuilder("На    брег    песчаный   и   пустой,\n");
        mymas1[15] = new StringBuilder("И    тридцать   витязей   прекрасных\n");
        mymas1[16] = new StringBuilder("Чредой   из   вод   выходят   ясных,\n");
        mymas1[17] = new StringBuilder("И   с   ними   дядька   их  морской.\n");
        mymas1[18] = new StringBuilder("Там        королевич       мимоходом\n");
        mymas1[19] = new StringBuilder("Пленяет        грозного        царя.\n");
        mymas1[20] = new StringBuilder("Там    в   облаках   перед   народом\n");
        mymas1[21] = new StringBuilder("Через      леса,      через     моря\n");
        mymas1[22] = new StringBuilder("Колдун        несёт        богатыря.\n");
        mymas1[23] = new StringBuilder("В   темнице   там   царевна   тужит,\n");
        mymas1[24] = new StringBuilder("А   бурый   волк  ей  верно  служит.\n");
        mymas1[25] = new StringBuilder("Там     ступа     с    Бабою    Ягой\n");
        mymas1[26] = new StringBuilder("Идёт,     бредёт     сама     собой.\n");
        mymas1[27] = new StringBuilder("Там  царь  Кащей  над златом чахнет,\n");
        mymas1[28] = new StringBuilder("Там русский дух... там Русью пахнет!\n");
        mymas1[29] = new StringBuilder("И   там   я   был,   и  мёд  я  пил,\n");
        mymas1[30] = new StringBuilder("У    моря    видел    дуб   зелёный,\n");
        mymas1[31] = new StringBuilder("Под   ним   сидел,   и   кот  учёный\n");
        mymas1[32] = new StringBuilder("Свои     мне     сказки     говорил.");
        String [] mas1 = new String[lb.length];
        String [] mas2 = new String[mymas1.length];
        for (int i = 0; i < lb.length; i++) {
            mas1[i]=lb[i].toString();
            mas2[i]=mymas1[i].toString();
        }
        for (int i = 0; i < mas1.length; i++) {
            if(mas2[i].equals(mas1[i]))
            System.out.println(i+"y");
            else System.out.println(i+"NOOOOOOOOOO");
        }
        System.out.println(mas1[29]);
        System.out.println(mas1[32]);
    }
}
