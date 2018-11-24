package by.it.kruglenja.jd01_03;

/**
 * Created by user on 17.11.2018.
 */
public  class InOut {
    //    public static void main(String[] args) {
//        double[] test = {1,2,3,4,5,6};
//        printArray(test, "T", 3);
//        printArray(test);
//    }
    public static double[] getArray(String line) {
        String[] strMas = line.trim().split(" ");
        double[] res = new double[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            res[i] = Double.parseDouble(strMas[i]);
        }
        return res;
    }

   public static void printArray(double[] arr) {
        for (double anArr : arr) {
            System.out.printf("% 6f ", anArr);
        }
        System.out.println();
    }

    public static void printArray(double[] arr, String name, int columnCount){
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            //v[ 0 ]=-123.45678
            System.out.printf("%s[% -3d]=%-10.5f", name, i, arr[i]);
            col++;
            if ((i + 1)%columnCount == 0 || i == arr.length - 1){
                System.out.println();
            }

        }System.out.println();
    }
}