package by.it.vchernetski.calc;

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
        if (expression.contains("sortvar")) {
            Var.sortvar();
            return null;
        }
        if (expression.contains("printvar")) {
            Var.printvar();
            return null;
        }
        Matcher m = Pattern.compile("\\([^()]+\\)").matcher(expression);
        while (m.find()) {
            String temp = m.group();
            String now = calc(temp.substring(1, temp.length() - 1));
            expression = expression.replace(temp, now);
//            m.reset();
            m=Pattern.compile("\\([^()]+\\)").matcher(expression);
        }
        List<String> asList = Arrays.asList(expression.split(Patterns.OPERATION));
        List<String> operands = new ArrayList<>(asList);
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) operations.add(matcher.group());
        if (operations.size() == 0) return Var.createVar(expression).toString();
        while (operations.size() > 0) {
            int number = getPriority(operations);
            String operation = operations.remove(number);
            String operandF = operands.remove(number);
            String operandS = operands.get(number);
            String res = oneOperation(operandF, operation, operandS);
            operands.set(number, res);
        }
        return operands.get(0);
//        String[] operands = expression.split(Patterns.OPERATION);
//        if(operands.length<2) throw new CalcException("invalid Data");
//        Var op2 = Var.createVar(operands[1]);
//        if(expression.contains("=")){
//            return Var.saveVar(operands[0],op2).toString();
//        }
//        Var op1 = Var.createVar(operands[0]);
//        Matcher m = Pattern.compile(Patterns.OPERATION).matcher(expression);
//        if(m.find()){
//            String operation = m.group();
//            switch (operation){
//                case "+": return op1.add(op2).toString();
//                case "-": return op1.sub(op2).toString();
//                case "*": return op1.mul(op2).toString();
//                case "/": return op1.div(op2).toString();
//            }
//        }
//        return null;
    }

    private String oneOperation(String operandF, String operation, String operandS) throws CalcException {
        Var second = Var.createVar(operandS);
        if (operation.equals("=")) {
            Var.saveVar(operandF, second);
            return second.toString();
        }
        Var first = Var.createVar(operandF);
        switch (operation) {
            case "+":
                return first.add(second).toString();
            case "-":
                return first.sub(second).toString();
            case "*":
                return first.mul(second).toString();
            case "/":
                return first.div(second).toString();
        }
        return null;
    }

    private int getPriority(List<String> operations) {
        int index = -1;
        int currentPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String o = operations.get(i);
            Integer p = priority.get(o);
            if (p > currentPriority) {
                index = i;
                currentPriority = p;
            }
        }
        return index;
    }
}
