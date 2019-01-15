package by.it.zhivov.jd01_04;

public class InOut {

    static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] dblArray = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            dblArray[i] = Double.parseDouble(strArray[i]);
        }
        return dblArray;
    }

    static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            // v[1]=12.1234
            System.out.printf("%s[%-3c]=%-7.4f", name, i, arr[i]);
            if (( i + 1 ) % columnCount == 0 || i + 1 == arr.length)
                System.out.println();
        }
    }

}
