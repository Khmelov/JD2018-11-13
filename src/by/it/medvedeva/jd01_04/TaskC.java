package by.it.medvedeva.jd01_04;

import java.util.Scanner;

public class TaskC {
    private static void buildOneDimArray(String line){
        double [] array=InOut.getArray(line);
        InOut.printArray(array, "V",5);
        double first=array[0];
        double last=array[array.length-1];



        InOut.printArray(array, "V",4);
        for (int i = 0; i <array.length; i++) {
            if (array[i] == first){
                System.out.printf("Index of first element=%d\n", i);
                break;
            }

        }
        for (int i = 0; i <array.length ; i++) {
            if (array[i] == last){
                System.out.printf("Index of last element=%d\n", i);
                break;
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String s= scanner.nextLine();
        buildOneDimArray(s);
    }
}
