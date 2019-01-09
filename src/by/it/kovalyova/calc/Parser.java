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

    String simplecalc(String operand1, String operation, String operand2 ) throws CalcException {

        Var one = Var.createVar(operand1);
        Var two = Var.createVar(operand2);
        if (one == null || two == null) {
            throw new NullPointerException();
            //return ""; //TODO create error
        }
        try {
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
            System.out.println(e.getMessage());
        }
        return null;
    }
    String calc(String expr) throws CalcException {


        //throw new CalcException("Неизвестная операция " + expr);
        return null;
    }

    String testvar (String expr) throws CalcException {
        Pattern id = Pattern.compile(Patterns.ID);
        Matcher m = id.matcher(expr);
        if (m.matches()) {
            String sid = m.group(1);
            Var val = vars.get(sid);
            if (val == null) {
                throw new CalcException("Не найдена переменная " + sid);
            }
            return val.toString();
        } else {
            return expr;
        }
    }
    String simpleexpr(String expr) throws CalcException {
        Pattern fullop = Pattern.compile(Patterns.FULLOP);
        Pattern op = Pattern.compile(Patterns.OPERATION);

        if (!op.matcher(expr).find()) {
            //нет операции - переменная или значение
            return testvar(expr);
        }
        Matcher m = fullop.matcher(expr);
        if (m.matches()) {
            if (op.matcher(m.group(1)).find()) {
                //если операция не одна, повторяем рекурсивно начиная с последней
                return simpleexpr(simpleexpr(m.group(1))+m.group(2)+m.group(3));
            } else {
                return simplecalc(testvar(m.group(1)),m.group(2),testvar(m.group(3)));
            }
        }
        return null;
    }


    String parse(String expr) {

        //удаляем пробелы
        expr=expr.trim().replaceAll("\\s+","");
        //все выражения в скобках заменяем на их значения
        Pattern prts = Pattern.compile(Patterns.PRTS);
        Matcher m;
        try {
            while ((m = prts.matcher(expr)).matches()) {
                expr = m.group(1) + simpleexpr(m.group(2)) + m.group(3);
            }
            Pattern assign = Pattern.compile(Patterns.ASSIGN);
            m = assign.matcher(expr);
            if (m.matches()) {

                String s = simpleexpr(m.group(2));
                vars.put(m.group(1), Var.createVar(s));
                return s;

            }

        } catch(CalcException e) {
            return e.getMessage();
        }
        return null;

    }
}
