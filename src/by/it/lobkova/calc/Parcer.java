package by.it.lobkova.calc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {

    private final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    public Var calcs(String expression) throws CalcException {
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

            if (one == null || two == null) {
                return null;
            }

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
        } else throw new CalcException("Введена неверная операция");
        return null;
    }

    private int getPriority(List<String> operation) {
        //= + * / *
        int index=-1;
        int currentPriopity=-1;
        for (int i = 0; i < operation.size(); i++) {
            String o = operation.get(i);
            Integer p = priority.get(o);
            if (p>currentPriopity) {
                index=i;
                currentPriopity=p;
            }
        }
        return index;
    }
}

