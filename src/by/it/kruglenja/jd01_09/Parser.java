package by.it.kruglenja.jd01_09;

import by.it.medvedeva.jd01_07.Var;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final Map<String, Integer> priority = new HashMap<String, Integer>(){
        {
            put("=", 0);
            put("+", 1);
            put("-", 1);
            put("/", 2);
            put("*", 2);
        }
    };

    public String calc(String expression) throws CalcExeption {
        List<String> asList = Arrays.asList(expression.split(Patterns.OPERATIONS));
        List <String> operand = new ArrayList<>(asList);
        List <String> operations = new ArrayList<>();

        Pattern p = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = p.matcher(expression);

        while (matcher.find()){
            operations.add(matcher.group());
        }
        if (operations.size() == 0){
            return Var.createVar(expression).toString();
        }
        while (operations.size() > 0){
            int pior = getPriority(operations);
        }


        //TODO Generate error
        return null;
    }
}
