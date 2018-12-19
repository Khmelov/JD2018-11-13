package by.it.markelov.jd01_13;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_13 {

    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        StringBuilder sb = new StringBuilder("\n--- all starts ---\n");
        for (int i = 0; i < 15; i++) {
            sb.append("run ").append(i).append(": ")
                    .append(run("")
                            .include("java.lang.")
                            .include("Exception")
                            .include("line:")
                            .include(".TaskA")
                            .stringWriter.toString());
        }
        assertTrue("В выводе нет NumberFormatException", sb.toString().contains("NumberFormatException"));
        assertTrue("В выводе нет NullPointerException", sb.toString().contains("NullPointerException"));
        System.out.println(sb);
    }

    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        run("2\n3\n4\n55\nEND\n")
                .include("1.41")
                .include("2.23")
                .include("8.0")
                .exclude("Exception")
        ;
        run("foo\nEND\n")
                .include("NumberFormatException")
                .exclude("ArithmeticException")
                .include("line:")
                .include(".jd01_13.TaskB")
        ;
        run("-2.0\n6.0\nEND\n")
                .include("ArithmeticException")
                .include("line:")
                .include(".jd01_13.TaskB")
                .exclude("NumberFormatException")
        ;
    }


    @Test(timeout = 6000, expected = Exception.class)
    public void testTaskC() throws Exception {

        long t = System.currentTimeMillis();
        Test_jd01_13 instance = run("1\n2\nerr1\n3\n4\nerr2\nerr3\nerr4\nerr5\n5.0\nerr6");
        instance.include("4.0 3.0 2.0 1.0").exclude("5.0");
        t = System.currentTimeMillis()-t;
        System.out.println(t);
        assertTrue("Таймаут работает неверно. Ошибка диапазона (400 ms <= your t:"+t+" <= 2000 ms)", (t > 400 && t < 2000));
        Method method=instance.findMethod(instance.aClass,"readData");
        method.setAccessible(true);
        method.invoke(null); //читаем 5.0 - ок
        method.invoke(null); //читаем err6 - тут ждем любую ошибку
        fail("метод readData не генерирует никаких исключений после 5 ошибок");
    }


    /*
    ===========================================================================================================
    НИЖЕ ВСПОМОГАТЕЛЬНЫЙ КОД ТЕСТОВ. НЕ МЕНЯЙТЕ В ЭТОМ ФАЙЛЕ НИЧЕГО.
    Но изучить как он работает - можно, это всегда будет полезно.
    ===========================================================================================================
     */

    private Class findClass(String SimpleName) {
        String full = this.getClass().getName();
        String dogPath = full.replace(this.getClass().getSimpleName(), SimpleName);
        try {
            return Class.forName(dogPath);
        } catch (ClassNotFoundException e) {
            fail("\nТест не пройден. Класс " + SimpleName + " не найден.");
        }
        return null;
    }

    public Method checkMethod(String className, String methodName, Class<?>... parameters) throws Exception {
        Class aClass = this.findClass(className);
        try {
            methodName = methodName.trim();
            Method m;
            if (methodName.startsWith("static")) {
                methodName = methodName.replace("static", "").trim();
                m = aClass.getDeclaredMethod(methodName, parameters);
                if ((m.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                    fail("\nМетод " + m.getName() + " должен быть статическим");
                }
            } else
                m = aClass.getDeclaredMethod(methodName, parameters);
            m.setAccessible(true);
            return m;

        } catch (NoSuchMethodException e) {
            System.err.print("\nНе найден метод " + methodName + " либо у него неверная сигнатура");
            System.err.print("\nОжидаемый класс: " + className);
            System.err.print("\nОжидаемый метод: " + methodName);
            return null;
        }
    }

    private Method findMethod(Class<?> cl, String name, Class... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nТест не пройден. Метод " + cl.getName() + "." + name + " не найден");
        }
        return null;
    }

    private Object invoke(Method method, Object o, Object... value) {
        try {
            return method.invoke(o, value);
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("\nНе удалось вызвать метод " + method.getName());
        }
        return null;
    }


    //метод находит и создает класс для тестирования
    //по имени вызывающего его метода, testTaskA1 будет работать с TaskA1
    private static Test_jd01_13 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_13 run(String in, boolean runMain) {
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
        System.out.println("Старт теста для " + clName + "\ninput:" + in);
        System.out.println("---------------------------------------------");
        return new Test_jd01_13(clName, in, runMain);
    }

    public Test_jd01_13() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;

    //Основной конструктор тестов
    private Test_jd01_13(String className, String in, boolean runMain) {
        //this.className = className;
        aClass = null;
        try {
            aClass = Class.forName(className);
            this.className = className;

        } catch (ClassNotFoundException e) {
            fail("Не найден класс " + className);
        }
        reader = new StringReader(in); //заполнение ввода
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return reader.read();
            }
        };
        System.setIn(inputStream);   //перехват ввода

        System.setOut(newOut); //перехват стандартного вывода

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
    private Test_jd01_13 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Test_jd01_13 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Test_jd01_13 exclude(String str) {
        assertTrue("Лишние данные в выводе: " + str + "\n", !stringWriter.toString().contains(str));
        return this;
    }


    //переменные теста
    private StringWriter stringWriter = new StringWriter();
    private PrintStream oldOut = System.out;
    private StringReader reader;


    //поле для перехвата потока вывода
    private PrintStream newOut;

    {
        newOut = new PrintStream(new OutputStream() {
            private byte bytes[] = new byte[2];

            @Override
            public void write(int b) throws IOException {
                if (b < 0) { //ловим и собираем двухбайтовый UTF (первый код > 127, или в байте <0)
                    if (bytes[0] == 0) { //если это первый байт
                        bytes[0] = (byte) b; //то запомним его
                    } else {
                        bytes[1] = (byte) b; //иначе это второй байт
                        String s = new String(bytes); //соберем весь символ
                        stringWriter.append(s); //запомним вывод для теста
                        oldOut.append(s); //копию в обычный вывод
                        bytes[0] = 0; //забудем все.
                    }
                } else {
                    char c = (char) b; //ловим и собираем однобайтовый UTF
                    bytes[0] = 0;
                    if (c != '\r') {
                        stringWriter.write(c); //запомним вывод для теста
                    }
                    oldOut.write(c); //копию в обычный вывод
                }
            }
        });
    }
}
