package by.it._tasks_.jd01_06;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_06 {

    @Test(timeout = 5000)
    public void testTaskA1() throws Exception {
        System.out.println("Ожидается:\n" +
                "У лук#мо#ья дуб зел#ны#,\n" +
                "Зла#ая цеп# на дуб# том.\n" +
                "И днё# и ноч#ю кот учё#ый\n" +
                "Всё ход#т по цеп# кру#ом.\n" +
                "Идё# нап#ав# - пес#ь зав#ди#,\n" +
                "Нал#во - ска#ку гов#ри#.\n" +
                "Там чуд#са: там леш#й бро#ит,\n" +
                "Рус#лк# на вет#ях сид#т.\n" +
                "Там на нев#до#ых дор#жк#х\n" +
                "Сле#ы нев#да#ных зве#ей.\n" +
                "Изб#шк# там на кур#их нож#ах\n" +
                "Сто#т без око#, без две#ей.\n" +
                "Там лес и дол вид#ни# пол#ы,\n" +
                "Там о зар# при#лы#ут вол#ы\n" +
                "На бре# пес#ан#й и пус#ой,\n" +
                "И три#ца#ь вит#зе# пре#ра#ных\n" +
                "Чре#ой из вод вых#дя# ясн#х,\n" +
                "И с ним# дяд#ка их мор#ко#.\n" +
                "Там кор#ле#ич мим#хо#ом\n" +
                "Пле#яе# гро#но#о цар#.\n" +
                "Там в обл#ка# пер#д нар#до#\n" +
                "Чер#з лес#, чер#з мор#\n" +
                "Кол#ун нес#т бог#ты#я.\n" +
                "В тем#иц# там цар#вн# туж#т,\n" +
                "А бур#й вол# ей вер#о слу#ит.\n" +
                "Там сту#а с Баб#ю Яго#\n" +
                "Идё#, бре#ёт сам# соб#й.\n" +
                "Там цар# Кащ#й над зла#ом чах#ет,\n" +
                "Там рус#ки# дух... там Рус#ю пах#ет!\n" +
                "И там я был, и мёд я пил,\n" +
                "У мор# вид#л дуб зел#ны#,\n" +
                "Под ним сид#л, и кот учё#ый\n" +
                "Сво# мне ска#ки гов#ри#.");

        run("").include("У лук#мо#ья дуб зел#ны#,\n" +
                "Зла#ая цеп# на дуб# том.\n" +
                "И днё# и ноч#ю кот учё#ый\n" +
                "Всё ход#т по цеп# кру#ом.\n" +
                "Идё# нап#ав# - пес#ь зав#ди#,\n" +
                "Нал#во - ска#ку гов#ри#.\n" +
                "Там чуд#са: там леш#й бро#ит,\n" +
                "Рус#лк# на вет#ях сид#т.\n" +
                "Там на нев#до#ых дор#жк#х\n" +
                "Сле#ы нев#да#ных зве#ей.\n" +
                "Изб#шк# там на кур#их нож#ах\n" +
                "Сто#т без око#, без две#ей.\n" +
                "Там лес и дол вид#ни# пол#ы,\n" +
                "Там о зар# при#лы#ут вол#ы\n" +
                "На бре# пес#ан#й и пус#ой,\n" +
                "И три#ца#ь вит#зе# пре#ра#ных\n" +
                "Чре#ой из вод вых#дя# ясн#х,\n" +
                "И с ним# дяд#ка их мор#ко#.\n" +
                "Там кор#ле#ич мим#хо#ом\n" +
                "Пле#яе# гро#но#о цар#.\n" +
                "Там в обл#ка# пер#д нар#до#\n" +
                "Чер#з лес#, чер#з мор#\n" +
                "Кол#ун нес#т бог#ты#я.\n" +
                "В тем#иц# там цар#вн# туж#т,\n" +
                "А бур#й вол# ей вер#о слу#ит.\n" +
                "Там сту#а с Баб#ю Яго#\n" +
                "Идё#, бре#ёт сам# соб#й.\n" +
                "Там цар# Кащ#й над зла#ом чах#ет,\n" +
                "Там рус#ки# дух... там Рус#ю пах#ет!\n" +
                "И там я был, и мёд я пил,\n" +
                "У мор# вид#л дуб зел#ны#,\n" +
                "Под ним сид#л, и кот учё#ый\n" +
                "Сво# мне ска#ки гов#ри#.");
    }

    @Test(timeout = 5000)
    public void testTaskA2() throws Exception {
        run("")
                .include("чахнет=1")
                .include("Под=1")
                .include("дубе=1")
                .include("бурый=1")
                .include("их=1")
                .include("бродит=1")
                .include("А=1")
                .include("над=1")
                .include("ним=1")
                .include("В=1")
                .include("через=1")
                .include("леса=1")
                .include("И=4")
                .include("У=2")
                .include("дядька=1")
                .include("сидит=1")
                .include("зелёный=2")
                .include("ходит=1")
                .include("грозного=1")
                .include("мёд=1")
                .include("в=1")
                .include("ветвях=1")
                .include("лес=1")
                .include("царь=1")
                .include("и=5")
                .include("леший=1")
                .include("царя=1")
                .include("Следы=1")
                .include("полны=1")
                .include("дверей=1")
                .include("сама=1")
                .include("Пленяет=1")
                .include("о=1")
                .include("волны=1")
                .include("с=2")
                .include("бредёт=1")
                .include("тридцать=1")
                .include("Через=1")
                .include("я=2")
                .include("был=1")
                .include("Колдун=1")
                .include("волк=1")
                .include("Кащей=1")
                .include("Свои=1")
                .include("видений=1")
                .include("служит=1")
                .include("русский=1")
                .include("прихлынут=1")
                .include("ступа=1")
                .include("морской=1")
                .include("Бабою=1")
                .include("Ягой=1")
                .include("кругом=1")
                .include("кот=2")
                .include("пустой=1")
                .include("пахнет=1")
                .include("заре=1")
                .include("народом=1")
                .include("вод=1")
                .include("ночью=1")
                .include("выходят=1")
                .include("собой=1")
                .include("Златая=1")
                .include("без=2")
                .include("окон=1")
                .include("перед=1")
                .include("дух=1")
                .include("Налево=1")
                .include("курьих=1")
                .include("богатыря=1")
                .include("мимоходом=1")
                .include("сидел=1")
                .include("том=1")
                .include("дуб=2")
                .include("пил=1")
                .include("на=4")
                .include("невиданных=1")
                .include("дорожках=1")
                .include("неведомых=1")
                .include("Избушка=1")
                .include("прекрасных=1")
                .include("королевич=1")
                .include("направо=1")
                .include("Русью=1")
                .include("ей=1")
                .include("верно=1")
                .include("Русалка=1")
                .include("ними=1")
                .include("днём=1")
                .include("На=1")
                .include("темнице=1")
                .include("учёный=2")
                .include("Там=9")
                .include("чудеса=1")
                .include("зверей=1")
                .include("Идёт=2")
                .include("облаках=1")
                .include("мне=1")
                .include("ножках=1")
                .include("лукоморья=1")
                .include("цепи=1")
                .include("Стоит=1")
                .include("несёт=1")
                .include("сказки=1")
                .include("царевна=1")
                .include("Всё=1")
                .include("видел=1")
                .include("песнь=1")
                .include("песчаный=1")
                .include("цепь=1")
                .include("там=5")
                .include("Чредой=1")
                .include("по=1")
                .include("тужит=1")
                .include("дол=1")
                .include("говорит=1")
                .include("златом=1")
                .include("моря=2")
                .include("заводит=1")
                .include("ясных=1")
                .include("витязей=1")
                .include("брег=1")
                .include("говорил=1")
                .include("сказку=1")
                .include("из=1");
    }


    @Test(timeout = 5000)
    public void testTaskB1() throws Exception {
        run("")
                .exclude("У")
                .include("лукоморья")
                .exclude("зелёный")
                .include("Златая")
                .exclude("цепь")
                .include("на")
                .include("дубе")
                .exclude("том")
                .exclude("днём")
                .include("ночью")
                .exclude("кот")
                .exclude("учёный")
                .include("Всё")
                .exclude("ходит")
                .include("цепи")
                .exclude("кругом")
                .exclude("Идёт")
                .include("направо")
                .exclude("песнь")
                .exclude("заводит")
                .include("Налево")
                .include("сказку")
                .exclude("говорит")
                .include("чудеса")
                .exclude("леший")
                .exclude("бродит")
                .include("Русалка")
                .exclude("ветвях")
                .exclude("сидит")
                .exclude("неведомых")
                .exclude("дорожках")
                .include("Следы")
                .exclude("невиданных")
                .exclude("зверей")
                .exclude("Избушка")
                .include("на")
                .exclude("курьих")
                .exclude("ножках")
                .exclude("Стоит")
                .exclude("окон")
                .exclude("дверей")
                .exclude("видений")
                .include("полны")
                .include("заре")
                .exclude("прихлынут")
                .include("волны")
                .include("На")
                .exclude("брег")
                .exclude("песчаный")
                .exclude("пустой")
                .exclude("тридцать")
                .exclude("витязей")
                .exclude("прекрасных")
                .exclude("Чредой")
                .exclude("выходят")
                .exclude("ясных")
                .include("ними")
                .include("дядька")
                .exclude("морской")
                .exclude("королевич")
                .exclude("мимоходом")
                .exclude("Пленяет")
                .include("грозного")
                .include("царя")
                .exclude("Там")
                .exclude("облаках")
                .exclude("перед")
                .exclude("народом")
                .exclude("Через")
                .include("леса")
                .exclude("через")
                .include("моря")
                .exclude("Колдун")
                .exclude("несёт")
                .include("богатыря")
                .include("темнице")
                .exclude("там")
                .include("царевна")
                .exclude("тужит")
                .exclude("бурый")
                .exclude("волк")
                .include("верно")
                .exclude("служит")
                .exclude("Там")
                .include("ступа")
                .include("Бабою")
                .exclude("Ягой")
                .exclude("Идёт")
                .exclude("бредёт")
                .include("сама")
                .exclude("собой")
                .exclude("царь")
                .exclude("Кащей")
                .exclude("златом")
                .exclude("чахнет")
                .exclude("русский")
                .include("Русью")
                .exclude("пахнет")
                .exclude("мёд")
                .include("моря")
                .exclude("видел")
                .exclude("зелёный")
                .exclude("сидел")
                .exclude("учёный")
                .include("Свои")
                .include("мне")
                .include("сказки")
                .exclude("говорил");

    }

    @Test(timeout = 5000)
    public void testTaskB2() throws Exception {
        System.out.println("Ожидается:\n" +
                "Там королевич мимоходом Пленяет грозного царя\n" +
                "Там ступа с Бабою Ягой Идёт бредёт сама собой\n" +
                "У лукоморья дуб зелёный Златая цепь на дубе том\n" +
                "Идёт направо песнь заводит Налево сказку говорит\n" +
                "Там на неведомых дорожках Следы невиданных зверей\n" +
                "И днём и ночью кот учёный Всё ходит по цепи кругом\n" +
                "Там чудеса там леший бродит Русалка на ветвях сидит\n" +
                "Избушка там на курьих ножках Стоит без окон без дверей\n" +
                "В темнице там царевна тужит А бурый волк ей верно служит\n" +
                "Там в облаках перед народом Через леса через моря Колдун несёт богатыря\n" +
                "Там лес и дол видений полны Там о заре прихлынут волны На брег песчаный и пустой И тридцать витязей прекрасных Чредой из вод выходят ясных И с ними дядька их морской\n" +
                "Там царь Кащей над златом чахнет Там русский дух\n" +
                "там Русью пахнет И там я был и мёд я пил У моря видел дуб зелёный Под ним сидел и кот учёный Свои мне сказки говорил\n");

        run("").include("" +
                        //проверка фрагмента растущих по длине предложений (не всех,
                        //равные по длине опускаем из-за неоднозначности,
                        //а также, есть разное понимание ... см. ниже)
                        "У лукоморья дуб зелёный Златая цепь на дубе том\n" +
                        "Идёт направо песнь заводит Налево сказку говорит\n" +
                        "Там на неведомых дорожках Следы невиданных зверей\n" +
                        "И днём и ночью кот учёный Всё ходит по цепи кругом\n" +
                        "Там чудеса там леший бродит Русалка на ветвях сидит\n" +
                        "Избушка там на курьих ножках Стоит без окон без дверей\n" +
                        "В темнице там царевна тужит А бурый волк ей верно служит\n" +
                        // тут спорное предложение: - Там царь Кащей над златом чахнет Там русский дух там Русью пахнет
                        //поэтому хвост комментируем
                        //"Там в облаках перед народом Через леса через моря Колдун несёт богатыря\n" +
                        //"Там лес и дол видений полны Там о заре прихлынут волны На брег песчаный и пустой И тридцать витязей прекрасных Чредой из вод выходят ясных И с ними дядька их морской\n"+
                        ""
        );
    }

    @Test(timeout = 5000)
    public void testTaskC1() throws Exception {
        System.out.println("Ожидается:\n" +
                "У     лукоморья     дуб     зелёный,\n" +
                "Златая    цепь    на    дубе    том.\n" +
                "И    днём   и   ночью   кот   учёный\n" +
                "Всё    ходит    по    цепи   кругом.\n" +
                "Идёт   направо   -   песнь  заводит,\n" +
                "Налево     -     сказку     говорит.\n" +
                "Там   чудеса:   там   леший  бродит,\n" +
                "Русалка     на     ветвях     сидит.\n" +
                "Там     на     неведомых    дорожках\n" +
                "Следы       невиданных       зверей.\n" +
                "Избушка   там   на   курьих   ножках\n" +
                "Стоит    без   окон,   без   дверей.\n" +
                "Там   лес   и   дол  видений  полны,\n" +
                "Там    о    заре   прихлынут   волны\n" +
                "На    брег    песчаный   и   пустой,\n" +
                "И    тридцать   витязей   прекрасных\n" +
                "Чредой   из   вод   выходят   ясных,\n" +
                "И   с   ними   дядька   их  морской.\n" +
                "Там        королевич       мимоходом\n" +
                "Пленяет        грозного        царя.\n" +
                "Там    в   облаках   перед   народом\n" +
                "Через      леса,      через     моря\n" +
                "Колдун        несёт        богатыря.\n" +
                "В   темнице   там   царевна   тужит,\n" +
                "А   бурый   волк  ей  верно  служит.\n" +
                "Там     ступа     с    Бабою    Ягой\n" +
                "Идёт,     бредёт     сама     собой.\n" +
                "Там  царь  Кащей  над златом чахнет,\n" +
                "Там русский дух... там Русью пахнет!\n" +
                "И   там   я   был,   и  мёд  я  пил,\n" +
                "У    моря    видел    дуб   зелёный,\n" +
                "Под   ним   сидел,   и   кот  учёный\n" +
                "Свои     мне     сказки     говорил.");

        run("").include(
                "У     лукоморья     дуб     зелёный,\n" +
                        "Златая    цепь    на    дубе    том.\n" +
                        "И    днём   и   ночью   кот   учёный\n" +
                        "Всё    ходит    по    цепи   кругом.\n" +
                        "Идёт   направо   -   песнь  заводит,\n" +
                        "Налево     -     сказку     говорит.\n" +
                        "Там   чудеса:   там   леший  бродит,\n" +
                        "Русалка     на     ветвях     сидит.\n" +
                        "Там     на     неведомых    дорожках\n" +
                        "Следы       невиданных       зверей.\n" +
                        "Избушка   там   на   курьих   ножках\n" +
                        "Стоит    без   окон,   без   дверей.\n" +
                        "Там   лес   и   дол  видений  полны,\n" +
                        "Там    о    заре   прихлынут   волны\n" +
                        "На    брег    песчаный   и   пустой,\n" +
                        "И    тридцать   витязей   прекрасных\n" +
                        "Чредой   из   вод   выходят   ясных,\n" +
                        "И   с   ними   дядька   их  морской.\n" +
                        "Там        королевич       мимоходом\n" +
                        "Пленяет        грозного        царя.\n" +
                        "Там    в   облаках   перед   народом\n" +
                        "Через      леса,      через     моря\n" +
                        "Колдун        несёт        богатыря.\n" +
                        "В   темнице   там   царевна   тужит,\n" +
                        "А   бурый   волк  ей  верно  служит.\n" +
                        "Там     ступа     с    Бабою    Ягой\n" +
                        "Идёт,     бредёт     сама     собой.\n" +
                        "Там  царь  Кащей  над златом чахнет,\n" +
                        "Там русский дух... там Русью пахнет!\n" +
                        "И   там   я   был,   и  мёд  я  пил,\n" +
                        "У    моря    видел    дуб   зелёный,\n" +
                        "Под   ним   сидел,   и   кот  учёный\n" +
                        "Свои     мне     сказки     говорил.");
    }

    @Test(timeout = 50000)
    public void testTaskC2() throws Exception {
        Test_jd01_06 ok = run("", true);
        System.out.println("=======================================================");
        Method mSlow = ok.checkMethod(ok.aClass.getSimpleName(), "slow", String.class);
        Method mFast = ok.checkMethod(ok.aClass.getSimpleName(), "fast", String.class);
        long t = System.nanoTime();
        String s1 = (String) mSlow.invoke(null, Poem.text);
        long dtSlow = (System.nanoTime() - t) / 1000;
        System.out.println("slow dt=" + dtSlow);

        t = System.nanoTime();
        String s2 = (String) mFast.invoke(null, Poem.text);
        long dtFast = (System.nanoTime() - t) / 1000;
        System.out.println("fast dt=" + dtFast);
        System.out.println("Отличие в скорости dtSlow/dtFast=" + dtSlow / dtFast);
        if (dtSlow / dtFast < 3)
            fail("Ошибка: Скорость метода fast должна быть выше, чем slow хотя бы в три раза!");
        if (!s1.equals(s2))
            fail("Ошибка: Методы slow и fast выводят разные последовательности слов!");
        String[] word = Poem.text.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < 10; i++) {
            String testWord = word[new Random().nextInt(word.length)];
            if (!s1.contains(testWord))
                fail("Не найдено слово из текста: " + testWord);
        }
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
    private static Test_jd01_06 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_06 run(String in, boolean runMain) {
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
        return new Test_jd01_06(clName, in, runMain);
    }

    //-------------------------------  тест ----------------------------------------------------------
    public Test_jd01_06() {
        //Конструктор тестов
    }

    //переменные теста
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //исходный поток вывода
    private PrintStream newOut; //поле для перехвата потока вывода
    private StringWriter strOut = new StringWriter(); //накопитель строки вывода

    //Основной конструктор тестов
    private Test_jd01_06(String className, String in, boolean runMain) {
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
    private Test_jd01_06 is(String str) {
        assertTrue("ERROR:Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_06 include(String str) {
        assertTrue("ERROR:Строка не найдена: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_06 exclude(String str) {
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
