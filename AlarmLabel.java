
/**
 * Write a description of class AlarmLabel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlarmLabel extends JLabel implements TimeChangable
{
    private int alarmTime = 25200;

    private TimeSettable timer;

    AlarmLabel() 
    {
        super("07:00", SwingConstants.CENTER);

        setFont();
        setColour();
    }

    private void setFont()
    {

        Font font = new Font(Constants.font, Font.PLAIN, 64);

        super.setFont(font);
        setColour();
    }

    private void setColour()
    {
        super.setBackground(Constants.backgroundColour);
        super.setForeground(Constants.foregroundColour);
        super.setOpaque(true);
    }

    public void addTimer(TimeSettable timer)
    {
        this.timer = timer;

        timer.setTime(alarmTime);
    }

    public void changeTime(int time)
    {
        alarmTime += time;

        if(alarmTime >= 86400) {
            alarmTime = alarmTime - Constants.numberOfSecondsInADay;        

        }

        if(alarmTime < 0) {
            alarmTime = Constants.numberOfSecondsInADay + alarmTime;
        }

        this.setText(alarmToString());

        setAlarmTime();
    }

    private String alarmToString() 
    {
        int alarmHour = alarmTime / Constants.numberOfSecondsInAnHour;
        int alarmMinutes = (alarmTime % Constants.numberOfSecondsInAnHour) / Constants.numberOfSecondsInAMinute;

        String formattedMinutes = String.format("%02d", alarmMinutes);
        String formattedHours = String.format("%02d", alarmHour);

        return formattedHours + ":" + formattedMinutes;
    }

    private void setAlarmTime()
    {
        if(this.timer == null) {
            return;
        }

        timer.setTime(alarmTime);
    }
}
