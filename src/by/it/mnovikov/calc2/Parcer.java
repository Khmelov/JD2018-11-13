package by.it.mnovikov.calc2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 01.12.2018.
 */
class Parcer {

    private final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("/", 2);
            this.put("*", 2);
        }
    };

    private void debug(List<String> operands, List<String> operations) {
        StringBuilder sb = new StringBuilder(operands.get(0));
        for (int i = 0; i < operations.size(); i++) {
            sb.append(operations.get(i)).append(operands.get(i + 1));
        }
        System.out.println(sb);
    }

    public String calc(String expression) throws CalcException {
        List<String> asList = Arrays.asList(expression.split(Patterns.OPERATION));
        List<String> operands = new ArrayList<>(asList);
        List<String> operations = new ArrayList<>();

        Pattern p1 = Pattern.compile(Patterns.OPERATION);
        Matcher m1 = p1.matcher(expression);
        while (m1.find()) operations.add(m1.group());
        if (operations.size() == 0) return Var.createVar(expression).toString();
        while (operations.size() > 0) {
            int number = getPriority(operations);
            String operation = operations.remove(number);
            String one = operands.remove(number);
            String two = operands.get(number);
            String res = oneOperation(one, operation, two);
            operands.set(number,res);
        }
        return operands.get(0);
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

    private int getPriority(List<String> operation) {
        int index = -1;
        int currentPriority = -1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            Integer pr = priority.get(op);
            if (pr > currentPriority) {
                index = i;
                currentPriority = pr;
            }
        }
        return index;
    }
}
