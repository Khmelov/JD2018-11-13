package by.it.kovalyova.calc;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    static HashMap<String,Var> vars=new HashMap<String,Var>();
    static String saveVar(String name, Var var){
        vars.put(name, var);
        return var.toString();
    }
    String calc(String expression) {
        Pattern pprint = Pattern.compile("printvar (.*)$");
        Matcher m = pprint.matcher(expression);
        if (m.matches()){
            Var v = vars.get(m.group(1));
            return v.toString();
        }
        expression=expression.trim().replaceAll("\\s+","");
        String[] operands = expression.split(Patterns.OPERATION);
        if (expression.contains("=")){
            Var two = Var.createVar(operands[1]);
            return this.saveVar(operands[0],two);
        }

        Var one = Var.createVar(operands[0]);
        Var two = Var.createVar(operands[1]);
        if (one == null || two == null)
            return ""; //TODO create error
        Pattern p=Pattern.compile(Patterns.OPERATION);
        m=p.matcher(expression);
        if (m.find()){
            String operation=m.group();
            switch (operation){
                case "+": return one.add(two).toString();
                case "-": return one.sub(two).toString();
                case "*": return one.mul(two).toString();
                case "/": return one.div(two).toString();
            }
        }
        return null;
    }
}
