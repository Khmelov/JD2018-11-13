package by.it.skarpovich.jd01_10;
import java.lang.annotation.*;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)

public @interface Param {
        int a();
        int b();
}
