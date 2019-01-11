package by.it.mnovikov.calc2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by user on 27.11.2018.
 */
abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    private static String filename = Util.getPath("vars.txt");

    static Var createVar(String operand) throws CalcException {
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
//        if (operand.matches(Patterns.MATRIX)){
//            return new Matrix(operand);
//        }
        Var var = vars.get(operand);
        if (var == null)
            throw new CalcException("Unknown var: " + operand);
        return var;
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
                    BufferedReader in = new BufferedReader(new FileReader(file));
            ) {
                Parcer local = new Parcer();
                while (in.ready()) {
                    local.calc(in.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CalcException e) {
                e.getStackTrace();
            }
    }

    static void setVar(String key, Var value) {
        vars.put(key, value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }

    public Var() {

    }

    @Override
    public String toString() {
        return "this Var";
    }
}
