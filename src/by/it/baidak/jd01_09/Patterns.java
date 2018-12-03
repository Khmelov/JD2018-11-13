package by.it.baidak.jd01_09;

/**
 * Created by user on 01.12.2018.
 */
final class Patterns {

    Patterns(){}

    final static String OPERATION = "[-+*/]";
    final static String SCALAR = "-?[0-9]+(.[0-9]+)?";
    final static String VECTOR = "\\{((-?[0-9]+(.[0-9]+)?)(,?))+}";
}
