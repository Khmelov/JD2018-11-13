package by.it.nickgrudnitsky.calc;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

abstract class Var implements Operation {
    static ResManager resManager = ResManager.INSTANCE;
    private static Map<String, Var> vars = new HashMap<>();

    static void printVar() {
        for (Map.Entry<String, Var> entry : vars.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static void sortVar() {
        SortedSet<String> sortedVars = new TreeSet<>();
        sortedVars.addAll(vars.keySet());
        for (String key : sortedVars) {
            System.out.println(key + "=" + vars.get(key));
        }

    }

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (vars.containsKey(operand)) {
            return vars.get(operand);
        }
        throw new CalcException(resManager.get(Errors.IMPOSSIBLETOCREATE) + operand);
    }

    static void saveTo() throws IOException {
        String fileName = Util.getPath("vars.txt");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                out.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        } catch (IOException e) {
            System.out.println(resManager.get(Errors.ERROR));
        }
    }

    static void read() {
        File file = new File(Util.getPath("vars.txt"));
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(
                    new FileReader(Util.getPath("vars.txt")))) {
                Parcer parser = new Parcer();
                while (in.ready()) {
                    parser.calcAndSave(in.readLine());
                }
            } catch (IOException | CalcException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(resManager.get(Errors.ADDOPERATION) + this + " + " + other + resManager.get(Errors.IMPOSSIBLE));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(resManager.get(Errors.SUBOPERATION) + this + " - " + other + resManager.get(Errors.IMPOSSIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(resManager.get(Errors.MULOPERATION) + this + " * " + other + resManager.get(Errors.IMPOSSIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(resManager.get(Errors.DIVOPERATION) + this + " / " + other + resManager.get(Errors.IMPOSSIBLE));
    }

    @Override
    public String toString() {
        return resManager.get(Errors.THISISABSTRACTVAR);
    }
}
