package by.it.nickgrudnitsky.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        return result;
    }

    static void printArray(double[] array) {
        for (double elemetn : array) {
            System.out.print(elemetn + " ");
        }
        System.out.println();
    }

    static void printArray(double[] array, String name, int columncount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            if ((i + 1) % columncount == 0 || i + 1 == array.length) {
                System.out.println();
            }
        }
    }

}
