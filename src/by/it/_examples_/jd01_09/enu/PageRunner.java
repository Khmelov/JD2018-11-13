package by.it._examples_.jd01_09.enu;

public class PageRunner {
    public static void main(String[] args) {
        PageStyle styleText = PageStyle.Roman; // инициализация
        System.out.print(styleText);
        switch (styleText) {
            case Roman:     System.out.print(" - это роман. ");           break;
            case Novell:    System.out.print(" - это новелла. ");         break;
            case Issue:     System.out.print(" - это статья. ");          break;
            case Code:      System.out.print(" - это код программы. ");   break;
            default:        System.out.print(" - это неизвестный стиль. ");
        }
        System.out.print("Минимум страниц: "+styleText.getMinPages());
    }
}
