

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.JButton;

/**
 * The test class SetDimensionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SetDimensionTest
{
    
    @Test
    public void forComponentWithArgumentsOf100By200SetsComponentSizeCorrectly()
    {
        JButton button = new JButton();
        
        SetDimension.forComponent(button, 100, 200);

         assertEquals(100.0, button.getWidth(), 0.001);
         assertEquals(200.0, button.getHeight(), 0.001);
    }
}
