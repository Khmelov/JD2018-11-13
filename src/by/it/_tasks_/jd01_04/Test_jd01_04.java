package by.it._tasks_.jd01_04;


import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_04 {

    @Test(timeout = 5000)
    public void testTaskA1_printMulTable__TaskA() throws Exception {
        Test_jd01_04 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static printMulTable");
        m.setAccessible(true);
        m.invoke(null);
        ok
                .include("2*2=4  2*3=6  2*4=8  2*5=10 2*6=12 2*7=14 2*8=16 2*9=18")
                .include("3*2=6  3*3=9  3*4=12 3*5=15 3*6=18 3*7=21 3*8=24 3*9=27")
                .include("4*2=8  4*3=12 4*4=16 4*5=20 4*6=24 4*7=28 4*8=32 4*9=36")
                .include("5*2=10 5*3=15 5*4=20 5*5=25 5*6=30 5*7=35 5*8=40 5*9=45")
                .include("6*2=12 6*3=18 6*4=24 6*5=30 6*6=36 6*7=42 6*8=48 6*9=54")
                .include("7*2=14 7*3=21 7*4=28 7*5=35 7*6=42 7*7=49 7*8=56 7*9=63")
                .include("8*2=16 8*3=24 8*4=32 8*5=40 8*6=48 8*7=56 8*8=64 8*9=72")
                .include("9*2=18 9*3=27 9*4=36 9*5=45 9*6=54 9*7=63 9*8=72 9*9=81");

        System.out.println("Проверка таблицы умножения завершена");
    }

    @Test(timeout = 5000)
    public void testTaskA2_buildOneDimArray__TaskA() throws Exception {
        Test_jd01_04 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static buildOneDimArray", String.class);
        m.invoke(null, "123 99 88 77 66 5 4 3 1 0 2");
        ok.include("V[").include("]=0").include("]=123");
        ok.include("first element=10");
        ok.include("last element=2");
        System.out.println("Проверка обработки массива завершена");
    }

    @Test(timeout = 5000)
    public void testTaskA3_run_main__TaskA() throws Exception {
        Test_jd01_04 ok = run("123 99 88 77 66 5 4 3 1 0 2");
        ok
                .include("2*2=4  2*3=6  2*4=8  2*5=10 2*6=12 2*7=14 2*8=16 2*9=18")
                .include("3*2=6  3*3=9  3*4=12 3*5=15 3*6=18 3*7=21 3*8=24 3*9=27")
                .include("4*2=8  4*3=12 4*4=16 4*5=20 4*6=24 4*7=28 4*8=32 4*9=36")
                .include("5*2=10 5*3=15 5*4=20 5*5=25 5*6=30 5*7=35 5*8=40 5*9=45")
                .include("6*2=12 6*3=18 6*4=24 6*5=30 6*6=36 6*7=42 6*8=48 6*9=54")
                .include("7*2=14 7*3=21 7*4=28 7*5=35 7*6=42 7*7=49 7*8=56 7*9=63")
                .include("8*2=16 8*3=24 8*4=32 8*5=40 8*6=48 8*7=56 8*8=64 8*9=72")
                .include("9*2=18 9*3=27 9*4=36 9*5=45 9*6=54 9*7=63 9*8=72 9*9=81");
        ok.include("V[").include("]=0").include("]=123");
        ok.include("first element=10");
        ok.include("last element=2");
        System.out.println("Проверка метода main завершена");
    }

    @Test(timeout = 5000)
    public void testTaskB1_inputSalary__TaskB() throws Exception {
        run("3\n" +
                "Ivanov\n" +
                "Petrov\n" +
                "Sidorov\n" +
                "11 11 13 15\n" +
                "15 16 17 18 \n" +
                "19 20 11 12 \n")
                .include("Ivanov").include("Petrov").include("Sidorov")
                .include("11").include("13").include("13").include("13")
                .include("15").include("16").include("17").include("18")
                .include("19").include("20").include("11").include("12")
        ;
    }

    @Test(timeout = 5000)
    public void testTaskB2_sumAndAvg__TaskB() throws Exception {
        run("3\n" +
                "Ivanov\n" +
                "Petrov\n" +
                "Sidorov\n" +
                "11 11 13 15\n" +
                "15 16 17 18 \n" +
                "19 20 11 12 \n")
                .include("178")
                .include("14").include("833")
        ;
    }

    @Test(timeout = 5000)
    public void testTaskC1_mergeSort__TaskC() throws Exception {
        Test_jd01_04 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mergeSort", double[].class);
        double[] act = new double[15];
        double[] exp = new double[15];
        for (int i = 0; i < act.length; i++) {
            act[i] = Math.random() * 31 - 15;
            exp[i] = act[i];
        }
        m.invoke(null, act);  //тестируемая сортировка
        Arrays.sort(exp);        //ожидаемая сортировка
        System.out.println("   Yours array:" + Arrays.toString(act));
        System.out.println("Expected array:" + Arrays.toString(exp));
        assertArrayEquals("Сортировка работает неверно", exp, act, 1e-10);
        System.out.println("Проверка сортировки завершена");
    }

    @Test(timeout = 5000)
    public void testTaskC2_binarySearch__TaskC() throws Exception {
        Test_jd01_04 ok = run("", false);

        Method m = checkMethod(ok.aClass.getSimpleName(), "static binarySearch", double[].class, double.class);
        double[] d = new double[15];
        for (int i = 0; i < d.length; i++) {
            d[i] = Math.random() * 31 - 15;
        }
        Arrays.sort(d);
        System.out.println("Test massiv:" + Arrays.toString(d));
        for (int i = 0; i < d.length; i++) {

            int expected = Arrays.binarySearch(d, d[i]);
            int actual = (int) m.invoke(null, d, d[i]);
            assertEquals("Поиск работает неверно", expected, actual);

        }
        System.out.println("Проверка бинарного поиска завершена");

        m = checkMethod(ok.aClass.getSimpleName(), "static buildOneDimArray", String.class);
        m.invoke(null, "123 99 88 77 66 5 4 3 1 0 2");
        ok.include("V[").include("]=0").include("]=123");
        ok.include("first element=10");
        ok.include("last element=2");
        System.out.println("Проверка buildOneDimArray завершена");

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
    private static Test_jd01_04 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_04 run(String in, boolean runMain) {
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
        return new Test_jd01_04(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_04() {
        //Конструктор тестов
    }

    //переменные теста
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //исходный поток вывода
    private PrintStream newOut; //поле для перехвата потока вывода
    private StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_04(String className, String in, boolean runMain) {
        //this.className = className;
        aClass = null;
        try {
            aClass = Class.forName(className);
            this.className = className;

        } catch (ClassNotFoundException e) {
            fail("ERROR:Не найден класс " + className + "/n");
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
    private Test_jd01_04 is(String str) {
        assertTrue("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_04 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_04 exclude(String str) {
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
                if (pos==0 && b=='\r') //пропуск \r (чтобы win mac и linux одинаково работали
                    return;
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
