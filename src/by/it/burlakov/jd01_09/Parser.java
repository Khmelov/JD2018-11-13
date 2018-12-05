package by.it.burlakov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 01.12.2018.
 */
public class Parser {
    public Var calc(String expr) {
        String[] operands = expr.split(Patterns.OPERATOR);
        Var one = Var.createVar(operands[0]);
        Var two = Var.createVar(operands[1]);
        Pattern op = Pattern.compile((Patterns.OPERATOR));
        Matcher matcher = op.matcher(expr);
        if(matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+":return one.add(two);
                case "-":return one.sub(two);
                case "*":return one.mul(two);
                case "/":return one.div(two);
            }
        }
        return null;
    }
}
