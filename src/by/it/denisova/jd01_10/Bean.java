package by.it.denisova.jd01_10;

public class Bean {
    public Bean() {

    }

    @Param(a = 2, b = 3)
   static double sum (int a, int b){
        return a + b;
    }

    @Param(a = 2, b = 3)
    static double max (int a, int b){
        return  a > b ? a: b;
    }

    @Param(a = 2, b = 3)
    double avg (int a, int b){
        return (a+b)/2.0;
    }


    double min (int a, int b){
        return  a < b ? a: b;
    }
}
