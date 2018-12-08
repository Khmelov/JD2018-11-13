package by.it.seroglazov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    public Var calc(String expression) {
        // 1.2+7.8
        String[] operands = expression.split(Patterns.OPERATION);
        Var two= Var.createVar(operands[1]);
        if (expression.contains("=")){
            return Var.saveVar(operands[0], two);
        }
        Var one= Var.createVar(operands[0]);
        // Now search +-*/=
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
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
