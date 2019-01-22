package by.it.lobkova.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    private static String filename = Util.getPath("vars.txt");

    static void setVar(String key, Var value) {
        vars.put(key, value);
    }

    static Var createVar(String operand) throws CalcException {
        if (operand.matches(Patterns.SCALAR)) return VarMaker.SCALAR.create(operand);
        if (operand.matches(Patterns.VECTOR)) return VarMaker.VECTOR.create(operand);
        if (operand.matches(Patterns.MATRIX)) return VarMaker.MATRIX.create(operand);
        return vars.get(operand);
    }

    static void save() {

        try (PrintWriter out
                     = new PrintWriter(new FileWriter(filename))) {
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
            try (
                    BufferedReader in = new BufferedReader(
                            new FileReader(file))
            ) {
                Parcer local = new Parcer();
                while (in.ready()) {
                    local.calc(in.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CalcException e) {
                e.printStackTrace();
            }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение " + this + " и " + other + " невозможно");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        System.out.println("Вычитание " + this + " + " + other + " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        System.out.println("Умножение " + this + " + " + other + " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.println("Деление " + this + " + " + other + " невозможно");
        return null;
    }

    @Override
    public String toString() {
        return "this Var";
    }

    static void writeLogAndThrowException(String text) throws CalcException {
        Logger.getInstance().add("ERROR: " + text);
        Report.reportBuilder.addException("CalcException", text);
        throw new CalcException(text);
    }

}


