
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.GridBagConstraints;
import java.awt.Font;

/**
 * The test class TimerLabelTests.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TimerLabelTests
{
    private TimerLabel buildTimerLabel()
    {
        
        TimerLabel label = new TimerLabel();
        
        return label;
    }
    
    @Test
    public void getTextWithNoTimeSetReturnsEmptyString()
    {
        TimerLabel label = buildTimerLabel();

        String text = label.getText();

        assertEquals(text, "");
    }
    

    @Test
    public void getTextWithATimeSetTo86400Returns1440Colon00()
    {
        TimerLabel label = buildTimerLabel();

        label.changeTime(86400);

        String text = label.getText();

        assertEquals(text, "1440:00");
    }
   
    @Test
    public void getTextWithATimeSetTo86399Returns1439Colon59()
    {
        TimerLabel label = buildTimerLabel();

        label.changeTime(86399);

        String text = label.getText();

        assertEquals(text, "1439:59");
    }
            
    @Test
    public void getTextWithATimeSetTo0Returns0Colon00()
    {
        TimerLabel label = buildTimerLabel();

        label.changeTime(0);

        String text = label.getText();

        assertEquals(text, "0:00");
    }  
       
    @Test
    public void getFontReturnsFontOfSize150()
    {
         TimerLabel label = buildTimerLabel();
         
         Font font = label.getFont();
         
         assertEquals(150, font.getSize());
         assertEquals("Helvetica", font.getName());
        
    }
}
