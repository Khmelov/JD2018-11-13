package by.it.lobkova.calc;

public interface Patterns {

     String OPERATION="(?<=[^-+*/={,])([-+=*/])";
     String SCALAR = "-?[0-9]+(.[0-9]+)?";
     String VECTOR="[{]((-?[0-9]+(.[0-9]+)?)(,?)(\\s?))+}";
     String MATRIX = "\\{(\\{((-?[0-9]+(.[0-9]+)?)(,?))+\\}(\\s)*(,)*(\\s)*)+}";
     String PARENTHESES="[(]([^()]+)[)]";
}
