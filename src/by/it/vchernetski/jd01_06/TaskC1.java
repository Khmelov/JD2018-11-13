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
            if(i!=mas.length-1) mas[i].append("\n");
        }
    }
    public static void main(String[] args) {
        StringBuilder[] mymas = getmas();
        redmas(mymas);
        StringBuilder[] mymas1 = new StringBuilder[mymas.length];
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
//        for (int i = 0; i < mymas1.length; i++) {
//            if(mymas[i].equals(mymas1[i])){
//                System.out.print(mymas[i]);
//                System.out.print(mymas1[i]);
//            }
//        }

        for (int i = 0; i < mymas.length; i++) {
            System.out.print(mymas1[i].toString());
        }
    }
}
