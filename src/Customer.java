/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Customer is an object that contains a social security number and a name, as 
 * well as a list of accounts held by the customer.
 * Accounts can be added to the customer specifically.
 * @author neefez
 */
public class Customer 
{
   private String SSN;
   private String name;
   private ArrayList<Account> accountList = new ArrayList<>();
   
   /**
    * Default constructor for class Customer.
    * Used for creating generalized customers before assigning their proper
    * information, e.g. when searching customerList in BankAccountManagement.
    */
   public Customer()
   {
      this.name = "DEFAULT_NAME";
      this.SSN = "SSN_ERROR";
   }        
   
   /**
    * Parameterized constructor for class Customer.
    * @param newname inputted name of the customer
    * @param newSSN inputted social security number for the customer
    */
   public Customer(String newname, String newSSN)
   {
      this.name = newname;
      this.SSN = newSSN;
   }        
   
   /**
    * Adds a given account to the customer's account list.
    * @param a the account to be added to the list
    */
   public void addAccount(Account a)
   {
      accountList.add(a);
   }     

   /**
    * Gives the name of the customer.
    * @return the customer name, a string
    */
   public String getName()
   {
      return this.name;
   }         
   
   /**
    * Sorts the customer's account list using the insertion sort algorithm.
    * After called, the list will be in ascending order by balance.
    */
   public void insertionSort()
   {
      for(int i = 1; i < accountList.size(); i++)
      {       
         Account acc = accountList.get(i);
         float balance = acc.getBalance(); 
         int j;
         for(j = i-1; 
             j >= 0 && accountList.get(j).getBalance() > balance; j--)
         { 
            accountList.set(j+1, accountList.get(j));    
         }    
         accountList.set(j+1, acc);
      } 
   }        
   
   /**
    * Gives the social security number of the customer.
    * Used for customer identification.
    * @return the customer's social security number, a string
    */
   public String getSSN()
   {
      return this.SSN;
   }        
   
   /**
    * Gives the account list for the customer.
    * @return all of the customer's account, in the form of an ArrayList
    */
   public ArrayList<Account> getAccountList()
   {
      return accountList;
   }        
   
   /**
    * Testbed main for class Customer.
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      Scanner stdin = new Scanner(System.in);
      System.out.println("Please enter a name and ssn");
      String name = stdin.nextLine();
      String SSN = stdin.nextLine();
      Customer cust = new Customer(name, SSN);
      System.out.println("You entered " + cust.getName() + " with SSN: " + 
                         cust.getSSN());
      System.out.println("Enter an account number");
      int accNum = stdin.nextInt();
      String junk = stdin.nextLine();
      System.out.println("Enter 0 for savings, 1 for checking");
      int type = stdin.nextInt();
      junk = stdin.nextLine();
      if(type == 0)
      {
         SavingsAccount sa = new SavingsAccount(accNum, name);
         cust.addAccount(sa);
         System.out.println(cust.getAccountList().get(0).getAccountSummary());
      }    
      else
      {
         CheckingAccount ca = new CheckingAccount(accNum, name); 
         cust.addAccount(ca);
         System.out.println(cust.getAccountList().get(0).getAccountSummary());
      }    
      System.out.println("\nEnd of test");
   }        
}
