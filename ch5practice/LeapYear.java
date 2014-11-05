import java.util.Scanner;
public class LeapYear
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String choice = "y";
        while (choice.toLowerCase().equals("y"))
        {
            System.out.print("Input a year: ");
            int year = s.nextInt();
        
            if ( (year%4 == 0 && year%100 != 0) || year%400 == 0 )
            {
                System.out.println(year + " is a leap year.");
            }
            else
            {
                System.out.println(year + " is not a leap year.");
            }
            
            System.out.print("Go again? [Y/N] ");
            choice = s.next();
        }
    }
}

