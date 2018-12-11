package by.it.denisova.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    public Var calc(String expression) {
        String[] operands = expression.replace("\\s", "").split(Patterns.OPERATION);
        Var one = Var.createVar(operands[0]);
        Var two = Var.createVar(operands[1]);
        if (one == null || two == null){
            return null; //TODO create error
        }
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation){
                case("+"): return one.add(two);
                case("-"): return one.sub(two);
                case("/"): return one.div(two);
                case("*"): return one.mul(two);
            }
        }
        return null;
    }
}
