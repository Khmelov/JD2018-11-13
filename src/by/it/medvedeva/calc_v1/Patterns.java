package by.it.medvedeva.calc_v1;

public class Patterns {

    static final String OPERATION="[=-+/*]";
    static String SCALAR="-?[0-9]+\\.?[0-9]*";
    static String VECTOR="\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    static String MATRIX="\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
}

