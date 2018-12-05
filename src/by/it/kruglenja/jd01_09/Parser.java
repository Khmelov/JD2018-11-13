package by.it.kruglenja.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) {
        //   1.2+7.8
        String[] operands = expression.split(Patterns.OPERATION);
        Var one=Var.createVar(operands[0]);
        Var two=Var.createVar(operands[1]);
        Pattern op=Pattern.compile(Patterns.OPERATION);
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
