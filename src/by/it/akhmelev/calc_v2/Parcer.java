package by.it.akhmelev.calc_v2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    public Var calc(String expression) {
        //   1.2+7.8
        String[] operands = expression.split(Patterns.OPERATION);
        Pattern op=Pattern.compile(Patterns.OPERATION);
        Matcher matcher = op.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            Var two= Var.createVar(operands[1]);
            if (operation.equals("=")){
                Var.setVar(operands[0],two);
                return two;
            }
            Var one= Var.createVar(operands[0]);
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
