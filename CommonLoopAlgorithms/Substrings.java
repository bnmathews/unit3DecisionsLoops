import java.util.Scanner;

/**
 * Reads word and prints all substrings
 */
public class Substrings
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter onna dose strings right here --> ");
        String word = s.next();
        //String word = "rum";
        String newWord = "";
        int countInc = 1;
        int count2 = 0;
        for(int count = 1; !(newWord.equals(word)); count++)
        {
            for(count2 = count + countInc; count2 <= word.length(); count2++)
            {
                System.out.println("Count is: " + count);
                System.out.println("Count 2 is: " + count2);
                newWord = word.substring(count,count2);
                System.out.println(newWord);
                count++;
            }
            System.out.println("Count 2 is: " + count2);
            countInc++;
            count = 0;
        }
        System.out.println(countInc);
}

}
