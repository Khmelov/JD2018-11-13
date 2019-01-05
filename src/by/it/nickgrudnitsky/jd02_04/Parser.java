package by.it.nickgrudnitsky.jd02_04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        Var result = null;

        result = counting(getExpresion(expression));
        return null;
    }

    String getExpresion(String expression) throws CalcException {
        List<String> reversePolishNotation = new ArrayList<>();
        LinkedList<String> steck = new LinkedList<>();
        Var result = null;
        Pattern pattern = Pattern.compile(Patterns.REVESEPOLISHNOTATION);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            Pattern pattern1 = Pattern.compile(Patterns.OPERATION);
            Matcher matcher1 = pattern1.matcher(matcher.group());
            if (!matcher1.find()) { //если не операция, то записываем
                reversePolishNotation.add(matcher1.group());
            }
            if (matcher1.find()) {
                if (matcher1.group().equals("(")) {
                    steck.push("(");
                } else {
                    if (matcher1.group().equals(")")) {
                        while (steck.getLast().equals("(")) {
                            reversePolishNotation.add(steck.pop());
                        }
                    } else {
                        if (!steck.isEmpty()) {
                            if (GetPriority(matcher1.group()) <= GetPriority(steck.peek())) {
                                reversePolishNotation.add(steck.pop());
                            } else {
                                steck.push(matcher1.group());
                            }
                        }
                    }
                }
            }
        }
        while (steck.size() > 0) {
            reversePolishNotation.add(steck.pop());
        }
        return reversePolishNotation.toString();
    }

    static private Var counting(String input) throws CalcException {
        Var result = null;
        LinkedList<String> steck = new LinkedList<>();
        Pattern pattern = Pattern.compile(Patterns.REVESEPOLISHNOTATION);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            Pattern pattern1 = Pattern.compile(Patterns.OPERATION);
            Matcher matcher1 = pattern1.matcher(matcher.group());
            if (!matcher1.find()) {
                steck.push(matcher1.group());
            } else {
                if (IsOperator(matcher1.group())) {
                    Var one = Var.createVar(steck.pop());
                    Var two = Var.createVar(steck.pop());
                    switch (matcher1.group()) {
                        case "+":
                            result = one.add(two);
                            break;
                        case "-":
                            result = one.sub(two);
                            break;
                        case "*":
                            result = one.mul(two);
                            break;
                        case "/":
                            result = one.div(two);
                            break;
                    }
                    steck.push(result.toString());
                }
            }
        }

        return Var.createVar(steck.peek());
    }


    static private boolean IsOperator(String expresion) {
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expresion);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    static private int GetPriority(String s) {
        switch (s) {
            case "(":
                return 0;
            case ")":
                return 1;
            case "+":
                return 2;
            case "-":
                return 3;
            case "*":
                return 4;
            case "/":
                return 4;
            default:
                return 6;
        }
    }

}
    /*Var calc(String expression) throws CalcException {
        List<String> reversePolishNotation = new ArrayList<>();
        LinkedList<String> steck = new LinkedList<>();
        Var result = null;
        Pattern pattern = Pattern.compile(Patterns.REVESEPOLISHNOTATION);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            Pattern pattern1 = Pattern.compile(Patterns.OPERATION);
            Matcher matcher1 = pattern.matcher(matcher.group());
            if (!matcher1.find()) {
                reversePolishNotation.add(matcher1.group());
            }
            if (matcher1.group().equals("+") && steck.isEmpty()) {
                steck.add(matcher1.group());
            } else {
                if (matcher1.group().equals("+") && (steck.getLast().equals("+") || steck.getLast().equals("-"))) {
                    reversePolishNotation.add(steck.getLast());
                    steck.removeLast();
                    steck.addLast("+");
                } else {

                }
            }
            if (matcher1.group().equals("-") && steck.isEmpty()) {
                steck.add(matcher1.group());
            } else {
                if (matcher1.group().equals("-") && (steck.getLast().equals("+") || steck.getLast().equals("-"))) {
                    reversePolishNotation.add(steck.getLast());
                    steck.removeLast();
                    steck.addLast("+");
                } else {

                }
            }

        }

        return result;
    }
}*/
    /*Var calc(String expression) throws CalcException {
        List<String> operands = Arrays.asList(expression.split(Patterns.OPERATION));
        List<String> operations = new ArrayList<>();
        Var result = null;
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (i==0) result = Var.createVar(operands.get(i));
            Var two = Var.createVar(operands.get(i + 1));
            switch (operation) {
                case "+":
                    result = result.add(two);
                    break;
                case "-":
                    result = result.sub(two);
                    break;
                case "*":
                    result = result.mul(two);
                    break;
                case "/":
                    result = result.div(two);
                    break;
            }
        }
        return result;
    }*/

        /*String[] operand = expression.split(Patterns.OPERATION);
        Var two = Var.createVar(operand[1]);
        if (expression.contains("=")) {
            return Var.saveVar(operand[0], two);
        }
        Var one = Var.createVar(operand[0]);
        if (one == null || two == null) {
            return null; // TODO: create error
        }
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
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
        }*/