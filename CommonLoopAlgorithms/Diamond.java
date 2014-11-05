import java.util.Scanner;

public class Diamond
{
    public static void main(String[] args)
    {
        final String SPACE = "x";
        final String AST = "*";
        System.out.print("Input a number: ");
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int count = 0;
        int count2 = 0;
        while(count <= len)
        {
            for(int x= 0; x< len - count; x++)
            {
                System.out.print(SPACE);
                count++;
                for(int y =0; y <= count2; y++)
                {
                    System.out.print(AST);
                }
                System.out.print("\n");
                count2 += 2;
            }
        }
    }
}
