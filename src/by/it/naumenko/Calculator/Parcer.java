package by.it.naumenko.Calculator;

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


    public String calc(String expresion) throws CalcExeption {

        // Сперва ищем скобки и если есть, то рекурсивно запускаем саму себя в эту область
        Pattern parentheses = Pattern.compile(Paterns.SKOBKI);
        Matcher m = parentheses.matcher(expresion);
        while (m.find()) {
            String res = calc(m.group(1));
            StringBuilder sb = new StringBuilder(expresion);
            expresion = sb.replace(m.start(), m.end(), res).toString(); // Заменяем содержимое скобок вычисленным значением
            expresion = expresion.replaceAll(" ", ""); // Так как toString пишет с пробелами
            m = parentheses.matcher(expresion); // И теперь заново начинаем искать скобки уже в новом выражении, но без пробелов
        }


        List<String> asList = Arrays.asList(expresion.split(Paterns.OPERATION));
        List<String> operands = new ArrayList<>(asList);
        List<String> opertions = new ArrayList<>();

        Pattern pattern = Pattern.compile(Paterns.OPERATION);
        Matcher matcher = pattern.matcher(expresion);
        while (matcher.find()) {
            opertions.add(matcher.group());
        }
        if (opertions.size() == 0)
            return Var.createVar(expresion).toString();
        while (opertions.size() > 0) {
            int number = getPriority(opertions);
            String operation = opertions.remove(number);
            String one = operands.remove(number);
            String two = operands.get(number);
            String res = oneOperation(one, operation, two);
            operands.set(number, res);
        }
        return operands.get(0);
    }

    private int getPriority(List<String> opertions) {
        //=+-*/
        int index =0;
        int currentPriority=-1;
        for (int i = 0; i < opertions.size(); i++) {
            String op = opertions.get(i);
            Integer prioroty = priority.get(op);
            if (prioroty>currentPriority){
                index=i;
                currentPriority=prioroty;
            }
        }
        return index;
    }

    private String oneOperation(String oneStr, String operation, String twoStr) throws CalcExeption {
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
}
