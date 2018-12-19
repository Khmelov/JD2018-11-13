package by.it.naumenko.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    public Var calc(String expresion) throws CalcExeption{
        String[] operands = expresion.split(Paterns.OPERATION);
        Var one = Var.createVar(operands[0]);
        Var two = Var.createVar(operands[1]);

        Pattern pattern = Pattern.compile(Paterns.OPERATION);
        Matcher matcher = pattern.matcher(expresion);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+":return one.add(two);
                case "-":return one.sub(two);
                case "*":return one.mul(two);
                case "/":return one.div(two);
            }
        }
        return null;
    }
}
