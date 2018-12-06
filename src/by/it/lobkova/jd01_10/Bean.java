package by.it.lobkova.jd01_10;

public class Bean {

    @Param(a = 2, b = 10)
    double sum (int a, int b) {
        return a + b;
    }

    @Param(a = 2, b = 10)
    double max (int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 2, b = 10)
    double min (int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 2, b = 10)
    double avg (int a, int b) {
        return (a + b) / 2;
    }
}
