package by.it.lobkova.calc;

import java.util.*;
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

    public String calc(String expression) throws CalcException {
        String enteredOperation = expression;
        // Сперва ищем скобки и если есть, то рекурсивно запускаем саму себя в эту область
        Pattern parentheses = Pattern.compile(Patterns.PARENTHESES);
        Matcher m = parentheses.matcher(expression);
        while (m.find()) {
            String res = calc(m.group(1));
            StringBuilder sb = new StringBuilder(expression);
            expression = sb.replace(m.start(), m.end(), res).toString(); // Заменяем содержимое скобок вычисленным значением
            expression = expression.replaceAll(" ", ""); // Так как toString пишет с пробелами
            m = parentheses.matcher(expression); // И теперь заново начинаем искать скобки уже в новом выражении, но без пробелов
        }
        List<String> asList = Arrays.asList(expression.split(Patterns.OPERATION));
        List<String> operands = new ArrayList<>(asList);
        List<String> operations = new ArrayList<>();

        Pattern op = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = op.matcher(expression);
        while (matcher.find()) operations.add(matcher.group());
        if (operations.size() == 0) return Var.createVar(expression).toString();
        while (operations.size()>0){
            int number=getPriority(operations);
            String operation=operations.remove(number);
            String one=operands.remove(number);
            String two=operands.get(number);
            String res=oneOperation(one,operation,two);
            operands.set(number,res);
        }
        return operands.get(0);
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

    private String oneOperation(String oneStr, String operation, String twoStr) throws CalcException {
        Var two = Var.createVar(twoStr);
        if (operation.equals("=")) {
            Var.setVar(oneStr, two);
            return two.toString();
        }
        Var one = Var.createVar(oneStr);
        switch (operation) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
        }
        return null;
    }
}

