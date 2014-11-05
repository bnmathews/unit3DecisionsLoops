public class NestedLoup
{
    public static void main(String[] args)
    {
        int second = 0;
        for (int first = 1; first <= 2; first++)
        {
            for (int count = 1; count <= 4; count++)
            {
                if (first == 3 && second == 4)
                {
                    break;
                }
                second = count;
                System.out.println("" + first + "" + second);
                if (second == 4)
                {
                    first++;
                    count = 0;
                }
            }
        }
    }

}
