
/**
 * Write a description of class Collectable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.awt.*;

public class Collectable
{
    int xpos;
    int ypos;
    int side = 10;
    Color c;
    public Collectable()
    {
        
    }
    
    public void paint(Graphics g, Color d)
    {
        c = d;
        g.setColor(c);
        g.fillRect(xpos, ypos, side, side);
    }
    
    public void NewPosition()
    {
        xpos = (int) (Math.random()*891);
        ypos = (int) (Math.random()*541 + 50);
        
    }
    
    public void NewColor()
    {
        int R = (int) (Math.random()*256);
        int G = (int) (Math.random()*256);
        int B = (int) (Math.random()*256);
        c = new Color(R,G,B);
    }
    
    public int getXcenter()
    {
        return xpos + (side/2);
    }
    
    public int getYcenter()
    {
        return ypos + (side/2);
    }
    
    public Color getColor()
    {
        return c;
    }
}
