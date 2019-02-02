package by.it.zhivov.jd01_10;

public class Bean {
    public double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 3)
    public static double max(int a, int b) {
        if (a > b) return a;
        if (a < b) return b;
        else return 0;
    }

    @Param(a = -8, b = 13)
    public static double min(int a, int b) {
        if (a > b) return b;
        if (a < b) return a;
        else return 0;
    }

    @Param(a = 11, b = 6)
    public double avg(int a, int b) {
        return (a + b) / 2.0;
    }

}
