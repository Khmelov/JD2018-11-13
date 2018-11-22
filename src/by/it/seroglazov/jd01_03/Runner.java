package by.it.seroglazov.jd01_03;

public class Runner {
    public static void main(String[] args) {
        //double[] dArr = {1, 2.3, 15, -7.4, 0.002, -5, 3.0, 17, -100};
        double[] dArr = InOut.getArray("  1 2.3 15 -7.4 0.002 -5 3.0 17 -100  ");
        InOut.printArray(dArr);
        InOut.printArray(dArr, "dArr", 5);
        Helper.sort(dArr);
        System.out.println("After bubble sort");
        InOut.printArray(dArr);

        // Test matrix multiple vector
        System.out.println("Test matrix multiple vector");
        double[][] matr = {{1, 2, 3},
                           {4, 5, 6}};
        double[] vect = {1, 2, 4};
        double[] ans1 = Helper.mul(matr, vect);
        InOut.printArray(ans1);

        // Test matrix multiple matrix
        System.out.println("Test matrix multiple matrix");
        double[][] matLeft = {{1, 2, 3}, {4, 5, 6}};
        double[][] matRight = {{1, 2}, {3, 4}, {5, 6}};
        double[][] ans2 = Helper.mul(matLeft, matRight);
        for (int i = 0; i < ans2.length; i++) {
            InOut.printArray(ans2[i]);
        }
    }
}
