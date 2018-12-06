package by.it.denisova.jd01_09;

final class  Patterns {


    static final String OPERATION ="[-+*/]";
    static final String SCALAR = "-?[0-9]+(.[0-9]+)?";
    static final String VECTOR = "\\{((-?[0-9]+(.[0-9]+)?)(,?))+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+(.[0-9]+)?)(,?))+},?)+}\"";
}
