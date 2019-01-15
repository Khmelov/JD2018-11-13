package by.it.nickgrudnitsky.calc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    public static void main(String[] args) throws CalcException {
        Parcer parser = new Parcer();
        Var.read();
        System.out.println(parser.calc("{2,3}*(10/2)"));

    }

    public Var calc(String expression) throws CalcException {
        List<String> polishNotation = new ArrayList<>();
        LinkedList<String> steck = new LinkedList<>();
        Var result = null;

        translate(expression, polishNotation, steck);
        result = counting(polishNotation, steck, result);
        if (expression.contains("=")) {
            String[] operand1 = expression.split("=");
            return Var.saveVar(operand1[0], result);
        }
        return result;
    }

    private Var counting(List<String> polishNotation, LinkedList<String> steck, Var result) throws CalcException {
        for (String s : polishNotation) {
            Pattern pattern = Pattern.compile(Patterns.VARIABLEANDSCALARS);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                steck.push(s);
            } else {
                Var two = Var.createVar(steck.pop());
                String pop = s;
                if (pop.equals("=")) {
                    Var.saveVar(steck.pop(), two);
                    return two;
                }
                Var one = Var.createVar(steck.pop());

                switch (s) {
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

        return result;
    }

    private void translate(String expression, List<String> polishNotation, LinkedList<String> steck) throws CalcException {
        /*String[] split = expression.split("=");
        expression = split[1];*/
        Pattern pattern = Pattern.compile(Patterns.REVESEPOLISHNOTATION);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {

            Pattern pattern1 = Pattern.compile(Patterns.VARIABLEANDSCALARS);
            Matcher matcher1 = pattern1.matcher(matcher.group());

            if (matcher1.find()) { // если нашло число - берет его
                polishNotation.add(matcher.group());
                continue;
            }
            if (!matcher1.find()) { //если нашло операцию
                if (matcher.group().equals("(")) {
                    steck.push("(");
                } else {
                    if (matcher.group().equals(")")) {
                        while (!steck.getFirst().equals("(")) {
                            String pop = steck.pop();
                            polishNotation.add(pop);
                        }
                        steck.pop();
                    } else {
                        if (!steck.isEmpty()) {
                            while (getPriority(matcher.group()) <= getPriority(steck.peek())) {
                                polishNotation.add(steck.pop());
                                if (steck.size() > 0) {
                                    if (getPriority(matcher.group()) > getPriority(steck.peek())) {
                                        steck.push(matcher.group());
                                        break;
                                    }
                                } else {
                                    steck.push(matcher.group());
                                    break;
                                }
                            }
                            if (steck.peek() != null && getPriority(matcher.group()) > getPriority(steck.peek())) {
                                steck.push(matcher.group());
                            }
                        } else {
                            steck.push(matcher.group());
                        }
                    }
                }
            }
        }
        while (steck.size() > 0) {
            polishNotation.add(steck.pop());
        }
    }

    Var calcAndSave(String expression) throws CalcException {
        String[] operand = expression.split(Patterns.OPERATION);
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
        }
        return null;
    }

    static private int getPriority(String s) {
        switch (s) {
            case "=":
                return 0;
            case "(":
                return 1;
            case ")":
                return 2;
            case "+":
                return 3;
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
