package by.it._examples_.jd02_05;
        import java.util.Locale;
public class I18nSample01UseResMan {
    public static void main(String[ ] args) {
        ResMan manager = ResMan.INSTANCE;
        System.out.println(manager.getString("str1"));
        manager.changeResource(new Locale("be","BY"));
        System.out.println(manager.getString("str1"));
    }
}
