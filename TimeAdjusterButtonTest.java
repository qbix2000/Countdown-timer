

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import javax.swing.*;

/**
 * The test class TimeAdjusterButtonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TimeAdjusterButtonTest implements TimeChangable
{
    private Boolean changeTimeCalled = false;
    private int changeValue = 0;
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        changeTimeCalled = false;
        changeValue = 0;
    }
    
    public void changeTime(int changeValue)
    {
        this.changeValue = changeValue;
        changeTimeCalled = true;
    }
    
    private TimeAdjusterButton buildButton()
    {
        TimeAdjusterButton button = new TimeAdjusterButton("My Button Name", 35);
        
        button.addTimer(this);
        
        return button;
    }
    
    @Test
    public void initSetsTheNameOfTheButton()
    {
        TimeAdjusterButton button = buildButton();
        
        assertEquals("My Button Name", button.getText());
    }
    
    @Test
    public void actionPerformedCallsChangeTime()
    {
        TimeAdjusterButton button = buildButton();
        
        button.actionPerformed(null);
        
        assertTrue(changeTimeCalled);
        assertEquals(35, changeValue);
    }
}
