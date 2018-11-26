package by.it.nickgrudnitsky.jd01_05;

import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {
        task_c1();
        task_c2();
    }

    private static void task_c2() {
        int[] array = generateArray();
        int[] newArray = generateNewArray(array);
        printArray(array);
        printNewArray(newArray);
    }

    private static void printNewArray(int[] newArray) {
        System.out.println("Massiv B <index to cols>");
        System.out.print("╔═════════════╦═════════════╦═════════════╦═════════════╦═════════════╗\n");
        double delta = Math.ceil(newArray.length / 5.0);
        double delta2 = newArray.length - 4 * delta;
        for (int i1 = 0; i1 < delta2; i1++) {
            int i = i1;
            while (i < delta * 5) {
                System.out.printf("║ B[%2d]=%3.1f  ", i, newArray[i] * 0.1);
                i += delta;
            }
            System.out.println("║");
            if (i1 == (int) delta - 1) {
                System.out.println("╚═════════════╩═════════════╩═════════════╩═════════════╩═════════════╝");
                break;
            }
            System.out.println("╠═════════════╬═════════════╬═════════════╬═════════════╬═════════════╣");
        }
        for (int i1 = (int) delta2; i1 < (int) delta; i1++) {
            int i = i1;
            while (i <= delta * 4) {
                System.out.printf("║ B[%2d]=%3.1f  ", i, newArray[i] * 0.1);
                i += delta;
            }
            System.out.println("║             ║");
            if (i1 == (int) delta - 1) {
                System.out.println("╚═════════════╩═════════════╩═════════════╩═════════════╩═════════════╝");
                break;
            }
            System.out.println("╠═════════════╬═════════════╬═════════════╬═════════════╬═════════════╣");
        }
    }

    private static void printArray(int[] array) {
        System.out.println("Massiv A <index to rows>");
        System.out.print("╔═════════════╦═════════════╦═════════════╦═════════════╦═════════════╗\n");
        for (int i = 0; i < array.length; i++) {
            if (i % 5 == 0 && i != 0) {
                System.out.println("║");
                System.out.println("╠═════════════╬═════════════╬═════════════╬═════════════╬═════════════╣");
            }
            System.out.printf("║ A[%2d]=%3.1f  ", i, array[i] * 0.1);
        }
        System.out.println("║             ║             ║             ║             ║");
        System.out.println("╚═════════════╩═════════════╩═════════════╩═════════════╩═════════════╝");
    }

    private static int[] generateNewArray(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                index++;
            }
        }
        int[] newArray = new int[index];
        int i1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                newArray[i1] = array[i];
                i1++;
            }
        }
        sort(newArray);
        return newArray;
    }

    private static void sort(int[] array) {
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
        } while (swap);
    }

    private static int[] generateArray() {
        int[] array = new int[31];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (random() * 348 + 103);
        }
        return array;
    }

    private static void task_c1() {
        double[] array = getArray();
        double[] newArray = getNewArray(array);
        double mul = 1.0;
        for (double v : newArray) {
            mul *= v;
        }
        System.out.printf("Srednee geometr = %10.8e\n", mul / newArray.length);
    }

    private static double[] getNewArray(double[] array) {
        int indexOfElement = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 3.5) {
                indexOfElement = i;
                break;
            }
        }
        double[] newArray = new double[array.length - indexOfElement];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[indexOfElement + i];
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.printf("A[ %-2d] = %7.5f     ", i, newArray[i]);
        }
        return newArray;
    }

    private static double[] getArray() {
        double[] array = new double[(int) (random() * 21 + 20)];
        double z;
        int index = 0;
        for (double x = 5.33; x <= 9; x += (9 - 5.33) / array.length) {
            if (index == array.length) {
                break;
            }
            z = pow(pow(x, 2) + 4.5, 1 / 3.0);
            array[index] = z;
            if (index % 5 == 0) {
                System.out.println();
            }
            System.out.printf("A[ %-2d] = %7.5f     ", index, array[index]);
            index++;

        }
        System.out.println();
        return array;
    }
}
