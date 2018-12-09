package by.it.naumenko.jd01_10;

@Param1(a=2,b=4)
public class Bean {

    @Param(a = 2, b = 3)
    static double sum(int a, int b) {return a + b;}

    @Param(a = 2, b = 10)
    double max(int a, int b) { return (a > b) ? a : b;}

    static double min(int a, int b) {return (a < b) ? a : b; }

    @Param(a = 3, b = 9)
    double avg(int a, int b) {return (a + b) / (double) 2; }
}
