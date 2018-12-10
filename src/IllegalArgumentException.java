/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * IllegalArgumentException is an exception object that is thrown by various
 * methods in BankAccountManagement.
 * IllegalArgumentException is used to identify improper social security numbers
 * @author neefez
 */
public class IllegalArgumentException extends Exception
{
   private int illegalType; 
    
   /**
    * Parameterized constructor for IllegalArgumentException.
    * @param type integer that determines whether the social security number was
    *             of incorrect length or improper format
    */
   public IllegalArgumentException(int type)
   {
      this.illegalType = type;
   }        
   
   /**
    * Gives a string of information about the exception.
    * @return exception information, a string
    */
   @Override
   public String toString()
   {
      if(this.illegalType == 1)
         return "java.lang." + super.toString() + ": The length of ssn has to"
                + " be 11.";
      else
         return "java.lang." + super.toString() + ": wrong format";
   }
   
   /**
    * Testbed main for IllegalArgumentException.
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      Scanner stdin = new Scanner(System.in);
      System.out.println("Enter 0 for wrong format, 1 for wrong length");
      int type = stdin.nextInt();
      IllegalArgumentException e = new IllegalArgumentException(type);
      System.out.println(e.toString());
      System.out.println("\nEnd of test");
   }        
}
