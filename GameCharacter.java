
/**
 * Write a description of class GameCharacter here.
 * 
 * @author (Mekki Rachedine) 
 * @version (a version number or a date)
 * 
 */


import java.awt.*;

public class GameCharacter 
{
    int xpos ;
    int ypos ;
    int dia ;
    Color c ;
    public GameCharacter(int x, int y, int d)
    {
        xpos = x;
        ypos = y;
        dia = d;
        
    }
    
    public void paint(Graphics g, Color d)
    {
        c = d;
        g.setColor(c);
        g.fillOval(xpos, ypos, dia, dia);
    }
    
    public int getXcenter()
    {
        return xpos + (dia/2);
    }
    
    public int getYcenter()
    {
        return ypos + (dia/2);
    }
    
    public void move(String k)
    {
        if (k.equals("x") && xpos < (1000 - dia))
        {
            xpos = xpos + 25;
        }
        else if (k.equals("-x") && xpos > 0)
        {
            xpos = xpos - 25;
        }
        else if (k.equals("y") && ypos < (600 - dia))
        {
            ypos = ypos + 25;
        }
        else if (k.equals("-y") && ypos > 50)
        {
            ypos = ypos - 25;
        }
    }
    
    
    
    
}
