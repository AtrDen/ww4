import junit.framework.Assert;
import org.testng.annotations.Test;

public class Test3
{

    @Test
    public void testCanselled100()
    {
        var  actualResult = getRefundTicketPricePercent( 241,  true, true);
        Assert.assertEquals((Integer) 100, actualResult);
    }

    @Test
    public void testCanselled50()
    {
        var  actualResult = getRefundTicketPricePercent( 240,  false, false);
        Assert.assertEquals((Integer) 50, actualResult);
    }

    @Test
    public void testCanselledTwo50()
    {
        var  actualResult = getRefundTicketPricePercent( 144,  false, false);
        Assert.assertEquals((Integer) 50, actualResult);
    }
    @Test
    public void testCanselled30()
    {
        var  actualResult = getRefundTicketPricePercent( 143,  false, false);
        Assert.assertEquals((Integer) 30, actualResult);
    }

    @Test
    public void testCanselledTwo30()
    {
        var  actualResult = getRefundTicketPricePercent( 4,  false, false);
        Assert.assertEquals((Integer) 30, actualResult);
    }

    @Test
    public void testCanselledFalse()
    {
        var  actualResult = getRefundTicketPricePercent( 0,  false, false);
        Assert.assertEquals((Integer) 0, actualResult);
    }

    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)
    {
        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert>240) return 100;
        if(hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;
        if(hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30;
        return 0;
    }
}
