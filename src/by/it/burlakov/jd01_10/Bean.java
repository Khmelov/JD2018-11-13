package by.it.burlakov.jd01_10;

public class Bean {

    @Param(a = 31, b = 12)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    static double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 23, b = 12)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 21, b = 3)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}