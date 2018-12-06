package by.it.mnovikov.jd01_10;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by user on 04.12.2018.
 */

@Retention(RetentionPolicy.RUNTIME)
//@Target()
public @interface Param {
    int a();
    int b();
}
