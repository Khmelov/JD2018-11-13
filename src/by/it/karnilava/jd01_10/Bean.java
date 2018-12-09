package by.it.karnilava.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Bean {
    @Param(a = 1, b = 4)
    static double sum(int a, int b) {
        return (a + b);
    }

    @Param(a = 5, b = 2)
    double max(int a, int b) {
        if (a >= b)
            return (a);
        else return (b);
    }


    double min(int a, int b) {
        if (a >= b)
            return (b);
        else return (a);
    }

    @Param(a = 5, b = 2)
    static double avg(int a, int b) {

        return ((a + b) / 2.0);

    }


}





