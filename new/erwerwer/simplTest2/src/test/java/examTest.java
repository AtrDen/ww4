import junit.framework.Assert;
import org.junit.Test;

public class examTest
{
    @Test
    public void test2Mark()
    {
        var actualMarkResults = getMarkResult(3);
        Assert.assertEquals ("2", actualMarkResults);
    }
    @Test
    public void testTwo2Mark()
    {
        var actualMarkResults = getMarkResult(35);
        Assert.assertEquals ("2", actualMarkResults);
    }
    @Test
    public void test3Mark()
    {
        var actualMarkResults = getMarkResult(56);
        Assert.assertEquals ("3", actualMarkResults);
    }
    @Test
    public void testFalse5Mark()
    {
        var actualMarkResults = getMarkResult(71);
        Assert.assertEquals ("5", actualMarkResults);
    }
    @Test
    public void test4Mark()
    {
        var actualMarkResults = getMarkResult(70);
        Assert.assertEquals ("4", actualMarkResults);
    }
    @Test
    public void test5Mark()
    {
        var actualMarkResults = getMarkResult(100);
        Assert.assertEquals ("5", actualMarkResults);
    }
    @Test
    public void testFal5Mark()
    {
        var actualMarkResults = getMarkResult(72);
        Assert.assertEquals ("5", actualMarkResults);
    }
    @Test
    public void testFalse101Mark()
    {
        var actualMarkResults = getMarkResult(101);
        Assert.assertEquals ("указаны некорректные данные", actualMarkResults);
    }
    @Test
    public void testFalse1Mark()
    {
        var actualMarkResults = getMarkResult(-1);
        Assert.assertEquals ("указаны некорректные данные", actualMarkResults);
    }

    @Test
    public void testFalse0Mark()
    {
        var actualMarkResults = getMarkResult(0);
        Assert.assertEquals ("указаны некорректные данные", actualMarkResults);
    }

    private String getMarkResult(Integer mark)
    {
        if (mark == null || mark <= 0 || mark > 100) {
            return "указаны некорректные данные";
        }
        if(mark > 0 && mark <= 35) return "2";
        if(mark > 35 && mark <= 56) return "3";
        if(mark > 56 && mark < 71) return "4";
        if(mark > 72 && mark < 100) return "5";
        return "no mark result";
    }

}
