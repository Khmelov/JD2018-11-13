package by.it.naumenko.expirements.virageniya;

import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class SintaxAnalizator {
 
    /**
     *  Программа анализатор, обрабатывающий арифметические выражения.
     *  Выражение, которые будут обрабатываться данным анализатором
     *  состоят из следующих элементов:
     *      1.  числа
     *      2.  операторы (+, -, *, /, ^(возведение в степень), 
     *          % (остаток от деления), = (присваивание значения)
     *      3.  круглые скобки ()
     *      4.  переменные
     *  Ниже показано несколько примеров
     *      1.  10 - 8
     *      2.  (100 - 5) * 14 / 6
     *      3.  a + b - c
     *      4.  10 ^ 5
     *      5.  a = 10 - b
     *  Приоритеты операций, от высшего к низшему
     *      1.  +,- (унарные, к примеру a++, ++a)
     *      2.  ^
     *      3.  *, /, %
     *      4.  +,-
     *      5.  = 
     *
     *  Ограничения:
     *      1.  Переменные могут быть выражены только отдельными буквами,
     *          (или только могут быть 26 переменных, от A до Z)
     *      2.  Переменные не чувствительны к регистру, т.е. A и a
     *          определяют одну и ту же переменную
     *      3.  Все числовые занчения должны быть числами двойной точности
     *      4.  Производится проверка только на наличие элементарных
     *          ошибок.                     
     * @throws ParserException 
     *  
     * 
     * 
     * 
     */
    public static void main(String[] args) throws ParserException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser myParser = new Parser();
        
        for(;;)
        {
            try
            {
                System.out.print("Введите выражение для вычисления\n-> ");
                String str = reader.readLine();
                if(str.equals(""))
                    break;
                double result = myParser.evaluate(str);
                
                DecimalFormatSymbols s = new DecimalFormatSymbols();
                s.setDecimalSeparator('.');
                DecimalFormat f = new DecimalFormat("#,###.00", s);
                
                
                System.out.printf("%s = %s%n", str, f.format(result));
            
            }
            catch(ParserException e)
            {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
 
}