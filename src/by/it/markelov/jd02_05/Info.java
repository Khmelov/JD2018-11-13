package by.it.markelov.jd02_05;

public class Info {
    private final static String INFO_RU1="\nЧтобы изменить язык приложения, введите код языка (ru, be, en). Завершение приложения-команда END";
    private final static String INFO_RU2="\nВы ввели несуществующий код языка. Повторите попытку или завершите работу приложения (END)";
    private final static String INFO_BE1="\nКаб змяніць мову прыкладання, увядзіце код мовы (ru, be, en). Завяршэнне прыкладання-каманда END";
    private final static String INFO_BE2="\nВы ўвялі неіснуючы код мовы. Паспрабуйце яшчэ раз або завершыце працу прыкладання (END)";
    private final static String INFO_EN1="\nTo change the language of the application, enter the language code. Completion of the application - command END";
    private final static String INFO_EN2="\nYou have entered a non-existent language code. Try again or close the application (END)";

    public static String getInfoRu1() {
        return INFO_RU1;
    }

    public static String getInfoRu2() {
        return INFO_RU2;
    }

    public static String getInfoBe1() {
        return INFO_BE1;
    }

    public static String getInfoBe2() {
        return INFO_BE2;
    }

    public static String getInfoEn1() {
        return INFO_EN1;
    }

    public static String getInfoEn2() {
        return INFO_EN2;
    }
}
