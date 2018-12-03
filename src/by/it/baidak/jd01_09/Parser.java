package by.it.baidak.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 01.12.2018.
 */
public class Parser {

    public Var calc(String exp){
        String[]operands = exp.split(Patterns.OPERATION);
        Var one=Var.createVar(operands[0]);
        Var two=Var.createVar(operands[1]);
        Pattern pattern=Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(exp);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
