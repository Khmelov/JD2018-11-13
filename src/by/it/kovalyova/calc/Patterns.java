package by.it.kovalyova.calc;

public class Patterns {

    static final String OPERATION = ".+[-+/*]";
    static final String FULLOP = "^(.*[^+-/*])([-+/*])(.*)";
    static final String SCALAR = "^(-?[0-9]+\\.?[0-9]*)$";
    static final String VECTOR = "^\\{((-?[0-9]+\\.?[0-9]*),?)+}$";
    //static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    static final String PRTS = "^(.*)\\(([^()]*)\\)(.*)$";
    static final String ID = "^([a-zA-Z][a-zA-Z0-9]*)$";
    static final String ASSIGN = "^([a-zA-Z][a-zA-Z0-9]*)=(.*)$";
}
