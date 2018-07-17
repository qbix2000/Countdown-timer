
/**
 * Write a description of class SetDimension here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JComponent;
import java.awt.Dimension;

public class SetDimension
{
    public static void forComponent(JComponent component, int height, int width)
    {
        Dimension buttonSize = new Dimension(height, width);

        component.setSize(buttonSize);

        component.setMinimumSize(buttonSize);
        component.setPreferredSize(buttonSize);
        component.setMaximumSize(buttonSize);
    }
}
