
/**
 * Write a description of class CoolMathThing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class CoolMathThing
{
    
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of doors.");
        System.out.println("");
        int number = scan.nextInt();
        Locker[] array = new Locker[number];
        for (int h = 0; h < number; h++)
        {
            array[h] = new Locker();
        }
        for (int i = 0; i < number; i ++)
        {
            for (int j = 0; j < number; j++)
            {
                if ( (i+1) % (j+1) == 0)
                {
                    array[i].change();
                }
            }
        }
        int open = 0;
        int closed = 0;
        String openOnes = "";
        for (int k = 0; k < number; k++)
        {
            if (array[k].getOpen() == true)
            {
                open++;
                openOnes += (k+1) + " ";
            }
            else
            {
                closed++;
            }
        }
        
        System.out.println("Number of doors open: " + open);
        System.out.println("Number of doors closed: " + closed);
        System.out.println("Doors open: " + openOnes);
    }
}
