package by.it.akhmelev.jd01_05;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_05 {

    @Test(timeout = 5000)
    public void testTaskA1__TaskA() throws Exception {
        System.out.println("Ожидается -11392.************");
        run("").include("4516");
    }

    @Test(timeout = 5000)
    public void testTaskA2__TaskA() throws Exception {
        System.out.println("Ожидается -3.10***********78");
        run("").include("10653");
    }

    @Test(timeout = 5000)
    public void testTaskA3__TaskA() throws Exception {
        System.out.println("Ожидается:\n" +
                "При a= -5,00 f=17,2**0\n" +
                "При a= -1,25 f=4,3***0\n" +
                "При a=  2,50 f=1,3***7e+13\n" +
                "При a=  6,25 f=6,9***1e+32\n" +
                "При a= 10,00 f=3,5***3e+52\n");
        run("").include("3125");
    }

    @Test(timeout = 5000)
    public void testTaskB1__TaskB() throws Exception {
        System.out.println("Ожидается:\n" +
                "При a=0,00 Сумма y = 6,****48e+00\n" +
                "При a=0,20 Сумма y = 9,****87e+00\n" +
                "При a=0,40 Сумма y = 1,****09e+01\n" +
                "При a=0,60 Сумма y = 1,****22e+01\n" +
                "При a=0,80 Сумма y = 2,****31e+01\n" +
                "При a=1,00 Сумма y = 4,****65e+01\n" +
                "При a=1,20 Сумма y = 6,****12e+01\n" +
                "При a=1,40 Сумма y = 9,****72e+01\n" +
                "При a=1,60 Сумма y = 1,****77e+02\n" +
                "При a=1,80 Сумма y = 1,****33e+02\n" +
                "При a=2,00 Сумма y = 2,****56e+02\n");
        run("").include("2756");
    }

    @Test(timeout = 5000)
    public void testTaskB2__TaskB() throws Exception {
        System.out.println("Ожидается:\n" +
                "При x/2=-2,75 вычисления не определены\n" +
                "При x/2=-2,50 вычисления не определены\n" +
                "При x/2=-2,25 вычисления не определены\n" +
                "При x/2=-2,00 вычисления не определены\n" +
                "При x/2=-1,75 a = 3,****62e-01\n" +
                "При x/2=-1,50 a = 4,****25e-01\n" +
                "При x/2=-1,25 a = 4,****95e-01\n" +
                "При x/2=-1,00 a = 2,****60e-01\n" +
                "При x/2=-0,75 a = 3,****82e-01\n" +
                "При x/2=-0,50 a = 5,****39e-01\n" +
                "При x/2=-0,25 a = 5,****66e-01\n" +
                "При x/2=0,00 a = 5,****16e-01\n" +
                "При x/2=0,25 вычисления не определены\n" +
                "При x/2=0,50 вычисления не определены\n" +
                "При x/2=0,75 вычисления не определены");
        run("").include("8540");
    }

    @Test(timeout = 5000)
    public void testTaskC1__TaskC() throws Exception {
        System.out.println("Ожидается\n" +
                "Массив A[]\n" +
                "A[ 0 ] = 3,****8    A[ 1 ] = 3,**985    A[ 2 ] = 3,29494    A[ 3 ] = 3,33986    A[ 4 ] = 3,38461    \n" +
                "A[ 5 ] = 3,****8    A[ 6 ] = 3,**356    A[ 7 ] = 3,51777    A[ 8 ] = 3,56179    A[ 9 ] = 3,60564    \n" +
                "A[ 10] = 3,****0    A[ 11] = 3,**278    A[ 12] = 3,73608    A[ 13] = 3,77921    A[ 14] = 3,82215    \n" +
                "A[ 15] = 3,****2    A[ 16] = 3,**751    A[ 17] = 3,94993    A[ 18] = 3,99217    A[ 19] = 4,03425    \n" +
                "A[ 20] = 4,****5    A[ 21] = 4,**788    A[ 22] = 4,15945    A[ 23] = 4,20085    A[ 24] = 4,24209    \n" +
                "A[ 25] = 4,****6    A[ 26] = 4,**408    A[ 27] = 4,36483    \n" +
                "\n" +
                "Массив B[] из элементов массива A > 3.5\n" +
                "B[ 0 ] = 3,****7    B[ 1 ] = 3,****9    B[ 2 ] = 3,****4    B[ 3 ] = 3,****0    B[ 4 ] = 3,****8    \n" +
                "B[ 5 ] = 3,****8    B[ 6 ] = 3,****1    B[ 7 ] = 3,****5    B[ 8 ] = 3,****2    B[ 9 ] = 3,****1    \n" +
                "B[ 10] = 3,****3    B[ 11] = 3,****7    B[ 12] = 4,****5    B[ 13] = 4,****5    B[ 14] = 4,****8    \n" +
                "B[ 15] = 4,15945    B[ 16] = 4,20085    B[ 17] = 4,24209    B[ 18] = 4,28316    B[ 19] = 4,32408    \n" +
                "B[ 20] = 4,36483 ");
        run("").include("2045");
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
    private static Test_jd01_05 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_05 run(String in, boolean runMain) {
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
        return new Test_jd01_05(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_05() {
        //Конструктор тестов
    }

    //переменные теста
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //исходный поток вывода
    private PrintStream newOut; //поле для перехвата потока вывода
    private StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_05(String className, String in, boolean runMain) {
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
    private Test_jd01_05 is(String str) {
        assertTrue("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_05 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_05 exclude(String str) {
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
