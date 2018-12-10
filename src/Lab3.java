/*
 Leave this class intact
 */
import java.util.Scanner;

/**
 @author yues
 */
public class Lab3
{

   /**
    @param args the command line arguments
    */
   public static void main(String[] args)
   {
      int temperature = 0;
      Scanner stdin = new Scanner(System.in);
      boolean valid = false;

      System.out.println("UWP Coffee Shop is open now....");
      System.out.println("Please enter temperature: ");

      while (!valid)
      {
         try
         {
            if (stdin.hasNextInt())
            {
               temperature = Integer.parseInt(stdin.nextLine());
               // Create a new coffee cup and set the temperature of its coffee.
               CoffeeCup cup = new CoffeeCup();
               cup.setTemperature(temperature);
               // Create and serve a customer.
               Customer cust = new Customer();
               
               CoffeeShop.serveCustomer(cust, cup);
            }
            else if (stdin.nextLine().equalsIgnoreCase("Q"))
            {
                 System.exit(0);
            }
            else
               throw new NumberFormatException();
         }
         catch (NumberFormatException e)
         {
            System.out.println("Must enter an integer or Q.");
         }
         finally
         {
            System.out.println("Enter temperature or enter Q to exit.");
         }
      }

   }

}
