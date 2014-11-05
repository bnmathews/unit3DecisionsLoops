public class NestedLoupMKIII
{
    public static void main(String[] args)
    {
        int second = 0;
        int first = 1;
        do
        {
            do
            {
                second++;
                System.out.println(""+first+""+second);
            }
            while(second <4);
            second = 0;
            first++;
        }
        
        while(first < 3);
    }

}
