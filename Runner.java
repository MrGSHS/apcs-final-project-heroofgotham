
/**
 * Write a description of class Runner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JFrame;

public class Runner 
{
    public static void main (String[] args)
    {
       JFrame f = new JFrame("Final Project");
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.getContentPane().add(new GamePanel());
       f.pack();
       f.setVisible(true);
    }
}
