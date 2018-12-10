/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class Account is a class used as a base for the classes CheckingAccount and 
 * SavingsAccount. Account contains the variables and methods that are shared by
 * classes CheckingAccount and SavingsAccount.
 * @author neefez
 */
public abstract class Account implements Comparable
{
   protected float balance;
   protected int accountNumber;
   protected String accountHolderName;
   protected int accountType;
   protected static int totalAccountNumber = 0; 
   /**
    * Gives the balance of the account while applying interest for 6 months.
    * @return the new amount of money in the account
    */
   public abstract float getAccountBalance();
   /**
    * Gives the balance of the account without applying interest.
    * @return the amount of money in the account
    */
   public abstract float getBalance();
   /**
    * Gives a summary of the account information for use of output
    * @return a string of account information
    */
   public abstract String getAccountSummary();
   
   /**
    * Compares the balances of two account for use of sorting them
    * @param obj the account that the called account is compared to
    * @return 1 if called account has a larger balance, -1 if called account has
    *         smaller balance, 0 if equal balances
    */
   @Override
   public int compareTo(Object obj)
   {
      if(obj instanceof Account)
      {
         Account acc = (Account)obj; 
         if(acc.getBalance() > this.getBalance())
            return 1;
         else if(acc.getBalance() < this.getBalance())
            return -1;
         else return 0;
      }   
      return 0;
   }        
   
   /**
    * Removes a given amount of money from the account.
    * @param amount the amount to be removed
    * @return false if the amount is larger than the current balance, else true
    */
   public boolean withdraw(float amount)
   {
      if(amount > this.getBalance())
         return false;
      else
      {
         balance = balance - amount;        
         return true;
      }    
   }
   
   /**
    * Adds an inputted amount into the balance of the account.
    * @param amount the amount to be added to the account
    * @return true if successfully deposited, else false
    */
   public boolean deposit(float amount)
   {
      if(this.getAccountBalance() >= 0)    
      {
         balance = balance + amount;
         return true;
      }
      else
         return false;
   }
   
   /**
    * Tells whether the account has no money in it.
    * @return true if the account has no balance, else false
    */
   public boolean isEmpty()
   {
      return balance == 0;
   }        
}
