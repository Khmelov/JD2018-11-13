package by.it.zhivov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var culc(String expression) {
        String[] operand = expression.split(Patterns.OPERATION);
        Var firstoperand = Var.createVar(operand[0]);
        Var secondoperand = Var.createVar(operand[1]);
        if (firstoperand == null || secondoperand == null)
            return null;

        Pattern pat = Pattern.compile(Patterns.OPERATION);
        Matcher mat = pat.matcher(expression);

        if (mat.find()) {
            String operation = mat.group();
            switch (operation) {
                case "+":
                    return firstoperand.add(secondoperand);
                case "-":
                    return firstoperand.sub(secondoperand);
                case "*":
                    return firstoperand.mul(secondoperand);
                case "/":
                    return firstoperand.div(secondoperand);
            }
        }
        return null;
    }
}
