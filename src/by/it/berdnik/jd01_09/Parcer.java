package by.it.berdnik.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    public by.it.berdnik.jd01_09.Var calc(String expression) {
        String[] operands = expression.split(by.it.berdnik.jd01_09.Patterns.OPERATION);
        by.it.berdnik.jd01_09.Var one= by.it.berdnik.jd01_09.Var.createVar(operands[0]);
        by.it.berdnik.jd01_09.Var two= by.it.berdnik.jd01_09.Var.createVar(operands[1]);
        Pattern op=Pattern.compile(by.it.berdnik.jd01_09.Patterns.OPERATION);
        Matcher matcher = op.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }

        //TODO Generate error
        return null;
    }
}
