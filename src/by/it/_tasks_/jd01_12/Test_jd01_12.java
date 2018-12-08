package by.it._tasks_.jd01_12;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_12 {

    static final String text =
            "\n" +
                    "Nadine Gordimer \n" +
                    "\n" +
                    "\n" +
                    "Nadine Gordimer \n" +
                    "\n" +
                    "Once upon a Time \n" +
                    "\n" +
                    "Someone has written to ask me to contribute to an anthology of stories for children. I \n" +
                    "reply that I don't write children's stories; and he writes back that at a recent congress/book \n" +
                    "fair/seminar a certain novelist said every writer ought to write at least one story for \n" +
                    "children. I think of sending a postcard saying I don't accept that I \"ought\" to write anything. \n" +
                    "\n" +
                    "And then last night I woke up — or rather was awakened without knowing what had \n" +
                    "roused me. \n" +
                    "\n" +
                    "A voice in the echo-chamber of the subconscious? \n" +
                    "\n" +
                    "A sound. \n" +
                    "\n" +
                    "A creaking of the kind made by the weight carried by one foot after another along a \n" +
                    "wooden floor. I listened. I felt the apertures of my ears distend with concentration. Again: \n" +
                    "the creaking. I was waiting for it; waiting to hear if it indicated that feet were moving from \n" +
                    "room to room, coming up the passage — to my door. I have no burglar bars, no gun under the \n" +
                    "pillow, but I have the same fears as people who do take thse precautions, and my \n" +
                    "windowpanes are thin as rime, could shatter like a wineglass. A woman was murdered (how \n" +
                    "do they put it) in broad daylight in a house two blocks away, last year, and the fierce dogs \n" +
                    "who guarded an old widower and his collection of antique clocks were strangled before he \n" +
                    "was knifed by a casual laborer he had dismissed without pay. \n" +
                    "\n" +
                    "I was staring at the door, making it out in my mind rather than seeing it, in the dark. I lay quite \n" +
                    "still — a victim already — the arrhythmia of my heart was fleeing, knocking this way and that \n" +
                    "against its body-cage. How finely tuned the senses are, just out of rest, sleep! I could never listen \n" +
                    "intently as that in the distractions of the day, I was reading every faintest sound, identifying and \n" +
                    "classifying its possible threat. \n" +
                    "\n" +
                    "But I learned that I was to be neither threatened nor spared. There was no human weight \n" +
                    "pressing on the boards, the creaking was a buckling, an epicenter of stress. I was in it. The house \n" +
                    "that surrounds me while I sleep is built on undermined ground; far beneath my bed, the floor, the \n" +
                    "house's foundations, the stopes and passages of gold mines have hollowed the rock, and when some \n" +
                    "face trembles, detaches and falls, three thousand feet below, the whole house shifts slightly, \n" +
                    "bringing uneasy strain to the balance and counterbalance of brick, cement, wood and glass that hold it \n" +
                    "as a structure around me. The misbeats of my heart tailed off like the last muffled flourishes on one \n" +
                    "of the wooden xylophones made by the Chopi and T songa 1 migrant miners who might have been \n" +
                    "down there, under me in the earth at that moment. The stope where the fall was could have been \n" +
                    "disused, dripping water from its ruptured veins; or men might now be interred there in the most \n" +
                    "profound of tombs. \n" +
                    "\n" +
                    "I couldn't find a position in which my mind would let go of my body — release me to sleep \n" +
                    "again. So I began to tell myself a story, a bedtime story. \n" +
                    "\n" +
                    "In a house, in a suburb, in a city, there were a man and his wife who loved each other very much \n" +
                    "and were living happily ever after. They had a little boy, and they loved him very much. They had \n" +
                    "a cat and a dog that the little boy loved very much. They had a car and a caravan trailer for \n" +
                    "holidays, and a swimming-pool which was fenced so that the little boy and his playmates would \n" +
                    "not fall in and drown. They had a housemaid who was absolutely trustworthy and an itinerant \n" +
                    "gardener who was highly recommended by the neighbors. For when they began to live happily ever \n" +
                    "after they were warned, by that wise old witch, the husband's mother, not to take on anyone off the \n" +
                    "street. They were inscribed in a medical benefit society, their pet dog was licensed, they were \n" +
                    "insured against fire, flood damage and theft, and subscribed to the local Neighborhood Watch, \n" +
                    "which supplied them with a plaque for their gates lettered Y OU HAVE BEEN WARNED \n" +
                    "over the silhouette of a would-be intruder. He was masked; it could not be said if he was \n" +
                    "black or white, and therefore proved the property owner was no racist. \n" +
                    "\n" +
                    "It was not possible to insure the house, the swimming pool or the car against riot \n" +
                    "damage. There were riots, but these were outside the city, where people of another color \n" +
                    "were quartered. These people were not allowed into the suburb except as reliable\n" +
                    "end\n";

    @Test(timeout = 1500)
    public void testTaskA1() throws Exception {
        Class<?> aclass = findClass("TaskA1");
        Method m = findMethod(aclass, "clearBad", List.class);
        Integer[] grades = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(grades));
        Object instance = aclass.getDeclaredConstructor().newInstance();
        System.out.println("Дано: " + list);
        System.out.flush();
        m.setAccessible(true);
        m.invoke(instance, list);
        assertEquals("Метод clearBad реализован неверно", "[4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4]", list.toString());
        System.out.println("Итог: " + list);
        System.out.flush();
    }

    @Test(timeout = 1500)
    public void testTaskA2() throws Exception {
        Class<?> aclass = findClass("TaskA2");
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        System.out.println("Проверка на множестве " + a + " и множестве " + b);
        System.out.flush();

        Method union = findMethod(aclass, "getUnion", Set.class, Set.class);
        union.setAccessible(true);
        assertEquals("Метод getUnion работает некорректно",
                "[1, 2, 3, 4, 5, 6, 7, 8, 9]",
                new TreeSet<Integer>((Collection<? extends Integer>) union.invoke(null, a, b)).toString());

        Method cross = findMethod(aclass, "getCross", Set.class, Set.class);
        cross.setAccessible(true);
        assertEquals("Метод getCross работает некорректно",
                "[4, 5, 6]",
                new TreeSet<Integer>((Collection<? extends Integer>) cross.invoke(null, a, b)).toString());
        System.out.println("прошла успешно.");
    }


    @Test(timeout = 1500)
    public void testTaskA3() throws Exception {
        run("-1\n2\n-3\n4\n-5\n6\n-7\n8\n-9\n0\n9\n-8\n7\n-6\n5\n-4\n3\n-2\n1\n0\nend")
                .include("2, 4, 6, 8, 9, 7, 5, 3, 1, 0, 0, -1, -3, -5, -7, -9, -8, -6, -4, -2");
    }

    @Test(timeout = 12000)
    public void testTaskB1() throws Exception {
        run(text)
                .include("been=2")
                .include("BEEN=1")
                .include("I=21")
                .include("don't=2")
                .include("year=1")
                .include("at=4")
                .include("much=3")
                .include("proved=1")
                .include("same=1")
                .include("T=1")
                .include("hollowed=1")
                .include("veins=1")
                .include("strangled=1")
                .include("laborer=1")
                .include("which=3")
                .include("pay=1")
                .include("its=3")
                .include("profound=1")
                .include("take=2")
                .include("therefore=1")
                .include("little=3")
                .include("identifying=1")
                .include("waiting=2")
                .include("rather=2")
                .include("for=5")
                .include("intently=1")
                .include("just=1")
                .include("blocks=1")
                .include("go=1")
                .include("room=2")
                .include("with=2")
                .include("there=3")
                .include("he=4")
                .include("bedtime=1")
                .include("supplied=1")
                .include("could=4")
                .include("drown=1")
                .include("that=13")
                .include("than=1")
                .include("me=6")
                .include("below=1")
                .include("my=9")
                .include("heart=2")
                .include("And=1")
                .include("were=11")
                .include("position=1")
                .include("no=4")
                .include("around=1")
                .include("boy=3")
                .include("house's=1")
                .include("and=24")
                .include("of=18")
                .include("before=1")
                .include("sound=2")
                .include("said=2")
                .include("stories=2")
                .include("reliable=1")
        ;
    }

    @Test(timeout = 1500)
    public void testTaskB2() throws Exception {
        Class<?> aclass = findClass("TaskB2");
        Method mA = findMethod(aclass, "process", ArrayList.class);
        mA.setAccessible(true);
        Method mL = findMethod(aclass, "process", LinkedList.class);
        mL.setAccessible(true);
        int[] expectedRes = {1, 1, 3, 1, 3, 5, 7, 1, 3, 5, 7, 9, 11, 13, 15, 1};
        for (int n = 1; n <= expectedRes.length; n++) {
            ArrayList<String> arra = new ArrayList<>();
            LinkedList<String> arrl = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                arra.add("n" + i);
                arrl.add("n" + i);
            }
            System.out.println("ArrayList=" + arra);
            System.out.flush();
            System.out.println("LinkedList=" + arrl);
            System.out.flush();
            assertEquals("Методы возвращают разные результаты", mA.invoke(null, arra), mL.invoke(null, arrl));
            assertEquals("Метод c ArrayList работает неверно", mA.invoke(null, arra), "n" + expectedRes[n - 1]);
            System.out.println("  process(ArrayList  arr)=" + "n" + expectedRes[n - 1]);
            System.out.flush();
            assertEquals("Метод с LinkedList работает неверно", mL.invoke(null, arrl), "n" + expectedRes[n - 1]);
            System.out.println("  process(LinkedList arr)=" + "n" + expectedRes[n - 1]);
            System.out.flush();
        }
        System.out.println("OK");
    }

    @Test(timeout = 1500)
    public void testTaskB3() throws Exception {
        Class<?> aclass = findClass("TaskB3");
        Method mA = findMethod(aclass, "process", ArrayList.class);
        mA.setAccessible(true);
        Method mL = findMethod(aclass, "process", LinkedList.class);
        mL.setAccessible(true);
        int[] expectedRes = new int[4096];
        expectedRes[expectedRes.length - 1] = 1;
        int n = expectedRes.length;
        ArrayList<String> arra = new ArrayList<>(n);
        LinkedList<String> arrl = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arra.add("n" + i);
            arrl.add("n" + i);
        }
        Long t=System.nanoTime();
        String rA= (String) mA.invoke(null, arra);
        Long tA=System.nanoTime()-t;

        t=System.nanoTime();
        String rL= (String) mL.invoke(null, arrl);
        Long tL=System.nanoTime()-t;

        assertEquals("Метод c ArrayList  работает неверно", rA, "n" + expectedRes[n - 1]);
        assertEquals("Метод с LinkedList работает неверно", rL, "n" + expectedRes[n - 1]);

        System.out.println(" Время работы для  ArrayList="+tA/1000+" мкс."); System.out.flush();
        System.out.println(" Время работы для LinkedList="+tL/1000+" мкс."); System.out.flush();

        assertTrue(" Время работы для  ArrayList должно быть существенно больше LinkedList",tA>tL*12/10);

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
    private static Test_jd01_12 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_12 run(String in, boolean runMain) {
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
        return new Test_jd01_12(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_12() {
        //Конструктор тестов
    }

    //переменные теста
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //исходный поток вывода
    private PrintStream newOut; //поле для перехвата потока вывода
    private StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_12(String className, String in, boolean runMain) {
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
    private Test_jd01_12 is(String str) {
        assertTrue("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_12 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_12 exclude(String str) {
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
