package by.it.kruglenja.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) {
        String[] operands = expression.split(Patterns.OPERATIONS);
        Var one=Var.createVar(operands[0]);
        Var two=Var.createVar(operands[1]);
        if (one == null || two == null){
            return null; //TODO create error
        }
        Pattern p = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = p.matcher(expression);
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
