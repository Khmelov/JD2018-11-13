package by.it._tasks_.jd01_03;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_03 {

    @Test(timeout = 5000)
    public void testTaskA1__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        checkMethod(ok.aClass.getSimpleName(), "static getArray", String.class);
        double[] expArr = {0.1, 0.2, -0.2, -0.1};
        Method m = ok.aClass.getDeclaredMethod("getArray", String.class);
        System.out.println("Проверка ввода для массива вида:");
        System.out.println("0.1 0.2 -0.2 -0.1");
        double[] arr = (double[]) ok.invoke(m, null, new Object[]{"0.1 0.2 -0.2 -0.1"});
        assertArrayEquals("Неверно работает ввод", expArr, arr, 1e-9);
        System.out.println("Проверка ввода для массива завершена успешно");
    }

    @Test(timeout = 5000)
    public void testTaskA2_printSimple__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        checkMethod(ok.aClass.getSimpleName(), "static printArray", double[].class);
        Method m = ok.aClass.getDeclaredMethod("printArray", double[].class);
        System.out.println("Проверка вывода для массива:");
        double[] arr = {1, 2, 3, 4};
        ok.invoke(m, null, new Object[]{arr});
        for (double a : arr) {
            //перевод в Integer т.к. заранее неизвестно с printf или прямо будет сделан вывод
            ok.include(Integer.toString((int) a));
        }
        System.out.println("Проверка вывода для массива завершена успешно");
    }

    @Test(timeout = 5000)
    public void testTaskA3_printWithNameAndCol__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static printArray", double[].class, String.class, int.class);
        System.out.println("Проверка вывода для массива:");
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        ok.invoke(m, null, arr, "Massiv", 2);
        System.out.println("\n\nFind out with printf for:");
        for (double a : arr) {
            //перевод в Integer т.к. заранее неизвестно с printf или прямо будет сделан вывод
            String sf = String.format("%.1f", a);
            System.out.print(sf + " | ");
            ok.include(sf);
        }
        System.out.println("\nCheck printf ok");
        ok.include("\n").include("Massiv");
        System.out.println("Проверка вывода для массива завершена успешно");
        //тут можно проверку на число колонок сделать, но это не факт, что будет просто
    }

    @Test(timeout = 5000)
    public void testTaskB1_findMin__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static findMin", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double min = (double) ok.invoke(m, null, arr);
        Arrays.sort(arr);
        assertEquals("Минимум найден неверно", arr[0], min, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskB2_findMax__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static findMax", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double min = (double) ok.invoke(m, null, arr);
        Arrays.sort(arr);
        assertEquals("Максимум найден неверно", arr[arr.length - 1], min, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskB3_sort__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static sort", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double[] sorted = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        System.out.println("Исходный  массив:" + Arrays.toString(arr));
        Arrays.sort(sorted);
        System.out.println("Ожидается массив:" + Arrays.toString(sorted));
        ok.invoke(m, null, arr);
        System.out.println("  Получен массив:" + Arrays.toString(arr));
        assertArrayEquals("Неверно работает сортировка", sorted, arr, 1e-9);
        System.out.println("OK. Массив отсортирован");
    }

    @Test(timeout = 5000)
    public void testTaskC1_mulMatrixAndVector__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mul", double[][].class, double[].class);
        System.out.println("Проверим произведение матрицы и вектора");
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[] vector = {1, 2, 3};
        double[] res = (double[]) ok.invoke(m, null, matrix, vector);
        double[] exp = {
                1 * 1 + 2 * 2 + 3 * 3,
                4 * 1 + 5 * 2 + 6 * 3
        };
        System.out.println("{{1,2,3},{4,5,6}}*{1,2,3}={14,32}");
        System.out.println("Ожидается массив " + Arrays.toString(exp));
        assertArrayEquals("Произведение найдено неверно", exp, res, 1e-10);
        System.out.println("Проверка завершена успешно.");
    }


    @Test(timeout = 5000)
    public void testTaskC2_mulMatrixAndMatrix__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mul", double[][].class, double[][].class);
        System.out.println("Проверим произведение матрицы и матрицы");
        double[][] left = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] right = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        double[][] res = (double[][]) ok.invoke(m, null, left, right);
        double[][] exp = {
                {22, 28},
                {49, 64}
        };
        System.out.println("{{1,2,3},{4,5,6}}*{{1,2},{3,4},{5,6}}={{22,28},{49,64}}");
        for (int i = 0; i < exp.length; i++) {
            System.out.println("Ожидается:  " + Arrays.toString(exp[i]));
            System.out.println("Рассчитано: " + Arrays.toString(res[i]));
            assertArrayEquals("Произведение найдено неверно", exp[i], res[i], 1e-10);
        }
        System.out.println("\nПроверка завершена успешно.");
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
    private static Test_jd01_03 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_03 run(String in, boolean runMain) {
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
        return new Test_jd01_03(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_03() {
        //Конструктор тестов
    }

    //переменные теста
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //исходный поток вывода
    private PrintStream newOut; //поле для перехвата потока вывода
    private StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_03(String className, String in, boolean runMain) {
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
    private Test_jd01_03 is(String str) {
        assertTrue("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_03 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_03 exclude(String str) {
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
