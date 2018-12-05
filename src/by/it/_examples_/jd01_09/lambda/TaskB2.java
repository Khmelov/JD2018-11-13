package by.it._examples_.jd01_09.lambda;

import java.util.Arrays;
import java.util.Comparator;

class TaskB2 {

    public static void main(String[] args) {
        String[] sentences = Poem.text.split("[.!?]\n");
        for (int i = 0; i < sentences.length; i++)
            sentences[i]=sentences[i].replaceAll("[^А-Яа-яёЁ]+", " ");

        Comparator<String> comparator1=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
        Comparator<String> comparator2= (o1, o2) -> o1.length()-o2.length();

        Arrays.sort(sentences,comparator1);                             //способ 1

        Arrays.sort(sentences,comparator2);                             //способ 2
        Arrays.sort(sentences, (o1, o2) -> o1.length()-o2.length());    //способ 3

        Arrays.sort(sentences, Comparator.comparingInt(String::length));//способ 4

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
