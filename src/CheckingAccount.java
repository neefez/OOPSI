/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * CheckingAccount is an object held in the ArrayLists of classes 
 * BankAccountManagement and Customer.
 * CheckingAccount extends Account, so it contains a balance, account number, 
 * account holder name, and account type, as well as its own methods.
 * @author neefez
 */
public class CheckingAccount extends Account
{ 
   private final int DECIMAL_PLACEMENT = 3; 
   private final int MAX_INDEX = 100;
   DecimalFormat money = new DecimalFormat("#.##");      
   
   /**
    * Parameterized constructor for CheckingAccount.
    * @param id inputted account number for the account
    * @param holder inputted name of the customer holding the account
    */
   public CheckingAccount(int id, String holder)
   {
      this.accountNumber = id;
      this.accountHolderName = holder;
      this.accountType = 1;
   }        
    
   /**
    * Gives the balance of the account.
    * @return the current balance
    */
   @Override
   public float getAccountBalance()
   { 
      return balance;
   }        
   
   /**
    * Gives the balance of the account.
    * Only exists because of the need for generality of getBalance() in class 
    * Account.
    * @return the current balance
    */
   @Override
   public float getBalance()
   {
      return this.getAccountBalance();
   }        
   
   /**
    * Gives a summary of the information of the account.
    * Checks to see if zeros need to be truncated from the end of the float
    * value of the balance.
    * @return a string of information about the account
    */
   @Override
   public String getAccountSummary()
   {
      String sBal = money.format(this.getAccountBalance());
      int decimalIndex = MAX_INDEX;
      for(int i = 0; i < sBal.length(); i++)
      {
         if(sBal.charAt(i) == '.')
            decimalIndex = i;    
      }       
      if(!this.isEmpty() && decimalIndex <= sBal.length() - DECIMAL_PLACEMENT)
      {   
         if(sBal.charAt(sBal.length() - 1) == '0')
         {      
            sBal = sBal.substring(0, sBal.length() - 1);
            if(sBal.charAt(sBal.length() - 1) == '0')
            {    
               sBal = sBal.substring(0, sBal.length() - 1);   
               sBal = sBal.substring(0, sBal.length() - 1); 
            }   
         } 
      }  
      return "Account holder is " + accountHolderName + "; Account number "
             + "is " + accountNumber + "; Account type is checking; Account "
             + "balance is " + sBal;      
   }        
   
   /**
    * Testbed main for CheckingAccount.
    * @param args the command line arguments.
    */
   public static void main(String[] args)
   {
      Scanner stdin = new Scanner(System.in);
      System.out.println("Please enter a name and account number");
      String name = stdin.nextLine();
      int accNum = stdin.nextInt();
      String junk = stdin.nextLine();
      CheckingAccount ca = new CheckingAccount(accNum, name);
      System.out.println(ca.getAccountSummary());
      System.out.println("Enter an amount to deposit:");
      float value = stdin.nextFloat();
      junk = stdin.nextLine();
      ca.deposit(value);
      System.out.println(ca.getAccountSummary());
      System.out.println("Enter an amount to withdraw:");
      value = stdin.nextFloat();
      junk = stdin.nextLine();
      ca.withdraw(value);
      System.out.println(ca.getAccountSummary());
      System.out.println("Enter a new name, account number, and balance");
      name = stdin.nextLine();
      accNum = stdin.nextInt();
      junk = stdin.nextLine();
      value = stdin.nextFloat();
      junk = stdin.nextLine();
      CheckingAccount ca2 = new CheckingAccount(accNum, name);
      ca2.deposit(value);
      if(ca2.compareTo(ca) == -1)
         System.out.println("The second account is larger");
      else if(ca2.compareTo(ca) == 1)
         System.out.println("The first account is larger");
      else
         System.out.println("The accounts are the same size");
      System.out.println("\nEnd of test");
   }        
}
