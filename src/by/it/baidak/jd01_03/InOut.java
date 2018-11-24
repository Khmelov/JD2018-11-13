package by.it.baidak.jd01_03;

public class InOut {

    public static double[ ] getArray(String line){
        line = line.trim();
        String[] stringElements = line.split(" ");
        double[] doubleElements = new double[stringElements.length];
        for (int i = 0; i < doubleElements.length; i++) {
            doubleElements[i] = Double.parseDouble(stringElements[i]);
        }
        return doubleElements;
    }

    public static void printArray(double[ ] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printArray(double[ ] arr, String name, int columnCount){
        int col = 0;
        for (int i = 0; i < arr.length; i++){
            System.out.printf("%s[% -3d]=%-9.4f ",name, i, arr[i]);
            col++;
            if ((0 == col%columnCount) || (arr.length - 1 == i)){
                System.out.println();
            }
        }
    }
}
