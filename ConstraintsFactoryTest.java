

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.GridBagConstraints;

/**
 * The test class ConstraintsFactoryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ConstraintsFactoryTest
{
    @Test
    public void buildConstraintsWithAnXCoordinateOf3AndAYCoordinateOf5ReturnsCorrectConstraints()
    {
        GridBagConstraints constraints = ConstraintsFactory.buildConstraints(2, 3, 5);
        
        assertEquals(2, constraints.gridx);
        assertEquals(3, constraints.gridy);
        assertEquals(5, constraints.gridwidth);
        assertEquals(0.5, constraints.weightx, 0.001);
        assertEquals(GridBagConstraints.HORIZONTAL, constraints.fill);      
    }
}
