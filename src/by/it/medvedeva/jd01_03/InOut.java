package by.it.medvedeva.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        String line2 = line.trim();
        String[] strMas = line2.split(" ");


        double[] res = new double[strMas.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(strMas[i]);
        }
        return res;

    }


    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.println(element + " ");
        }

        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-3d]=%-10.4f ", name, i, arr[i]);
            if ((i+1)%columnCount==0||i+1==arr.length);
            System.out.println();


        }


    }
}


