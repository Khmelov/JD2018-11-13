package by.it.zakharenko.jd01_04;

public class Helper {
    public static double findMin(double[] arr) {
        double minVal = 0;
        for (double anArr : arr) {
            if (anArr < minVal) {
                minVal = anArr;
            }
        }
        System.out.println("minVal = " + minVal);
        System.out.println();
        return minVal;
    }

    public static double findMax(double[] arr) {
        double maxVal = 0;
        for (double anArr : arr) {
            if (anArr > maxVal) {
                maxVal = anArr;
            }
        }
        System.out.println("maxVal = " + maxVal);
        System.out.println();

        return maxVal;
    }

    public static void sort(double[] arr) {
        double temp = 0;
        boolean flag1 = true;
        while (flag1) {
            flag1 = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag1 = true;
                }
            }
        }

        for (double anArr : arr) {
            System.out.print(anArr + " ");
        }
    }
}
