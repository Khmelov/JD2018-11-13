package by.it.berdnik.jd01_03;

public class InOut {

    static double[] getArray(String line) {
        // 1 2 3 4 5.67
        String line2 = line.trim();    //  Ctrl+Alt+V
        String[] strMas = line2.split(" "); // line.split(" ").var
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
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            // V[1]=12.123
            System.out.printf("%s[%- 3d]=%-10.3f", name, i, arr[i]);
            col++;
            if (col % columnCount == 0 || col == arr.length) {
                System.out.println();
            }
        }
    }
}
