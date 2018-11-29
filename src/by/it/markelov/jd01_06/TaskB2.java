package by.it.markelov.jd01_06;

import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {

        String poemToLine = Poem.text.replaceAll("\n", " ");//меняем перенос строки на пробел
        String poemToLine2 = poemToLine.replaceAll("\\.\\.\\.", "");//удалаем многоточие
        //System.out.println(poemToLine2);//проверка

        Pattern pat = Pattern.compile("[\\.!]+");
        String[] sentences = pat.split(poemToLine2);//разбиваем поэму на предложения
        for (int i = 0; i < sentences.length; i++) {//убираем пробелы по краям
            String temp = sentences[i].trim();
            sentences[i] = temp;
        //System.out.println(sentences[i]);//проверка
        }

        for (int i = 0; i < sentences.length; i++) {//убираем лишние символы
            String temp = sentences[i].replaceAll("[,-:]", "");
            sentences[i] = temp;
        //System.out.println(sentences[i]);//проверка
        }

        for (int i = 0; i < sentences.length; i++) {//убираем лишние пробелы внутри предложений
            String temp = sentences[i].replaceAll(" {2,}", " ");
            sentences[i] = temp;
        //System.out.println(sentences[i]);//проверка
        }
        for (int i = 0; i < sentences.length; i++) {//сортируем массив возрастанию длины предложений
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[i].length() > sentences[j].length()) {
                    String temp = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = temp;
                }
            }
        }
        for (String sentence : sentences) {
            System.out.println(sentence);//выводим результат


        }
    }
}






