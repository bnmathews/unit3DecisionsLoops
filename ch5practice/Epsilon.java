import java.util.Scanner;

public class Epsilon
{
   
    public static void main(String[] args)
    {
        final double EPSILON = 1e-14;
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter onna dose floating-point numbas: ");
        double num = s.nextDouble();
        
        String magnitude = "";
        
        if (Math.abs(num) < 1.0)
        {
            magnitude = "small ";
        }
        
        if (Math.abs(num) > 1000000.0)
        {
            magnitude = "large ";
        }
        
        if (Math.abs(num - 0) < EPSILON) //num == 0
        {
            System.out.println("It's a zero, yo.");
        }
        else if (num > 0)
        {
            System.out.println("It's a " + magnitude +  "positive number.");
        }
        else
        {
            System.out.println("It's a " + magnitude +  "negative number.");
        }
    }

}
