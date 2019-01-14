package by.it.baidak.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Map<String,Integer> priority=new HashMap<String, Integer>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("/",2);
            this.put("*",2);
        }
    };

    public String calc(String expression) {
        Pattern p = Pattern.compile(Patterns.HOOKS);
        Matcher m = p.matcher(expression);
        while (m.find()) {
            StringBuilder sb = new StringBuilder(expression);
            String result = calc(m.group().substring(1, m.group().length()-1));
            sb.replace(m.start(), m.end(), result);
            expression = sb.toString();
        }

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();

        Pattern op = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = op.matcher(expression);
        while (matcher.find()) operations.add(matcher.group());
        if (operations.size() == 0) {
            try {
                return Var.createVar(expression).toString();
            } catch (CalcException e) {
                Logger lo = Logger.getInstance();
                lo.log(e);
            }
        }
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

    private String oneOperation(String oneStr, String operation, String twoStr) {
        try {
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
        } catch (CalcException e) {
            Logger lo = Logger.getInstance();
            lo.log(e);
        }
        return null;
    }
}
