public class StringCompare
{
    public static void main(String[] args)
    {
        String word1 = "catalog";
        String word2 = "cat";
        int num1 = word1.compareTo("aaa");
        if (num1>0)
        {
            System.out.println(word1+" is greater than 'aaa'");
        }

        if (word1.equals(word2))
        {
            System.out.println(word1+" equals "+word2);
        }

        int num3 = word1.compareTo(word2);
        if (num3<0)
        {
            System.out.println(word1+" is less than "+word2);
        }

        String word1Part = word1.substring(0,3);
        if (word1Part.equals(word2))
        {
            System.out.println(word1+" and "+word2+" have the same three-letter prefix.");
        }
    }
}