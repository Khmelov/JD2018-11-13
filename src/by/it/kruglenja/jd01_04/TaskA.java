package by.it.kruglenja.jd01_04;
import java.util.Scanner;
import by.it.kruglenja.jd01_03.InOut;
import by.it.kruglenja.jd01_03.Helper;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMulTable();
        String s =scanner.nextLine();
        buildOneDimArray(s);
    }
    private static void printMulTable(){
        for (int i = 2; i <= 9 ; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf(i + "*" + j + "=%-2d ",j*i);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];

        InOut.printArray(array, "V", 4);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        for (int i = 0; i < array.length; i++) {
            if (first == array[i])
                System.out.println("first element=" + i);
        }
        for (int i = 0; i < array.length; i++) {
            if (last == array[i])
                System.out.println("last element=" + i);
        }

    }
}
