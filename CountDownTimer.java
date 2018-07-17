
/**
 * Write a description of class CountDownTimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;

public class CountDownTimer implements Startable, TimeSettable
{
    private ClockTick clockTick = new ClockTick();

    private Timer timer = new Timer();

    private int alarmTime = 0;

    private TimeChangable timerDisplay;

    public void setTime(int time)
    {
        alarmTime = time;
    }

    public void start()
    {
        timer = new Timer();

        clockTick = new ClockTick();
        clockTick.addTimer(this);

        timer.schedule(clockTick, 0, 1000);
    }

    public void stop()
    {
        if(timer == null)
            return;

        timer.cancel();
        timer.purge();

        timer = null;
    }

    public void addTimeDisplay(TimeChangable changer)
    {
        timerDisplay = changer;
    }

    public void update()
    {
        int timeRemaining = calculateTimeRemaining();

        if(timeRemaining == 0)
            stop();

        timerDisplay.changeTime(timeRemaining);
    }

    private int calculateTimeRemaining()
    {
        int currentTimeInSeconds = currentTimeInSeconds();

        if(currentTimeInSeconds > alarmTime)
            alarmTime += 86400;

        return alarmTime - currentTimeInSeconds;
    }

    private int currentTimeInSeconds()
    {
        Calendar currentDate = Calendar.getInstance();

        int hour = currentDate.get(Calendar.HOUR_OF_DAY);

        int minutes = currentDate.get(Calendar.MINUTE);

        int seconds = currentDate.get(Calendar.SECOND);

        return (hour * 3600) + (minutes * 60) + seconds;
    }
}

class ClockTick extends TimerTask
{
    private CountDownTimer timer;

    public void addTimer(CountDownTimer timer)
    {
        this.timer = timer;
    }

    public void run()
    {
        if(timer == null)
            return;

        timer.update();
    }
}
