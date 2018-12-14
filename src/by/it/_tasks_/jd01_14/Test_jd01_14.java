package by.it._tasks_.jd01_14;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_14 {

    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        Test_jd01_14 run = run("");
        StringBuilder sb = new StringBuilder();
        //читаем файл с числами
        try (DataInputStream inp = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(dir(Test_jd01_14.class) + "dataTaskA.bin"))
                );
        ) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                sb.append(i + " ");
                sum = sum + i;
                count++;
            }
            run.include(sb.toString().trim()); //проверка строки из 20 чисел
            run.include("avg=" + sum / count); //проверка вывода среднего арифметического

            Scanner scanner = new Scanner(new File(dir(Test_jd01_14.class) + "resultTaskA.txt"));
            //проверка соответсвия вывода и содержимого файла отчета resultTaskA.txt
            while (scanner.hasNext()) {
                run.include(scanner.nextLine());
            }
            scanner.close();
        }
    }

    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        Test_jd01_14 run = run("");
        run.include("words=157"); //слов должно быть 157
        run.include("marks=32");  //знаков должно быть 32 (исправлено 21.01.2018)
        StringBuilder sb = new StringBuilder();
        //читаем файл с числами
        Scanner scanner = new Scanner(new File(dir(Test_jd01_14.class) + "resultTaskB.txt"));
        //проверка соответствия вывода и содержимого файла отчета resultTaskB.txt
        while (scanner.hasNext()) {
            run.include(scanner.nextLine());
        }
        scanner.close();
    }

    @Test(timeout = 1500)
    public void testTaskC() throws Exception {
        Test_jd01_14 run = run("");
        showDir(dir(Test_jd01_14.class)+"..",run);
        Scanner scanner = new Scanner(new File(dir(Test_jd01_14.class) + "resultTaskC.txt"));
        //проверка соответствия вывода и содержимого файла отчета resultTaskC.txt
        scanner.nextLine(); //пропуск потенциально возможного dir:..
        while (scanner.hasNext()) {
            run.include(scanner.nextLine());
        }
        scanner.close();
    }

    private static void showDir(String path, Test_jd01_14 run) {
        File p = new File(path);
        String name = p.getName();
        if (p.isFile()) {
            run.include("file:" + name); //имя файла (должно быть с расширением)
        } else if (p.isDirectory()) {
            if (!name.equals(".") && !name.equals("..")) //fix
                run.include("dir:" + name); //имя каталога, .git - тоже каталог
            File[] paths = p.listFiles();
            if (paths != null)
                for (File iterator : paths) {
                    showDir(iterator.getAbsolutePath(),run);
                }
        }
    }

    static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" + cl.getName().replace(cl.getSimpleName(), "").replace(".", "/");
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
    private static Test_jd01_14 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_14 run(String in, boolean runMain) {
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
        return new Test_jd01_14(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_14() {
        //Конструктор тестов
    }

    //переменные теста
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //исходный поток вывода
    private PrintStream newOut; //поле для перехвата потока вывода
    private StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_14(String className, String in, boolean runMain) {
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
    private Test_jd01_14 is(String str) {
        assertTrue("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_14 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_14 exclude(String str) {
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