
/**
 * Write a description of class Display here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display
{
    private JFrame display = new JFrame();
    private Container pane;

    private AlarmLabel alarmLabel = new AlarmLabel();
    TimerLabel timerLabel = new TimerLabel();

    private StartButton startButton = new StartButton();

    private CountDownTimer timer = new CountDownTimer();
    
    private int screenWidth = 800;
    private int screenHeight = 480;

    /**
     * Constructor for objects of class Display
     */
    public Display()
    {

        pane = display.getContentPane();
        createGUI();
        createTimerLabel();
        addStartButton();
        createTimeLabel();

        addTimeAdjusterButtons();

        displayGUI();
    }

    private void createGUI()
    {
        display.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        display.setPreferredSize(new Dimension(screenWidth, screenHeight));

        pane.setLayout(new GridBagLayout());
    }

    private void createTimerLabel()
    {
        timer.addTimeDisplay(timerLabel);

        GridBagConstraints c = ConstraintsFactory.buildConstraints(0, 0, 5);
        SetDimension.forComponent(timerLabel, screenWidth, (int)(screenHeight / 2.4));

        pane.add(timerLabel, c);
    }

    private void createTimeLabel()
    {
        GridBagConstraints c = ConstraintsFactory.buildConstraints(2, 2, 1);
        
        SetDimension.forComponent(alarmLabel, (int)(screenWidth / 2), (int)(screenHeight / 2.67));
        pane.add(alarmLabel, c);

        alarmLabel.addTimer(timer);
    }

    private void addTimeAdjusterButtons()
    {
        addTimeAdjusterButton("+ Hr", 0, 2, Constants.numberOfSecondsInAnHour);
        addTimeAdjusterButton("- Hr", 1, 2, -Constants.numberOfSecondsInAnHour);
        addTimeAdjusterButton("+ Min", 3, 2, Constants.numberOfSecondsInAMinute);
        addTimeAdjusterButton("- Min", 4, 2, -Constants.numberOfSecondsInAMinute);
    }

    private void addTimeAdjusterButton(String buttonText, int x, int y, int adjustableAmount)
    {
        TimeAdjusterButton button = new TimeAdjusterButton(buttonText, adjustableAmount);
        SetDimension.forComponent(button, (int)(screenWidth / 8), (int)(screenHeight / 2.67));
        pane.add(button, ConstraintsFactory.buildConstraints(x, y, 1));
        button.addTimer(alarmLabel);
    }

    private void addStartButton() {

        startButton.addStartable(timer);
        SetDimension.forComponent(startButton, screenWidth, (int)(screenHeight / 4.8));
        
        GridBagConstraints c = ConstraintsFactory.buildConstraints(0, 1, 5);

        pane.add(startButton, c);
    }

    private void displayGUI()
    {
        display.pack();
        display.setBackground(Color.black);
        display.setVisible(true); 
    }
}
