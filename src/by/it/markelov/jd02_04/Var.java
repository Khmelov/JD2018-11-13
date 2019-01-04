package by.it.markelov.jd02_04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    static Map<String, Var> vars = new HashMap<>();
    private static String fileName = Util.getPath("vars.txt");

    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("сложение " + this + "+" + other + " невозможно");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("вычетание " + this + "-" + other + " невозможно");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("умножение " + this + "*" + other + " невозможно");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("деление " + this + "/" + other + " невозможно");

    }

    static void setVar(String key, Var value) {
        vars.put(key, value);
    }

    static Var createVar(String operand) throws CalcException {
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        Var var = vars.get(operand);
        if (var == null)
            throw new CalcException("Неивестная переменная " + operand);
        return var;
    }

    static void save() throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new
                FileWriter(fileName))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                printWriter.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        }
    }

    static void readVarFile() throws IOException, CalcException {
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new
                    FileReader(file))) {
                Parser local = new Parser();
                while (bufferedReader.ready()) {
                    local.calc(bufferedReader.readLine());
                }
            }
        }
    }
}
