package by.it.burlakov.jd01_09;

/**
 * Created by user on 01.12.2018.
 */
public interface Patterns {
    String OPERATOR = "[-+*/]";
    String SCALAR = "-?[0-9]+(.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + ",?}";
}
