public class NestedLoupMKII
{
    public static void main(String[] args)
    {
        int second = 0;
        int first = 1;
        while (first <= 2)
        {
            while (second < 4)
            {
                second++;
                System.out.println(""+first+""+second);
            } 
            first++;
            second=0;
        }
    }

}
