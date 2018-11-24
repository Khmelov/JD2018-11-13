package by.it.akhmelev.jd01_04;

class InOut {

    static double[] getArray(String line) {
        String[] strMas = line.trim().split(" ");
        double[] res = new double[strMas.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(strMas[i]);
        }
        return res;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

    }

    static void printArray(double[ ] arr, String name, int columnCount){
        int col=0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.5f",name,i,arr[i]);
            col++;
            if (col%columnCount==0 || col==arr.length){
                System.out.println();
            }
        }

    }


}
