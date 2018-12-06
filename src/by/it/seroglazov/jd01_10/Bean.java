package by.it.seroglazov.jd01_10;

public class Bean {
    @Param(a = 2, b = 8)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 1, b = 2)
    static double max(int a, int b) {
        return a >= b ? a : b;
    }

    @Param(a = 1, b = 2)
    double min(int a, int b) {
        return a < b ? a : b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
