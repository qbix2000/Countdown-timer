
/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class StartButton extends JButton implements ActionListener
{
    private Startable starter;

    public StartButton()
    {
        super("Start");
        setFont();
        setColour();
        
        super.addActionListener(this);
    }
        
    private void setFont()
    {
        Font font = new Font(Constants.font, Font.PLAIN, 32);

        this.setFont(font);
    }

    private void setColour()
    {
        this.setBackground(Constants.backgroundColour);
        this.setForeground(Constants.foregroundColour);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(this.getText() == Constants.stop) {
            super.setText(Constants.start);
            stopItems();
        } else {
            super.setText(Constants.stop);
            startItems();
        }
    }
    
    public void addStartable(Startable starter)
    {
        this.starter = starter;        
    }
    
    private void stopItems()
    {
        if(starter == null)
            return;
            
        starter.stop();
    }
    
    private void startItems()
    {
        if(starter == null)
            return;
            
        starter.start();
    }
}
