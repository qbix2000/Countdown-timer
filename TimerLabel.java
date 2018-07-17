
/**
 * Write a description of class TimerLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;

public class TimerLabel extends JLabel implements TimeChangable
{

    public TimerLabel()
    {
        super("", SwingConstants.CENTER);

        setFont();
        setColour();
    }

    private void setFont()
    {
        Font font = new Font(Constants.font, Font.PLAIN, 150);

        super.setFont(font);
    }

    private void setColour()
    {
        super.setBackground(Constants.backgroundColour);
        super.setForeground(Constants.foregroundColour);
        super.setOpaque(true);
    }

    public void changeTime(int time)
    {
        int timeInMinutes = time / 60;
        int secondsRemaining = time % 60;

        String totalTime = Integer.toString(timeInMinutes) + ":" + String.format("%02d", secondsRemaining);;

        super.setText(totalTime);        
    }
}
