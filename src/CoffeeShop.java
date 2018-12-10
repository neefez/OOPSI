
/**
 @author 
 */
class CoffeeShop 
{
   /**
    Public static method that can be directly called without instantiation
    Method call to drinkCoffee in Class Customer may throw an exception that 
    has to be handled in this method.
    Two exceptions should be handled: TooColdException and TooHotException
    @param Customer  customer
    @param CoffeeCup coffee served
    @return  void
    */
   
    public static void serveCustomer(Customer cust,CoffeeCup cup)
    {
     //TODO2 call method drinkCoffee and handle two exceptions. Please check
     //class TemperatureException to gain an idea how to get the exception 
     // information     
       
       try
       {
          cust.drinkCoffee(cup);
             
       }
       catch(TooHotException e)
       {
          System.out.println(e);
       }
       catch(TooColdException e)
       {
          System.out.println(e); 
       }    
       
       return;
        
    }
}
