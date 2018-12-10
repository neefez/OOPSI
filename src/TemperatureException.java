/*
 Leave this class intact
 */

/**
 
 @author yues
 */
public class TemperatureException extends Exception
{
   private int temperature; // in Celsius

   public TemperatureException(int temperature)
   {
      this.temperature = temperature;
   }

   public int getTemperature()
   {
      return temperature;
   }
   @Override
   public String toString()
   {
      return super.toString() + ": temperature is " + temperature;
   }
}
