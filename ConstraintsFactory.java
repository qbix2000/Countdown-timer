
/**
 * Write a description of class ConstraintsFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.GridBagConstraints;

public class ConstraintsFactory
{

    public static GridBagConstraints buildConstraints(int xCoordinate, int yCoordinate, int gridWidth)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = xCoordinate;
        constraints.gridy = yCoordinate;
        constraints.gridwidth = gridWidth;
        constraints.weightx = 0.5;

        return constraints;
    }
}
