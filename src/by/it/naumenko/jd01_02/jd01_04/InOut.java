package by.it.naumenko.jd01_02.jd01_04;

/**
 * Created by user on 17.11.2018.
 */
public class InOut {

    static double[] getArray(String line) {
        //String line2 = line.trim();
        //String[] strMas = line.split(" ");
        String[] line2 = line.trim().split(" ");
        double[] strMas = new double[line2.length];
        for (int i = 0; i < strMas.length; i++) {
            strMas[i] = Double.parseDouble(line2[i]);
        }
        return strMas;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            //v[ 0 ]=-123.56
            System.out.printf("%s[%- 3d]=%-10.5f ", name, i, arr[i]);
            col++;
            if ((col % columnCount == 0)||(col==arr.length))
                System.out.println();
        }
    }

//    public static void main(String[] args) {
//        double[] mas={1,2,3,4,5,6,7};
//        printArray(mas,"T",3);
//
//    }
}
