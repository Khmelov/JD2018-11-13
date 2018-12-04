package by.it.vchernetski.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    public static Var calc(String expression){
        String[] operands = expression.split(Patterns.OPERATION);
        Var op1 = Var.createVar(operands[0]);
        Var op2 = Var.createVar(operands[1]);
        Matcher m = Pattern.compile(Patterns.OPERATION).matcher(expression);
        if(m.find()){
            String operation = m.group();
            switch (operation){
                case "+": return op1.add(op2);
                case "-": return op1.sub(op2);
                case "*": return op1.mul(op2);
                case "/": return op1.div(op2);
            }
        }
        return null;
    }
}
