package by.it.karnilava.jd01_03;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "v", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        String str2 = scanner.nextLine();
        double[] vector = InOut.getArray(str2);

        Helper.mul(getMatrix(), vector);
        double[][] matrixLeft = getMatrix();
        double [ ][] matrixRight = getMatrix();
        Helper.mul(matrixLeft,matrixRight);

    }

    public static double[][] getMatrix() {
        System.out.println("Введите размерность матрицы");
        Scanner scannerSize = new Scanner(System.in);
        String lineSize = scannerSize.nextLine();
        int row = Integer.parseInt(lineSize.split(" ")[0]);
        int col = Integer.parseInt(lineSize.split(" ")[1]);
        double[][] matrix = new double[row][col];
        for (int i = 0; i < row; i++) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            matrix[i] = InOut.getArray(line);
        }
        return matrix;
    }
}

