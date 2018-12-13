package by.it._examples_.jd01_13;

import java.util.regex.PatternSyntaxException;

public class Class03_ChildAndParentE {
    //пример неверного порядка обработки. Сначала - дети, потом родители
    private void Bad() {
        try { /* код, который может вызвать исключение */
        } catch(IllegalArgumentException e) {  }
        //catch(PatternSyntaxException e) { } /* ошибка компиляции */
    }
    private void Good() {
        try { /* код, который может вызвать исключение */
        }
        catch(PatternSyntaxException e) { } /* так корректно */
        catch(IllegalArgumentException e) {  }
    }
}
