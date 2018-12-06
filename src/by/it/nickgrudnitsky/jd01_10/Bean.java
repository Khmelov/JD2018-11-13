package by.it.nickgrudnitsky.jd01_10;

public class Bean {
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 1, b = 2)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 3, b = 4)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 5, b = 6)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
