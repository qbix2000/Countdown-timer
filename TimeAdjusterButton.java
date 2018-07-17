
/**
 * Write a description of class TimeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.Color;

public class TimeAdjusterButton extends JButton implements ActionListener
{
    private int changeValue = 0;

    private LinkedList<TimeChangable> timers = new LinkedList<TimeChangable>();

    TimeAdjusterButton(String buttonName, int changeValue) 
    {
        super(buttonName);

        this.changeValue = changeValue;

        setFont();
        setColour();
        super.addActionListener(this);
    }

    private void setFont()
    {
        Font font = new Font(Constants.font, Font.PLAIN, 16);

        this.setFont(font);
    }

    private void setColour()
    {
        this.setBackground(Constants.backgroundColour);
        this.setForeground(Constants.foregroundColour);
    }

    public void actionPerformed(ActionEvent e)
    {
        ListIterator<TimeChangable> iterator = timers.listIterator();

        while(iterator.hasNext()) {

            TimeChangable changer = iterator.next();

            changer.changeTime(changeValue);
        }
    }

    public void addTimer(TimeChangable timer)
    {
        timers.add(timer);
    }
}
