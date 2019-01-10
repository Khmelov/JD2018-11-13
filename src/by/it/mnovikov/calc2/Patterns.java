package by.it.mnovikov.calc2;

/**
 * Created by user on 01.12.2018.
 */
class Patterns {

    private Patterns(){}

    static final String OPERATION = "(?<![-+*/={,])([-+=*/])";
    static final String SCALAR = "-?[0-9]+(.[0-9]+)?";
    static final String VECTOR = "\\{((-?[0-9]+(.[0-9]+)?)(,?))+}";
//    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)*},?)+}";

}
