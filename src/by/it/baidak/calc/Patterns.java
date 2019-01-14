package by.it.baidak.calc;

final class Patterns {

    Patterns(){}

    final static String HOOKS = "[(]([^()]+)[)]";
    final static String OPERATION = "(?<![-+*/={,])([-+=*/])";
    final static String SCALAR = "-?[0-9]+(.[0-9]+)?";
    final static String VECTOR = "\\{((-?[0-9]+(.[0-9]+)?)(,?))+}";
}
