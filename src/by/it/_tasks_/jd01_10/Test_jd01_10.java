package by.it._tasks_.jd01_10;


import org.junit.Test;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_10 {


    @Test(timeout = 5000)
    public void testTaskA1__Param() throws Exception {
        Class<?> anno = findClass("Param");
        findMethod(anno, "a");
        findMethod(anno, "b");
        System.out.println("OK");
    }


    private double check(Method method) throws Exception {
        if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
            return (double) method.invoke(null, 5, 6);
        } else {
            Object instance = findClass("Bean").getDeclaredConstructor().newInstance();
            return (double) method.invoke(instance, 5, 6);
        }
    }

    @Test(timeout = 5000)
    public void testTaskA2__Bean() throws Exception {
        Class<?> bean = findClass("Bean");
        Class<? extends Annotation> anno = findClass("Param");
        Method sum = findMethod(bean, "sum", int.class, int.class);
        assertEquals("sum incorrect", 11, check(sum), 1e-10);
        Method max = findMethod(bean, "max", int.class, int.class);
        assertEquals("max incorrect", 6, check(max), 1e-10);
        Method min = findMethod(bean, "min", int.class, int.class);
        assertEquals("min incorrect", 5, check(min), 1e-10);
        Method avg = findMethod(bean, "avg", int.class, int.class);
        assertEquals("avg incorrect", 5.5, check(avg), 1e-10);
        int countAnnotation = 0;
        int countStatic = 0;
        int countNonStatic = 0;
        for (Method method : bean.getDeclaredMethods()) {
            if (method.isAnnotationPresent(anno))
                countAnnotation++;
            if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
                countStatic++;
            else
                countNonStatic++;
        }
        assertTrue("Ожидается, что число аннотированных методов будет 3 или больше", countAnnotation >= 3);
        assertTrue("Ожидается, что не все методы аннотировны", countAnnotation < countNonStatic + countStatic);
        assertTrue("Ожидается, что число статических методов будет 2 или больше", countStatic >= 2);
        assertTrue("Ожидается, что число нестатических методов будет 2 или больше", countNonStatic >= 2);
        System.out.println("OK");
    }


    @Test(timeout = 5000)
    public void testTaskB1__PrintMath() throws Exception {
        System.out.println("");

        run("")
                .include("public static float abs(float)")
                .include("public static double abs(double)")
                .include("public static int abs(int)")
                .include("public static long abs(long)")
                .include("public static double sin(double)")
                .include("public static double cos(double)")
                .include("public static double tan(double)")
                .include("public static double atan2(double,double)")
                .include("public static double sqrt(double)")
                .include("public static double log(double)")
                .include("public static double log10(double)")
                .include("public static double pow(double,double)")
                .include("public static double exp(double)")
                .include("public static int min(int,int)")
                .include("public static long min(long,long)")
                .include("public static float min(float,float)")
                .include("public static double min(double,double)")
                .include("public static float max(float,float)")
                .include("public static long max(long,long)")
                .include("public static int max(int,int)")
                .include("public static double max(double,double)")
                .include("public static long addExact(long,long)")
                .include("public static int addExact(int,int)")
                .include("public static int decrementExact(int)")
                .include("public static long decrementExact(long)")
                .include("public static int incrementExact(int)")
                .include("public static long incrementExact(long)")
                .include("public static int multiplyExact(int,int)")
                .include("public static long multiplyExact(long,long)")
                .include("public static int negateExact(int)")
                .include("public static long negateExact(long)")
                .include("public static long subtractExact(long,long)")
                .include("public static int subtractExact(int,int)")
                .include("public static float scalb(float,int)")
                .include("public static double scalb(double,int)")
                .include("public static float copySign(float,float)")
                .include("public static double copySign(double,double)")
                .include("public static int getExponent(double)")
                .include("public static int getExponent(float)")
                .include("public static double signum(double)")
                .include("public static float signum(float)")
                .include("public static double asin(double)")
                .include("public static double acos(double)")
                .include("public static double atan(double)")
                .include("public static double toRadians(double)")
                .include("public static double toDegrees(double)")
                .include("public static double cbrt(double)")
                .include("public static double ceil(double)")
                .include("public static double floor(double)")
                .include("public static double rint(double)")
                .include("public static long round(double)")
                .include("public static int round(float)")
                .include("public static double random()")
                .include("public static int toIntExact(long)")
                .include("public static double sinh(double)")
                .include("public static double cosh(double)")
                .include("public static double tanh(double)")
                .include("public static double hypot(double,double)")
                .exclude("static double powerOfTwoD(int)")
                .exclude("static float powerOfTwoF(int)")

                .include("double E")
                .include("double PI")
                .exclude("DEGREES_TO_RADIANS")
                .exclude("RADIANS_TO_DEGREES")
                .exclude("negativeZeroFloatBits")
                .exclude("negativeZeroDoubleBits")
                .exclude("twoToTheDoubleScaleUp")
                .exclude("twoToTheDoubleScaleDown")
                ;
        System.out.println("OK");
    }

    @Test(timeout = 5000)
    public void testTaskB2__PrintString() throws Exception {
        run("")
                .include("equals")
                .include("length")
                .include("toString")
                .include("hashCode")
                .include("getChars")
                .include("compareTo")
                .include("isEmpty")
                .include("charAt")
                .include("codePointAt")
                .include("codePointBefore")
                .include("codePointCount")
                .include("getBytes")
                .include("contentEquals")
                .include("nonSyncContentEquals")
                .include("equalsIgnoreCase")
                .include("compareToIgnoreCase")
                .include("regionMatches")
                .include("startsWith")
                .include("endsWith")
                .include("substring")
                .include("subSequence")
                .include("concat")
                .include("replace")
                .include("matches")
                .include("contains")
                .include("replaceFirst")
                .include("replaceAll")
                .include("split")
                .include("toLowerCase")
                .include("toUpperCase")
                .include("trim")
                .include("toCharArray")
                .include("intern")

                .exclude("checkIndex")
                .exclude("rangeCheck")
                .exclude("format")
                .exclude("copyValueOf")
                .exclude("checkOffset")
                .exclude("checkBoundsOffCount")
                .exclude("checkBoundsBeginEnd")

        ;
        System.out.println("OK");
    }


    @Test(timeout = 5000)
    public void testTaskC1__BeanTester() throws Exception {
        Test_jd01_10 run = run("", true);
        Class<?> bean = findClass("Bean");
        Class<? extends Annotation> anno = findClass("Param");
        Method a = anno.getMethod("a");
        Method b = anno.getMethod("b");
        Object instance = bean.getDeclaredConstructor().newInstance();
        Method[] methods = bean.getDeclaredMethods();
        System.out.println();

        int countAnnotation = 0;
        for (Method method : methods) {
            System.out.println("Проверка метода: " + method.getName());
            System.out.flush();
            if (method.isAnnotationPresent(anno)) {
                countAnnotation++;
                Annotation an = method.getAnnotation(anno);
                int aValue = (int) a.invoke(an);
                int bValue = (int) b.invoke(an);
                String name = method.getName();
                double result;
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    result = (double) method.invoke(null, aValue, bValue);
                } else {
                    result = (double) method.invoke(instance, aValue, bValue);
                }
                System.out.println("Для " + method.getName() + " ожидается " + result);
                System.out.flush();
                run.include(method.getName());
                run.include(String.valueOf(result));
            } else {
                System.out.println("Для " + method.getName() + " не должно быть вызова (он не аннотирован)");
                run.exclude(method.getName());
            }
            System.out.println("Проверка метода " + method.getName() + " завершена.");
            System.out.flush();
        }

        assertTrue("Ожидается, что число аннотированных методов будет 3 или больше", countAnnotation >= 3);
        assertTrue("Ожидается, что не все методы аннотировны", countAnnotation < methods.length);
        System.out.println("OK");
    }

    /*
===========================================================================================================
НИЖЕ ВСПОМОГАТЕЛЬНЫЙ КОД ТЕСТОВ. НЕ МЕНЯЙТЕ В ЭТОМ ФАЙЛЕ НИЧЕГО.
Но изучить как он работает - можно, это всегда будет полезно.
===========================================================================================================
 */
    //-------------------------------  методы ----------------------------------------------------------
    private Class findClass(String SimpleName) {
        String full = this.getClass().getName();
        String dogPath = full.replace(this.getClass().getSimpleName(), SimpleName);
        try {
            return Class.forName(dogPath);
        } catch (ClassNotFoundException e) {
            fail("\nERROR:Тест не пройден. Класс " + SimpleName + " не найден.");
        }
        return null;
    }

    private Method checkMethod(String className, String methodName, Class<?>... parameters) throws Exception {
        Class aClass = this.findClass(className);
        try {
            methodName = methodName.trim();
            Method m;
            if (methodName.startsWith("static")) {
                methodName = methodName.replace("static", "").trim();
                m = aClass.getDeclaredMethod(methodName, parameters);
                if ((m.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                    fail("\nERROR:Метод " + m.getName() + " должен быть статическим");
                }
            } else
                m = aClass.getDeclaredMethod(methodName, parameters);
            m.setAccessible(true);
            return m;

        } catch (NoSuchMethodException e) {
            System.err.println("\nERROR:Не найден метод " + methodName + " либо у него неверная сигнатура");
            System.err.println("ERROR:Ожидаемый класс: " + className);
            System.err.println("ERROR:Ожидаемый метод: " + methodName);
            return null;
        }
    }

    private Method findMethod(Class<?> cl, String name, Class... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nERROR:Тест не пройден. Метод " + cl.getName() + "." + name + " не найден\n");
        }
        return null;
    }

    private Object invoke(Method method, Object o, Object... value) {
        try {
            method.setAccessible(true);
            return method.invoke(o, value);
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("\nERROR:Не удалось вызвать метод " + method.getName() + "\n");
        }
        return null;
    }


    //метод находит и создает класс для тестирования
    //по имени вызывающего его метода, testTaskA1 будет работать с TaskA1
    private static Test_jd01_10 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_10 run(String in, boolean runMain) {
        Throwable t = new Throwable();
        StackTraceElement trace[] = t.getStackTrace();
        StackTraceElement element;
        int i = 0;
        do {
            element = trace[i++];
        }
        while (!element.getMethodName().contains("test"));

        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = clName.replaceFirst(".+__", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName);
        if (!in.isEmpty()) System.out.println("input:" + in);
        System.out.println("---------------------------------------------");
        return new Test_jd01_10(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_10() {
        //Конструктор тестов
    }

    //переменные теста
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //исходный поток вывода
    private PrintStream newOut; //поле для перехвата потока вывода
    private StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_10(String className, String in, boolean runMain) {
        //this.className = className;
        aClass = null;
        try {
            aClass = Class.forName(className);
            this.className = className;

        } catch (ClassNotFoundException e) {
            fail("ERROR:Не найден класс " + className + "\n");
        }
        InputStream reader = new ByteArrayInputStream(in.getBytes());
        System.setIn(reader);   //перехват стандартного ввода
        System.setOut(newOut);  //перехват стандартного вывода

        if (runMain) //если нужно запускать, то запустим, иначе оставим только вывод
            try {
                Class[] argTypes = new Class[]{String[].class};
                Method main = aClass.getDeclaredMethod("main", argTypes);
                main.invoke(null, (Object) new String[]{});
                System.setOut(oldOut); //возврат вывода, нужен, только если был запуск
            } catch (Exception x) {
                x.printStackTrace();
            }
    }


    //проверка вывода
    private Test_jd01_10 is(String str) {
        assertTrue("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_10 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_10 exclude(String str) {
        assertTrue("ERROR:Лишние данные в выводе: " + str + "\n", !strOut.toString().contains(str));
        return this;
    }


    //логический блок перехвата вывода
    {
        newOut = new PrintStream(new OutputStream() {
            private byte bytes[] = new byte[1];
            private int pos = 0;

            @Override
            public void write(int b) throws IOException {
                if (pos == 0 && b == '\r') //пропуск \r (чтобы win mac и linux одинаково работали
                    return;
                //ок. теперь можно делать разбор
                if (pos == 0) { //определим кодировку https://ru.wikipedia.org/wiki/UTF-8
                    if ((b & 0b11110000) == 0b11110000) bytes = new byte[4];
                    else if ((b & 0b11100000) == 0b11100000) bytes = new byte[3];
                    else if ((b & 0b11000000) == 0b11000000) bytes = new byte[2];
                    else bytes = new byte[1];
                }
                bytes[pos++] = (byte) b;
                if (pos == bytes.length) { //символ готов
                    String s = new String(bytes); //соберем весь символ
                    strOut.append(s); //запомним вывод для теста
                    oldOut.append(s); //копию в обычный вывод
                    pos = 0; //готовим новый символ
                }
            }
        });
    }
}
