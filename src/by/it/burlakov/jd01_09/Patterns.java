package by.it.burlakov.jd01_09;

/**
 * Created by user on 01.12.2018.
 */

abstract class Patterns {
    private Patterns(){

    }
    static final String OPERATOR = "[-+*/]";
    static final String SCALAR = "-?[0-9]+(.[0-9]+)?";
    static final String VECTOR = "\\{((-?[0-9]+(.[0-9]+)?)(,?))+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+(.[0-9]+)?)(,?))+},?)+}";
}

