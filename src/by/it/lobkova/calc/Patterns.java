package by.it.lobkova.calc;

public interface Patterns {

     String SYMBOL = "[-+*/=]";
     String SCALAR = "-?[0-9]+(.[0-9]+)?";
     String VECTOR = "\\{((-?[0-9]+(.[0-9]+)?)(,?))+}";
     String MATRIX = "\\{(\\{((-?[0-9]+(.[0-9]+)?)(,?))+},?)+}";

}
