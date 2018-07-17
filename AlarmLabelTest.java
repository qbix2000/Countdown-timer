

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Font;

/**
 * The test class AlarmLabelTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AlarmLabelTest
{
     private AlarmLabel buildAlarmLabel()
    {
        
        AlarmLabel label = new AlarmLabel();
        
        return label;
    }
    
    @Test
    public void getTextWithNoTimeSetReturns07Colon00()
    {
        AlarmLabel label = buildAlarmLabel();

        String text = label.getText();

        assertEquals(text, "07:00");
    }
    

    @Test
    public void getTextWithATimeSetTo0800Retutns0800()
    {
        AlarmLabel label = buildAlarmLabel();

        label.changeTime(3600);

        String text = label.getText();

        assertEquals("08:00", text);
    }
   
    @Test
    public void getTextWithATimeSetTo635Returns635()
    {
        AlarmLabel label = buildAlarmLabel();

        label.changeTime(86300);

        String text = label.getText();

        assertEquals("06:58", text);
    }
            
    @Test
    public void getTextWithATimeSetTo0Returns0Colon00()
    {
        AlarmLabel label = buildAlarmLabel();

        label.changeTime(-25200);

        String text = label.getText();

        assertEquals("00:00", text);
    }
    
    @Test
    public void getFontReturnsFontOfSize150()
    {
         AlarmLabel label = buildAlarmLabel();
         
         Font font = label.getFont();
         
         assertEquals(64, font.getSize());
         assertEquals("Helvetica", font.getName());
        
    }
}
