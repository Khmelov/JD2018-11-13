package by.it.kruglenja.jd01_09;

public class Patterns {
    static final String OPERATIONS = "[+-/*]";
    static final String SCALAR = "-?[0-9]+(.[0-9]+)?";
    static final String VECTOR = "\\{((-?[0-9]+(.[0-9]+)?)(,?))+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+(.[0-9]+)?)(,?))+},?)+}";
}
