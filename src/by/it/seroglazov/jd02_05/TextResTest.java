package by.it.seroglazov.jd02_05;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class TextResTest {

    @Test
    public void testWelcomeMessage() {
        TextRes.changeLanguage(new Locale("en", "EN"));
        String str = TextRes.get(TextRes.text.WELCOME);
        assertEquals("Welcome!", str);
        TextRes.changeLanguage(new Locale("ru", "RU"));
        str = TextRes.get(TextRes.text.WELCOME);
        assertEquals("Добро пожаловать!", str);
        TextRes.changeLanguage(new Locale("be", "BY"));
        str = TextRes.get(TextRes.text.WELCOME);
        assertEquals("Сардэчна запрашаем!", str);
    }

    @Test
    public void testGetUserName() {
        TextRes.changeLanguage(new Locale("be", "BY"));
        String str = TextRes.get(TextRes.user.NAME);
        assertEquals("Рэнат", str);
        TextRes.changeLanguage(new Locale("en", "US"));
        str = TextRes.get(TextRes.user.NAME);
        assertEquals("Renat", str);
    }
}