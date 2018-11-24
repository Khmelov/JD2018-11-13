package by.it.mnovikov.jd01_04;

/**
 * Created by user on 17.11.2018.
 */
public class InOut {
//    public static void main(String[] args) {
//        double[] test = {1,2,3,4,5,6,7,8,9};
//        printArray(test, "v", 5);
//    }


    static double[] getArray(String line) {
//        String line2 = line.trim();
//        String[] strMas = line2.split(" ");

        String[] strMas = line.trim().split(" ");
        double[] res = new double[strMas.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(strMas[i]);
        }
        return res;
    }

    static void printArray(double[] arr){
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount){
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
                        //v[ 0 ]=-123.64578
            System.out.printf("%s[%- 3d]=%-10.5f", name, i, arr[i]);
            col++;
            if (col%columnCount==0 || col==arr.length){
                System.out.println();
            }
        }
    }
}
