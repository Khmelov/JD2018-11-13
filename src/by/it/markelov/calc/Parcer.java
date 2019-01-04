package by.it.markelov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    public Var calc(String expresion) throws CalcExeption {
        String[] operands = expresion.split(Paterns.OPERATION);
        Pattern pattern = Pattern.compile(Paterns.OPERATION);
        Matcher matcher = pattern.matcher(expresion);
        if (matcher.find()) {
            String operation = matcher.group();
            Var two = Var.createVar(operands[1]);
            if (operation.equals("=")) {
                Var.setVar(operands[0], two);
                return two;
            }
            Var one = Var.createVar(operands[0]);
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
