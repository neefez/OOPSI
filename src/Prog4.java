/**
Runs the main for Program 3
@author Joshua Yue
*/
public class Prog4
{
   /**
   Runs RpnEvaluator.
   @param args  is unused
   */
   public static void main (String args[])
   {
      try
      { 
         RpnEvaluator rpne = new RpnEvaluator();
         rpne.run();
      }
      catch (Exception e)
      {
         System.out.println("Program Error!" + e);
      }
   }
}
