import java.util.Scanner;

public class FindFirstMatch
{
    /**
     * Computes the index of the first space (' ') in the string, if any
     */
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = s.nextLine(); //Read whole line, not one word
        
        int index = 0;
        
        char ch = '◙';
        
        while (index < str.length() )
        {
            ch = str.charAt( index );
            
            if (ch == ' ')
            {
                break;
            }
            
            index++;
        }
        
        if (ch == ' ')
        {
            System.out.println("The index of the first space is "+index+".");
        }
    }
}