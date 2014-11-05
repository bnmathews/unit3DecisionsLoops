/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";
		
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		int notFoundPsn = sample.indexOf("slow");
		int firstPsn = sample.indexOf("brown",5);
		System.out.println ("sample.indexOf(\"quick\") = " + position);
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
		System.out.println("sample.indexOf(\"brown\") = " + firstPsn);
		
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);
		
		//  Try other methods here:

	}

}
