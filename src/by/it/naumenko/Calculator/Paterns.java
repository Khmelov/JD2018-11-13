package by.it.naumenko.Calculator;

final class Paterns {
    private Paterns(){

    }
    static final String OPERATION="(?<![-+*/={,])([-+=*/])";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?)(,?\\s*))+}";
    static final String MATRIX = "\\{(\\{((-?\\d+(.\\d+)?)(,?\\s*))+},?\\s*)+}";
    static final String SKOBKI ="[(]([^()]+)[)]";
}
