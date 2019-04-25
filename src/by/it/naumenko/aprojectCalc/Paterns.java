package by.it.naumenko.aprojectCalc;

final class Paterns {
    private Paterns(){

    }
    static final String OPERATION="(?<![-+*/={,]|\\s|^)([-+=*/])";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?)(,?\\s*))+}";
    static final String MATRIX = "\\{(\\{((-?\\d+(.\\d+)?)(,?\\s*))+},?\\s*)+}";
    static final String SKOBKI ="[(]([^()]+)[)]";
}
