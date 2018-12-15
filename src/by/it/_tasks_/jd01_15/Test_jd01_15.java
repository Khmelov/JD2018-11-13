package by.it._tasks_.jd01_15;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_15 {

    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        Test_jd01_15 run = run("");
        StringBuilder sb = new StringBuilder();
        //читаем файл с числами
        try (BufferedReader inp = new BufferedReader(
                (new FileReader(dir(Test_jd01_15.class) + "matrix.txt"))
        );
        ) {
            String line;
            int count = 0;
            while ((line = inp.readLine()) != null) {
                assertEquals("Ожидается длина строк в 16 символов", 16, line.length());
                assertEquals("Ожидается 4 числа, разделенных пробелом", 4, line.trim().split("\\s+").length);
                run.include(line);
                count++;
            }
            assertEquals("Ожидается 6 строк", 6, count);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        run("");
        String s1 = getText("TaskB.txt").trim();
        String s2 = s1.replaceAll("(?s)/\\*.*?\\*/", "(это было удалено тестом)");
        String s3 = s1.replaceAll("//[^\\n]*+", "(это было удалено тестом)\\\n");
        assertTrue("Удалены не все многострочные комментарии", s1.equals(s2));
        assertTrue("Удалены не все однострочные комментарии", s1.equals(s3));

        String s0 = getText("TaskB.java").trim();
        s0 = s0.replaceAll("(?s)/\\*.*?\\*/", "");
        s0 = s0.replaceAll("//[^\\n]*+", "");
        char[] ch0 = s0.replaceAll("\r", "").toCharArray();
        char[] ch1 = s1.replaceAll("\r", "").toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] == ch0[i])
                System.out.print(ch1[i]);
            else
                fail("expected <<" + ch1[i] + ">>, actual <<" + ch0[i] + ">>");
            System.out.flush();
        }
    }


    @Test(timeout = 1500)
    public void testTaskC() throws Exception {
        run("dir\n" +
                "end\n").include("TaskC.java")
                .include("Test_jd01_15.java");
        run("cd ..\n" +
                "cd ..\n" +
                "dir\n" +
                "cd _tasks_\n" +
                "cd jd01_15\n" +
                "dir\n" +
                "end\n")
                .include("_tasks_")
                .include("Test_jd01_15.java");
    }

    private String getText(String fn) throws Exception {
        Scanner scanner = new Scanner(new File(dir(Test_jd01_15.class) + fn));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) sb.append(scanner.nextLine() + "\n");
        scanner.close();
        return sb.toString();
    }


    private static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" + cl.getName().replace(cl.getSimpleName(), "").replace(".", "/");
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
    private static Test_jd01_15 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_15 run(String in, boolean runMain) {
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
        return new Test_jd01_15(clName, in, runMain);
    }

    public Test_jd01_15() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;

    //Основной конструктор тестов
    private Test_jd01_15(String className, String in, boolean runMain) {
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
    private Test_jd01_15 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Test_jd01_15 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Test_jd01_15 exclude(String str) {
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
