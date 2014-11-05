import java.util.Scanner;
import java.util.Random;
/**
Jumble dat ish
 */
public class WordBumjle
{
    public static void main(String[] dickbutt)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Type in dat fresh string yo: ");
        String word = s.next();
        final int LENGTH = word.length();
        Random r = new Random();
        int iint = r.nextInt(LENGTH)-1;
        int jint = 0;
        char i = 'a';
        char j = 'b';
        for(int count = 0; count <= LENGTH; count++)
        {
            //while sentinel to solve
            if (iint < 0)
            {
                iint++;
            }
            i = word.charAt(iint);
            //System.out.println(word.indexOf(i));
            //System.out.println(i);
            jint = r.nextInt(LENGTH);
            j = word.charAt(jint);
            //while (word.indexOf(j) <= word.indexOf(i) && (j != i) )
            while (jint <= iint || j == i ) //This is the problem
            {
                i = word.charAt(r.nextInt(LENGTH));
                jint = r.nextInt(LENGTH);
                j = word.charAt(jint);
            }
            //System.out.println(word.indexOf(j));
            //System.out.println(j);
        }
        //System.out.println(iint);
        System.out.println("The first letter selected is:" + i);
        //System.out.println(jint);
        System.out.println("The second letter selected is:" + j);
        System.out.println(word.substring(0,iint) + j + word.substring(iint + 1,jint) + i + word.substring(jint + 1,LENGTH));

    }

}