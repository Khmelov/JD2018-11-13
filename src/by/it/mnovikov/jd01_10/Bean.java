package by.it.mnovikov.jd01_10;

/**
 * Created by user on 06.12.2018.
 */
public class Bean {

    @Param(a = 3, b = 5)
    public static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @Param(a = 3, b = 5)
    public static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 3, b = 5)
    public double min(int a, int b) {
        return a < b ? a : b;
    }

    public double max(int a, int b) {
        return a > b ? a : b;
    }
}
