package by.it.naumenko.jd01_02.jd01_03;

import java.util.Random;

public class RannerB {
    public static void main(String[] args) {
        double[] mas=new double[10];
        Random rnd = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i]=rnd.nextInt(10)-5;
        }
        System.out.println("Исходный массив");
        for (double element:mas) {
            System.out.print(element+" ");
        }
        System.out.println();
        System.out.println(Helper.findMax(mas));
        System.out.println(Helper.findMin(mas));
        Helper.sort(mas);
    }
}
