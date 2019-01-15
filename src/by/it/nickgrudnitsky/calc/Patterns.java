package by.it.nickgrudnitsky.calc;

class Patterns {
    static final String REVESEPOLISHNOTATION = "\\{((\\{(([0-9]+\\.?[0-9]*),?)+}),?)+}|(?<![+/*=-])[+/*=)-]|[(]|(?<![A-Za-z]+[0-9]?)-?[0-9]+\\.?[0-9]*|[A-Za-z]+[0-9]?|\\{(([0-9]+\\.?[0-9]*),?)+}";
    /*static final String OPERATIONSANDSCLAR = "-?[0-9]+\\.?[0-9]*|(?<![+/*=-])[+/*=)-]|[(]";*/
    static final String VARIABLEANDSCALARS = "-?[0-9]+\\.?[0-9]*|[A-Za-z]+[0-9]?";
    static final String OPERATION = "(?<![+/*=-])[+/*=)-]|[(]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{((-?[ 0-9]+\\.?[0-9 ]*),?)+}";
    static final String MATRIX = "[{]([{]((-?[0-9]+(.[0-9]+)?)(,?\\s?))+},?\\s?)+}";
}
