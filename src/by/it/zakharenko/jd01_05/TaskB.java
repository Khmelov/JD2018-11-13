package by.it.zakharenko.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        mathA();
        mathB();
    }

    private static void mathA() {
        for (double a = 0; a <= 2.0; a += 0.20) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y += Math.pow(7, a) - Math.cos(x);
            }
            System.out.printf("При а=%1.1f Сумма y=%e%n", a, y);
        }
        System.out.println();
    }

    private static void mathB() {
        double beta;
        for (double x = -6; x <= 2; x += 0.5) {
            if (x / 2 <= -2 || x / 2 > 0.2) {
                System.out.printf("При x/2 = %1.2e вычисления не определены \n", x/2);
            }else if (-1 >= x / 2 || x / 2 > -2) {
                beta = Math.sin(Math.pow(x, 2));
                double alpha = Math.log10(Math.abs(beta + 2.74));
                System.out.printf("if x/2 = %1.2e alpha = %1.6e \n", x / 2, alpha);
            }else if (0.2 > x / 2 || x / 2 > -1) {
                beta = Math.cos(Math.pow(x, 2));
                double alpha = Math.log10(Math.abs(beta + 2.74));
                System.out.printf("if x/2 = %1.2e alpha = %1.6e \n", x / 2, alpha);
            }else if (x / 2 == 0.2) {
                beta = 1 / Math.tan(Math.pow(x, 2));
                double alpha = Math.log10(Math.abs(beta + 2.74));
                System.out.printf("if x/2 = %1.2e alpha = %1.6e \n", x / 2, alpha);
            }
        }
    }
}
