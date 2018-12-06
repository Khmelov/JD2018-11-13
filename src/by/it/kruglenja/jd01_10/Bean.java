package by.it.kruglenja.jd01_10;

public class Bean {
    @Param(a = 2, b = 3)
    static double sum(int a,int b){
        return (double) a + b;
    }

    @Param(a = 3, b = 4)
    static double max(int a, int b){
        return (double) a > b ? a : b;
    }

    @Param(a = 4, b = 5)
    double min(int a, int b){
        return (double) a < b ? a : b;
    }

    double avg(int a, int b){
        return (double) (a + b) / 2;
    }
}
