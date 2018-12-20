package by.it.naumenko.Calculator;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    static Map<String, Var> vars = new HashMap<>();
    private static String filename = Util.getPath("vars.txt");

    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption("сложение " + this + "+" + other + " невозможно");

    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption("вычетание " + this + "-" + other + " невозможно");
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption("умножение " + this + "*" + other + " невозможно");
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption("деление " + this + "/" + other + " невозможно");

    }

    static void setVar(String key, Var value) {
        vars.put(key, value);
    }

    static Var createVar(String operand) throws CalcExeption {
        if (operand.matches(Paterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Paterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Paterns.MATRIX))
            return new Matrix(operand);
        Var var = vars.get(operand);
        if (var == null)
            throw new CalcExeption("Неивестная переменная " + operand);
        return var;
    }

    static void save() throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new
                FileWriter(filename))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                printWriter.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        }
    }

    static void readVarFile() throws IOException, CalcExeption {
        File file = new File(filename);
        if (file.exists()) {
            try(BufferedReader bufferedReader = new BufferedReader(new
                    FileReader(file))) {
                Parcer local = new Parcer();
                while (bufferedReader.ready()){
                    local.calc(bufferedReader.readLine());
                }
            }
        }

    }
}
