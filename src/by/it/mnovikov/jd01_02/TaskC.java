package by.it.mnovikov.jd01_02;

        import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step1(n);

    }

    static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mas[i][j] != n || mas[i][j] != -n) {
                    mas[i][j] = (int) (Math.random() * (2* n + 1)) - n;
                } else System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        return mas;
    }
}