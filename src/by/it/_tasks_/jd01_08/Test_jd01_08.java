package by.it._tasks_.jd01_08;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_08 {

    @Test(timeout = 5000)
    public void testTaskA0_constructors__Scalar() throws Exception {
        Test_jd01_08 ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        System.out.println("Создание переменной типа Scalar на основе числа 0.12345");
        Object scalar = c.newInstance(0.12345);
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", scalar.toString(), "0.12345");
        System.out.println("выполнено успешно. Scalar=" + scalar);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        c = ok.aClass.getDeclaredConstructor(double.class);
        scalar = c.newInstance(0.12345);
        c = ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Scalar на основе объекта Scalar(0.12345)");
        scalar = c.newInstance(scalar);
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", scalar.toString(), "0.12345");
        System.out.println("выполнено успешно. Scalar=" + scalar);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        c = ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Scalar на основе строки 0.12345");
        scalar = c.newInstance("0.12345");
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", scalar.toString(), "0.12345");
        System.out.println("выполнено успешно. Scalar=" + scalar);
    }


    @Test(timeout = 5000)
    public void testTaskA1_add__Scalar() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        Object v1 = c.newInstance(1.23);
        Object v2 = c.newInstance(4.56);
        Class<?> var = v2.getClass().getSuperclass();
        String op = "add";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        double res = Double.parseDouble(v3.toString());
        assertEquals("Операция 1.23 + 4.56 работает некорректно", 5.79, res, 1e-10);
    }


    @Test(timeout = 5000)
    public void testTaskA2_sub__Scalar() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        Object v1 = c.newInstance(1.23);
        Object v2 = c.newInstance(4.56);
        Class<?> var = v2.getClass().getSuperclass();
        String op = "sub";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        double res = Double.parseDouble(v3.toString());
        assertEquals("Операция 1.23 - 4.56 работает некорректно", -3.33, res, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskA3_mul__Scalar() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        Object v1 = c.newInstance(1.23);
        Object v2 = c.newInstance(4.56);
        Class<?> var = v2.getClass().getSuperclass();
        String op = "mul";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        double res = Double.parseDouble(v3.toString());
        assertEquals("Операция 1.23 * 4.56 работает некорректно", 5.6088, res, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskA4_div__Scalar() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double.class);
        Object v1 = c.newInstance(1.23);
        Object v2 = c.newInstance(4.56);
        Class<?> var = v2.getClass().getSuperclass();
        String op = "div";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        double res = Double.parseDouble(v3.toString());
        assertEquals("Операция 1.23 / 4.56 работает некорректно", 0.269736842105263, res, 1e-10);
    }


    @Test(timeout = 5000)
    public void testTaskB0_constructors__Vector() throws Exception {
        Test_jd01_08 ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        System.out.println("Создание переменной типа Vector на основе массива {1,2,4}");
        Object vector = c.newInstance(new double[]{1, 2, 4});
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", vector.toString(), "{1.0, 2.0, 4.0}");
        System.out.println("выполнено успешно. Vector=" + vector);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        c = ok.aClass.getDeclaredConstructor(double[].class);
        vector = c.newInstance(new double[]{1, 2, 4});
        c = ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Vector на основе объекта Vector({1,2,4})");
        vector = c.newInstance(vector);
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", vector.toString(), "{1.0, 2.0, 4.0}");
        System.out.println("выполнено успешно. Vector=" + vector);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        c = ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Vector на основе строки {1,2,4}");
        vector = c.newInstance("{1,2,4}");
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", vector.toString(), "{1.0, 2.0, 4.0}");
        System.out.println("выполнено успешно. Vector=" + vector);
    }


    @Test(timeout = 5000)
    public void testTaskB1_add__Vector() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        Object v1 = c.newInstance(new double[]{1, 2, 3});
        Object v2 = c.newInstance(new double[]{4, 5, 6});
        Class<?> var = v2.getClass().getSuperclass();
        String op = "add";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {1,2,3} + {4,5,6} работает некорректно", "{5.0, 7.0, 9.0}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(1.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {1,2,3} + 1.0 работает некорректно", "{2.0, 3.0, 4.0}", v3.toString());
    }

    @Test(timeout = 5000)
    public void testTaskB2_sub__Vector() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        Object v1 = c.newInstance(new double[]{1, 2, 3});
        Object v2 = c.newInstance(new double[]{4, 5, 6});
        Class<?> var = v2.getClass().getSuperclass();
        String op = "sub";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {1,2,3} - {4,5,6} работает некорректно", "{-3.0, -3.0, -3.0}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(1.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {1,2,3} - 1.0 работает некорректно", "{0.0, 1.0, 2.0}", v3.toString());
    }

    @Test(timeout = 5000)
    public void testTaskB3_mul__Vector() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        Object v1 = c.newInstance(new double[]{1, 2, 3});
        Object v2 = c.newInstance(new double[]{4, 5, 6});
        Class<?> var = v2.getClass().getSuperclass();
        String op = "mul";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Скалярное произведение векторов {1,2,3} * {4,5,6} работает некорректно", "32.0", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(2.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {1,2,3} * 2.0 работает некорректно", "{2.0, 4.0, 6.0}", v3.toString());

    }

    @Test(timeout = 5000, expected = Exception.class)
    public void testTaskB4_div__Vector() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(double[].class);
        Object v1 = c.newInstance(new double[]{1, 2, 3});
        Object v2 = c.newInstance(new double[]{4, 5, 6});
        Class<?> var = v2.getClass().getSuperclass();
        String op = "div";
        Method m = findMethod(ok.aClass, op, var);

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        Object v4 = c.newInstance(2.0);
        Object v3 = invoke(m, v1, v4);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {1,2,3} / 2.0 работает некорректно", "{0.5, 1.0, 1.5}", v3.toString());


        v3 = invoke(m, v1, v2);
        if (v3 != null)
            fail("Деление векторов должно возвращать null или генерировать какую-то ошибку");
        else
            throw new NullPointerException("Ок. Получен null при делении векторов");
    }


    @Test(timeout = 5000)
    public void testTaskC0_constructors__Matrix() throws Exception {
        Test_jd01_08 ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        Constructor c = ok.aClass.getDeclaredConstructor(double[][].class);
        System.out.println("Создание переменной типа Matrix на основе массива {{1,2},{3,4}}");
        Object matrix = c.newInstance(new Object[]{new double[][]{{1, 2}, {3, 4}}});
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", matrix.toString().replaceAll(" ", ""), "{{1.0,2.0},{3.0,4.0}}");
        System.out.println("выполнено успешно. Matrix=" + matrix);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());

        c = ok.aClass.getDeclaredConstructor(double[][].class);
        matrix = c.newInstance(new Object[]{new double[][]{{1, 2}, {3, 4}}});
        c = ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Matrix на основе объекта Matrix({{1,2},{3,4}})");
        matrix = c.newInstance(matrix);
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", matrix.toString().replaceAll(" ", ""), "{{1.0,2.0},{3.0,4.0}}");
        System.out.println("выполнено успешно. Matrix=" + matrix);
        ///-----------------------------------------------------------------------------------------------
        ok = run("", false);
        assertEquals("У вас неверное наследование", "Var", ok.aClass.getSuperclass().getSimpleName());
        c = ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Matrix на основе строки {{1,2},{3,4}}");
        matrix = c.newInstance("{{1,2},{3,4}}");
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", matrix.toString().replaceAll(" ", ""), "{{1.0,2.0},{3.0,4.0}}");
        System.out.println("выполнено успешно. Matrix=" + matrix);
    }

    @Test(timeout = 5000)
    public void testTaskС1_add__Matrix() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(String.class);
        Object v1 = c.newInstance("{{1, 2}, {3, 4}}");
        Object v2 = c.newInstance("{{4, 5}, {7, 8}}");
        Class<?> var = v2.getClass().getSuperclass();
        String op = "add";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {{1, 2}, {3, 4}} + {{4, 5}, {7, 8}} работает некорректно", "{{5.0, 7.0}, {10.0, 12.0}}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(1.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {{1, 2}, {3, 4}} + 1.0 работает некорректно", "{{2.0, 3.0}, {4.0, 5.0}}", v3.toString());
    }

    @Test(timeout = 5000)
    public void testTaskС2_sub__Matrix() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(String.class);
        Object v1 = c.newInstance("{{1, 2}, {3, 4}}");
        Object v2 = c.newInstance("{{4, 5}, {7, 8}}");
        Class<?> var = v2.getClass().getSuperclass();
        String op = "sub";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {{1, 2}, {3, 4}} - {{4, 5}, {7, 8}} работает некорректно",
                "{{-3.0, -3.0}, {-4.0, -4.0}}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(1.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {{1, 2}, {3, 4}} - 1.0 работает некорректно",
                "{{0.0, 1.0}, {2.0, 3.0}}", v3.toString());
    }

    @Test(timeout = 5000)
    public void testTaskС3_mul__Matrix() throws Exception {
        Test_jd01_08 ok = run("", false);
        Constructor c = ok.aClass.getDeclaredConstructor(String.class);
        Object v1 = c.newInstance("{{1, 2}, {3, 4}}");
        Object v2 = c.newInstance("{{4, 5}, {7, 8}}");
        Class<?> var = v2.getClass().getSuperclass();
        String op = "mul";
        Method m = findMethod(ok.aClass, op, var);
        Object v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + " вернул null");
        assertEquals("Операция {{1, 2}, {3, 4}} * {{4, 5}, {7, 8}} работает некорректно",
                "{{18.0, 21.0}, {40.0, 47.0}}", v3.toString());

        ///проверка операции с вектором
        c = findClass("Vector").getDeclaredConstructor(double[].class);
        v2 = c.newInstance(new double[]{5, 6});
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "с вектором вернул null");
        assertEquals("Операция с вектором {{1, 2}, {3, 4}} * {5, 6} работает некорректно",
                "{17.0, 39.0}", v3.toString());

        ///проверка операции со скаляром
        c = findClass("Scalar").getDeclaredConstructor(double.class);
        v2 = c.newInstance(2.0);
        v3 = invoke(m, v1, v2);
        if (v3 == null) fail(op + "со скаляром вернул null");
        assertEquals("Операция со скаляром {{1, 2}, {3, 4}} * 2.0 работает некорректно",
                "{{2.0, 4.0}, {6.0, 8.0}}", v3.toString());
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
    private static Test_jd01_08 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_08 run(String in, boolean runMain) {
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
        return new Test_jd01_08(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_08() {
        //Конструктор тестов
    }

    //переменные теста
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //исходный поток вывода
    private PrintStream newOut; //поле для перехвата потока вывода
    private StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_08(String className, String in, boolean runMain) {
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
    private Test_jd01_08 is(String str) {
        assertTrue("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_08 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_08 exclude(String str) {
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
