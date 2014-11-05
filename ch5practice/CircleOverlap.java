import java.util.Scanner;
public class CircleOverlap
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("Input the radius of the first circle: ");
      double radius1 = in.nextDouble();      
      System.out.print("Input the xcenter of the first circle: ");
      double xcenter1 = in.nextDouble();  
      System.out.print("Input the ycenter of the first circle: ");
      double ycenter1 = in.nextDouble();  
      System.out.print("Input the radius of the second circle: ");
      double radius2 = in.nextDouble(); 
      System.out.print("Input the xcenter of the second circle: ");
      double xcenter2 = in.nextDouble(); 
      System.out.print("Input the ycenter of the second circle: ");
      double ycenter2 = in.nextDouble(); 
      
      double triwidth = xcenter2 - xcenter1;
      double triheight = ycenter2 - ycenter1;
      
      double hyp = Math.sqrt(Math.pow(triwidth,2)+Math.pow(triheight,2));

      if ((radius1 + radius2) > hyp)
      {
          System.out.println("The circles are overlapping.");
      }
      else if ((radius1 + radius2) == hyp)
      {
          System.out.println("The circles are tangent.");
      }
      else
      {
          System.out.println("The circles are disjoint.");
      }
      
      if ((xcenter1 == xcenter2) && (ycenter1 == ycenter2))
      {
          System.out.println("The circles are mutually contained.");
      }
   }
}