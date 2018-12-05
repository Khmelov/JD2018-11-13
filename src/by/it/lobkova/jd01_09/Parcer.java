package by.it.lobkova.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {

    public Var calcs(String expression) {
        String[] operand = expression.replace("\\s", "").split(Patterns.SYMBOL);

        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        if (one == null || two == null) return null;

        Pattern pattern = Pattern.compile(Patterns.SYMBOL);
        Matcher matcher = pattern.matcher(expression);

        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation){
                case "+" : return one.add(two);
                case "-" : return one.sub(two);
                case "*" : return one.mul(two);
                case "/" : return one.div(two);
            }
        }
        return null;
    }
}
