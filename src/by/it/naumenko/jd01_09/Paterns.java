package by.it.naumenko.jd01_09;

final class Paterns {
    private Paterns(){

    }
    static final String OPERATION="[-+*/]";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?)(,?))+}";
    static final String MATRIX = "\\{(\\{((-?\\d+(.\\d+)?)(,?))+},?)+}";
}
