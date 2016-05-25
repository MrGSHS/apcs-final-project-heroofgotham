
/**
 * Write a description of class GamePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JPanel;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;


public class GamePanel extends JPanel implements KeyListener
{
    GameCharacter circle;
    JButton changeColor;
    JTextField moves = new JTextField(10);
    Color c = Color.black;
    int score = 0;
    int highscore;
    int hitBox = 40;
    int seconds = 0;
    boolean stopTime = false;
    JLabel visibleScore = new JLabel("Current Score: " + score + "      ");
    JLabel highScore = new JLabel("High Score: " + highscore + "        ");
    JLabel timeKeep = new JLabel("Time remaining: " + (60 - seconds));
    Collectable item = new Collectable();
    Color itemColor;
    Timer timeLeft = new Timer();
    
    public GamePanel()
    {
        circle = new GameCharacter(450, 300, 50);
        setPreferredSize(new Dimension (1000, 600));
        this.setLayout(new BorderLayout());
        JButton newColor = new JButton("Change Color :D");
        newColor.addActionListener(new ColorListener(null));
        JPanel panel = new JPanel();
        panel.add(visibleScore);
        panel.add(highScore);
        panel.add(newColor);
        this.add(panel, BorderLayout.NORTH);
        moves.addKeyListener(this);
        panel.add(moves);
        panel.add(timeKeep);
        item.NewPosition();
        item.NewColor();
        doSomething();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        circle.paint(g, c);
        item.paint(g, item.getColor());
        if ((Math.abs(circle.getXcenter() - item.getXcenter()) < hitBox) && (Math.abs(circle.getYcenter() - item.getYcenter()) < hitBox))
        {
            score++;
            item.NewPosition();
            item.NewColor();
            visibleScore.setText("Current Score: " + score + "      ");
            if (score > highscore)
            {
                highscore = score;
                highScore.setText("High Score: " + highscore + "        ");
            }
        }
        timeKeep.setText("Time remaining: " + (60 - seconds));
        if (seconds >= 60)
        {
            score = 0;
            visibleScore.setText("Current Score: " + score + "      ");
            seconds = 0;
            timeKeep.setText("Time remaining: " + (60 - seconds));
        }
    }
    
    public void doSomething()
    {
        timeLeft.scheduleAtFixedRate(task, 1000, 1000);
        repaint();
    }
    
    public void keyTyped (KeyEvent e)
    {
        //Nothing to see here folks.
    }
    
    public void keyPressed (KeyEvent e)
    {
        int code = e.getKeyCode();
        if (code == 37)
        {
            circle.move("-x");
        }
        else if (code == 38)
        {
            circle.move("-y");
        }
        else if (code == 39)
        {
            circle.move("x");
        }
        else if (code == 40)
        {
            circle.move("y");
        }
        else if (code == 192)
        {
            hitBox = 1000;
        }
        else if (code == 8)
        {
            hitBox = 40;
        }
        else if (code == 104)
        {
           stopTime = !stopTime;
        }
        repaint();
    }
    
    public void keyReleased (KeyEvent e)
    {
        //Nothing to see here folks.
    }
    
    TimerTask task = new TimerTask()
    {
     
         public void run()
         {
             if (stopTime == false)
             {
             seconds++;
             repaint();
            }
             
            }
        };
    
    private class ColorListener implements ActionListener 
    {
    private Color clr;
    
    public ColorListener (Color a)
    {
        this.clr =a;
       
        
       }
       
       public void actionPerformed(ActionEvent e)
    {
        if (clr == null)
        c=JColorChooser.showDialog(changeColor,"Select a color",c);
        
        
        repaint();
    }
    
    }
    
    
}
