import java.util.Scanner;

/**
 * Reads word and prints all substrings
 */
public class Substrings2
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter onna dose strings right here --> ");
        String word = s.next();
        for(int length = 1; length <= word.length(); length++)
        {
            for(int pos = 0; pos <= word.length() - length; pos++)
            {
                System.out.println(word.substring(pos,pos+length));
            }
        }
}

}
