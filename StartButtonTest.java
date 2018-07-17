
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.lang.Object;
import java.awt.GridBagConstraints;

/**
 * The test class StartButtonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StartButtonTest implements Startable
{
    private Boolean startCalled = false;
    private Boolean stopCalled = false;

    @Before
    public void setUp()
    {
        startCalled = false;
        stopCalled = false;
    }

    public void start()
    {
        startCalled = true;
    }

    public void stop()
    {
        stopCalled = true;
    }

    private StartButton buildStartButton()
    {
        StartButton button = new StartButton();

        return button;
    }

    @Test
    public void getTextReturnsStart()
    {
        StartButton button = buildStartButton();

        String text = button.getText();

        assertEquals("Start", text);
    }

    @Test
    public void actionPerformedWithAButtonTextOfStartSetsTextToStop()
    {
        StartButton button = buildStartButton();

        button.actionPerformed(null);

        String text = button.getText();

        assertEquals("Stop", text);
    }

    @Test
    public void actionPerformedWithAButtonTextOfStopSetsTextToStart()
    {
        StartButton button = buildStartButton();

        button.actionPerformed(null);
        button.actionPerformed(null);

        String text = button.getText();

        assertEquals("Start", text);
    }

    @Test
    public void actionPerformedCallsStartOnStartableInterface()
    {
        StartButton button = buildStartButton();

        button.addStartable(this);

        button.actionPerformed(null);

        assertTrue(startCalled);
    }

    @Test
    public void actionPerformedInStartStateCallsStopOnStartableInterface()
    {
        StartButton button = buildStartButton();

        button.addStartable(this);

        button.actionPerformed(null);
        button.actionPerformed(null);

        assertTrue(stopCalled);
    }
}
