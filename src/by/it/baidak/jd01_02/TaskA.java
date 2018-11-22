package by.it.baidak.jd01_02;

public class TaskA {

    static void step1(int[ ] mas){
        int min = mas[0]; int max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] < min) min = mas[i];
            if(mas[i] > max) max = mas[i];
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[ ] mas){
        double srednee = 0; int summ = 0;
        for (int i = 0; i < mas.length; i++) {
            summ += mas[i];
        }
        srednee = summ / mas.length;
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] < srednee) System.out.print(mas[i] + " ");
        }
    }

    static void step3(int[ ] mas){
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if(mas[i] < min) min = mas[i];
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if(mas[i] == min) System.out.print(i + " ");
        }
    }
}
