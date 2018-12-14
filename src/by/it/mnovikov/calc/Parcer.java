package by.it.mnovikov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 01.12.2018.
 */
class Parcer {
    Var calc(String expression) throws CalcException {
        String[] operand = expression.split(Patterns.OPERATION);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        if (one == null || two == null)
            return null; //TODO create error
        Pattern p1 = Pattern.compile(Patterns.OPERATION);
        Matcher m1 = p1.matcher(expression);
        if (m1.find()) {
            String operation = m1.group();
            switch (operation) {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
