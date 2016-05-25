
/**
 * Write a description of class Locker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Locker
{
    boolean isOpen = false;
    
    public Locker()
    {
        
    }
    
    public void change()
    {
        isOpen = !isOpen;
    }
    
    public boolean getOpen()
    {
        return isOpen;
    }

    
}
