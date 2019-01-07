package by.it.kovalyova.calc;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

    @Test
    public void parse() {        Parser p = new Parser();
        String s = p.parse("A=2+2");
        Assert.assertEquals("4.0",s);
        s = p.parse("B=A+2-(3+4)");
        Assert.assertEquals("-1.0",s);
        s = p.parse("C=B*(A-(4+2))");
        Assert.assertEquals("2.0",s);
        s = p.parse("E=A/2");
        Assert.assertEquals("2.0",s);
        s = p.parse("B=A+{1,3}");
        Assert.assertEquals("{5.0,7.0}",s);
        s = p.parse("C=B-{2,3}");
        Assert.assertEquals("{3.0,4.0}",s);
        s = p.parse("D=B*{2,3}");
        Assert.assertEquals("31.0",s);
        s = p.parse("E=B/2");
        Assert.assertEquals("{2.5,3.5}",s);


    }
}