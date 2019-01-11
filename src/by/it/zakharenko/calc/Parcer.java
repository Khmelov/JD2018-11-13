package by.it.zakharenko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {

    public Var calcs(String expression) {
        String[] operand = expression.split(Patterns.SYMBOL);

        for (int i = 0; i < operand.length; i++) {
            operand[i] = operand[i].trim().replace("\\s+", "");
        }

        Pattern pattern = Pattern.compile(Patterns.SYMBOL);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()) {
            String operation = matcher.group();
            Var two = Var.createVar(operand[1]);
            if (operation.equals("=")) {
                Var.setVar(operand[0], two);
                return two;
            }

            Var one = Var.createVar(operand[0]);

            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return null;
    }
}
