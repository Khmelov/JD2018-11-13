package by.it.baidak.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    private static String filename = Util.getPath("vars.txt");


    @Override
    public abstract Var add(Var other);

    @Override
    public abstract Var sub(Var other);

    @Override
    public abstract Var mul(Var other);

    @Override
    public abstract Var div(Var other) throws CalcException;

    public static Var createVar(String operand) throws CalcException {
        VarCreator creator;
        if (operand.matches(Patterns.SCALAR)){
            creator = new ScalarCreator();
            return creator.createVar(operand);}
        if (operand.matches(Patterns.VECTOR)){
            creator = new VectorCreator();
            return creator.createVar(operand);}
        Var var = vars.get(operand);
        if (var == null)
            throw new CalcException("НЕ УДАЛОСЬ СОЗДАТЬ ПЕРЕМЕННУЮ: " + operand);
        return var;
    }

    static void save() {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                out.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        } catch (IOException e) {
            System.err.print("Disk Error");
        }
    }

    public static void read() {
        File file = new File(filename);
        if (file.exists())
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                Parser local = new Parser();
                while (in.ready()) {
                    local.calc(in.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    static void setVar(String key, Var value) {
        vars.put(key, value);
    }
}
