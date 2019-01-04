package by.it.markelov.jd02_04;

final class Paterns {
  /*  private Paterns(){

    }
  */  static final String OPERATION="[-+*/=]";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?)(,?))+}";
    static final String MATRIX = "\\{(\\{((-?\\d+(.\\d+)?)(,?))+},?)+}";
}
