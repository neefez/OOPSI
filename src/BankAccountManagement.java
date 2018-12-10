/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

/**
 * BankAccountManagement is an object that contains menus that are outputted and
 * maintains lists of accounts and customers.
 * Outputs menus for the user and contains the Account and Customer objects.
 * @author neefez
 */
public class BankAccountManagement 
{
   private final int WITHDRAW = 2; 
   private final int DEPOSIT = 3;
   private final int MAIN_MENU = 4;
   private final int HYPHEN1 = 3;
   private final int HYPHEN2 = 6;
   protected static int totalCustomerNumber = 0;
   Scanner stdin = new Scanner(System.in);
   ArrayList<Account> acctList = new ArrayList<>();
   ArrayList<Customer> customerList = new ArrayList<>();
   DecimalFormat money = new DecimalFormat("#.##");
   
   /**
    * Start of the execution of the program; outputs menus for the user.
    * Contains the ability to create new accounts and customers and gives access 
    * to the methods for the accounts based on user input.
    */
   public void run()
   {
      System.out.println("Banking System is running...!");     
      String command = "";
      while(!command.equals("q") && !command.equals("Q"))
      {
         System.out.println("Please enter C to create a new account, M to "
                            + "manage an existing account, L to list all "
                            + "account in the order by balance from lowest to "
                            + "highest, Q to quit");
         command = stdin.nextLine();
         if(command.equals("c") || command.equals("C"))
            createNewAccount(stdin);
         else if(command.equals("m") || command.equals("M"))
            manageAccount(stdin);
         else if(command.equals("l") || command.equals("L"))
            listAllAccounts(stdin);
         else if(!command.equals("q") && !command.equals("Q"))
            System.out.println("Invalid command.");
      }        
      quit();
   }
   
   /**
    * Makes a new account for a given customer.
    * The customer is identified by their social security number. Improper 
    * inputs are handled by various methods.
    * @param stdin Scanner to read user input
    */
   public void createNewAccount(Scanner stdin)
   {
      System.out.println("Please enter the name of the customer:");
      String name = stdin.nextLine();
      System.out.println("Please enter the SSN of the customer (***-**-****):");
      String SSN = checkForSSN(stdin);     
      Customer cust = checkForCustomer(name, SSN); 
      System.out.println("Please select account type: 1.Savings, 2.Checking");
      int accType = checkAccountType(stdin);     
      System.out.println("Please enter account number with five digits:");
      int num = checkForAccountNumber(stdin);  
      if(accType == 1)
      {   
         SavingsAccount acc = new SavingsAccount(num, cust.getName());
         acctList.add(acc);        
         cust.addAccount(acc);
      }   
      else if(accType == 2)
      {    
         CheckingAccount acc = new CheckingAccount(num, cust.getName()); 
         acctList.add(acc);
         cust.addAccount(acc);
      }           
      System.out.println("The new account has been created. Account summary:");
      System.out.println(acctList.get(
                             Account.totalAccountNumber).getAccountSummary());
      Account.totalAccountNumber++;  
      customerList.add(cust);
      totalCustomerNumber++;
   }   
   
   /**
    * Gives the user options to manage an account.
    * The user can enter various commands to change account balance or find
    * account information
    * @param stdin Scanner to read user input
    */
   public void manageAccount(Scanner stdin)
   {
      if(Account.totalAccountNumber == 0)
      {
         System.out.println("The number of accounts is 0. Please create an "
                            + "account first.");
         return;
      }    
      System.out.println("Please enter your account number:");
      int accNum = checkExistingAccount(stdin); 
      int accIndex = -1;
      for(Account acc : acctList)
      {
         if(acc.accountNumber == accNum)
            accIndex = acctList.indexOf(acc);
      } 
      boolean valid = false;
      while(!valid)
      {    
         valid = true; 
         System.out.println("Please select account type: 1.View account "
                            + "summary, 2.Withdraw, 3.Deposit, 4.Main menu");       
         int command = checkForCommand(stdin);
         Account acct = acctList.get(accIndex);
         switch (command)
         {
            case 1: System.out.println(acct.getAccountSummary());
                    break;
            case WITHDRAW: makeWithdrawal(stdin, acct);
                    break;
            case DEPOSIT: makeDeposit(stdin, acct);
                    break; 
            case MAIN_MENU: break;                  
            default: valid = false;
                     System.out.println("Invalid type. Please try again");
                     break;
         }
      } 
   }   
   
   /**
    * Outputs a list of all of the accounts in the system.
    * Also tells how many accounts currently exist in the system
    * @param stdin Scanner to read user input
    */
   public void listAllAccounts(Scanner stdin)
   {
      System.out.println("The total number of accounts is " + 
                         Account.totalAccountNumber);
      insertionSortInArrayList(acctList);
      for(Account acc : acctList)
      {
         System.out.println(acc.getAccountSummary());
      }    
   }
   
   /**
    * Checks an input to see if it is a float.
    * Catches an exception if the input is improper
    * @param stdin Scanner to read user input
    * @return the proper float value as determined by the method
    */
   public float checkForFloat(Scanner stdin)
   {
      String number;
      float fValue = -1;
      boolean valid = false;     
      while(!valid)
      {    
         try
         {
            valid = true;
            fValue = stdin.nextFloat();
         }   
         catch(InputMismatchException e)
         {
            valid = false; 
            System.out.println("Invalid Input. " + e + " Please try again");
            number = stdin.nextLine();
         }        
         if(valid)
            number = stdin.nextLine();  
      }   
      return fValue;
   }        
   
   /**
    * Sorts the list of accounts by using the insertion sort algorithm.
    * Makes the list be in ascending order by balance using compareTo
    * @param acctList the ArrayList of the accounts
    */
   public void insertionSortInArrayList (ArrayList<Account> acctList)
   {
      for(int i = 1; i < acctList.size(); i++)
      {       
         Account acc = acctList.get(i);
         float balance = acc.getBalance(); 
         int j;
         for(j = i-1; j >= 0 && acctList.get(j).compareTo(acc) < 0; 
             j--)
         { 
            acctList.set(j+1, acctList.get(j));    
         }    
         acctList.set(j+1, acc);
      }    
   }        
   
   /**
    * Handles the user input necessary to make a withdrawal.
    * Makes the withdrawal if the amount is valid
    * @param stdin Scanner to read user input
    * @param acct the account that is being withdrawn from
    */
   public void makeWithdrawal(Scanner stdin, Account acct)
   {
      if(acct.isEmpty())
      {    
         System.out.println("The balance is 0.0, Please deposit before "
                            + "withdraw.");
         return;
      }
      System.out.println("Please enter the amount of money:");
      float amount = checkForFloat(stdin);
      if(amount == Math.round(amount))
      {
         int intAm = Math.round(amount);
         boolean withdrawn = acct.withdraw(amount);
         if(!withdrawn)
            System.out.println("You don't have enough balance. Please try a "
                               + "different amount.");    
         else          
            System.out.println("Your withdrawal has been accepted with an "
                               + "amount of " + intAm);                     
      }
      else
      {   
         boolean withdrawn = acct.withdraw(amount);
         if(!withdrawn)
            System.out.println("You don't have enough balance. Please try a "
                               + "different amount.");
         else
            System.out.println("Your withdrawal has been accepted with an "
                               + "amount of " + money.format(amount));                      
      }
   }        
   
   /**
    * Handles the user input necessary to make a deposit.
    * Make the deposit of the given amount
    * @param stdin Scanner to read user input
    * @param acct the account that is being deposited into
    */
   public void makeDeposit(Scanner stdin, Account acct)
   {
      System.out.println("Please enter the amount of money:");
      float amount = checkForFloat(stdin);
      if(amount == Math.round(amount))
      {
         int intAm = Math.round(amount);
         System.out.println("Your deposit has been received with an amount of " 
                            + intAm);
      }    
      else
         System.out.println("Your deposit has been received with an amount of " 
                            + money.format(amount));
      acct.deposit(amount);
   }        
   
   /**
    * Checks an input to see if it is a valid command.
    * @param stdin Scanner to read user input
    * @return the proper command, as determined by the method
    */
   public int checkForCommand(Scanner stdin)
   {
      int command = 0;    
      String tempType;
      boolean validType = false;
      while(!validType)
      {    
         try
         {
            validType = true;
            command = stdin.nextInt();
         }   
         catch(InputMismatchException e)
         {
            validType = false; 
            System.out.println("Invalid Input. " + e + " Please try again");
            tempType = stdin.nextLine();
         }    
         if(command != 1 && command != WITHDRAW && command != DEPOSIT && 
            command != MAIN_MENU && validType)
         {    
            validType = false;         
            System.out.println("Invalid type. Please try again");
         }   
      }
      tempType = stdin.nextLine();
      return command;
   }
           
   /**
    * Checks the list of customers to see if the inputted customer exists.
    * If a customer with the same social security number is found, accesses
    * that customer from the ArrayList.
    * @param name the inputted name of the customer
    * @param SSN the inputted social security number of the customer
    * @return new Customer if not in the list, else the existing Customer
    */
   public Customer checkForCustomer(String name, String SSN)
   {
      Customer cust = new Customer(); 
      for(Customer c : customerList)
      {
         if(c.getSSN().equals(SSN))
            cust = c;
      } 
      if(cust.getSSN().equals("SSN_ERROR"))
         cust = new Customer(name, SSN); 
      
      return cust;
   }        
   
   /**
    * Checks the user's input to see if it is a proper integer to be used for
    * an account number.
    * @param stdin Scanner to read user input
    * @return a proper account number
    */
   public int checkForAccountNumber(Scanner stdin)
   {
      String number;
      int num = -1;
      boolean validAccount = false;    
      while(!validAccount)
      {    
         try
         {
            validAccount = true;
            num = stdin.nextInt();
         }   
         catch(InputMismatchException e)
         {
            validAccount = false; 
            System.out.println("Invalid Input. " + e + " Please try again");
            number = stdin.nextLine();
         }    
         if(num > 99999 || num < 10000 && validAccount)
         {    
            validAccount = false;         
            System.out.println("Invalid account number. Please try again");
         }   
      }
      number = stdin.nextLine();
      
      return num;
   }        
   
   /**
    * Checks to see if the account number already exists in the system.
    * @param stdin Scanner to read user input
    * @return a proper, existing account number
    */
   public int checkExistingAccount(Scanner stdin)
   {
      String number;
      int accNum = -1;
      boolean validAccount = false;     
      int accIndex = -1;
      while(!validAccount)
      {    
         try
         {
            validAccount = true;
            accNum = stdin.nextInt();
         }   
         catch(InputMismatchException e)
         {
            validAccount = false; 
            System.out.println("Invalid Input. " + e + " Please try again");
            number = stdin.nextLine();
         }    
         if(accNum > 99999 || accNum < 10000 && validAccount)
         {    
            validAccount = false;         
            System.out.println("Invalid number. Please try again");
         }       
         if(validAccount)
            number = stdin.nextLine();
      
         for(Account acc : acctList)
         {
            if(acc.accountNumber == accNum)
               accIndex = acctList.indexOf(acc);
         } 
         if(accIndex == -1 && validAccount)
         {    
            validAccount = false;   
            System.out.println("The account number you entered does not exist."
                               + " Please try again");
         }   
      }
      return accNum;
   }        
   
   /**
    * Checks to see if the inputted social security number is of the proper
    * format and length.
    * @param stdin Scanner to read user input
    * @return a properly formatted social security number
    */
   public String checkForSSN(Scanner stdin)
   {
      String SSN = stdin.nextLine();
      boolean valid = false;
      while(!valid)
      {    
         try
         {
            valid = true;
            checkSSNLength(SSN);
            checkSSNCharacters(SSN);
         }   
         catch(IllegalArgumentException e)
         {
            valid = false; 
            System.out.println("Invalid Social Security Number. " + e);
            System.out.println("Please enter valid SSN:");
            SSN = stdin.nextLine();
         }    
      }
      return SSN;
   }        
   
   /**
    * Checks to see if the inputted account type is a valid integer.
    * @param stdin Scanner to read user input
    * @return a proper account type
    */
   public int checkAccountType(Scanner stdin)
   {
      int accType = 0; 
      String tempType;
      boolean validType = false;
      while(!validType)
      {    
         try
         {
            validType = true;
            accType = stdin.nextInt();
         }   
         catch(InputMismatchException e)
         {
            validType = false; 
            System.out.println("Invalid Input. " + e + " Please try again");
            tempType = stdin.nextLine();
         }    
         if(accType != 1 && accType != 2 && validType)
         {    
            validType = false;         
            System.out.println("Invalid type. Please try again");
         }   
      }
      tempType = stdin.nextLine();
      return accType;
   }        
   
   /**
    * Checks to see if the inputted social security number is of the correct
    * length.
    * If the string is too short or too long, throws an exception
    * @param SSN the inputted social security number
    * @throws IllegalArgumentException says the issue with the string
    */
   public void checkSSNLength(String SSN) throws IllegalArgumentException
   {
      IllegalArgumentException e = new IllegalArgumentException(1); 
      if(SSN.length() != 11)
         throw e;    
   }        
   
   /**
    * Checks to see if the inputted social security number is of the correct
    * format.
    * If the hyphens are not in the correct location, or if there are
    * non-numeral characters between them, throws an exception
    * @param SSN the inputted social security number
    * @throws IllegalArgumentException says the issue with the string
    */
   public void checkSSNCharacters(String SSN) throws IllegalArgumentException
   {
      
      IllegalArgumentException e = new IllegalArgumentException(0);
      if(SSN.charAt(HYPHEN1) != '-' || SSN.charAt(HYPHEN2) != '-')
         throw e;    
      for(int i = 0; i < HYPHEN1; i++)
      {
         if(SSN.charAt(i) < '0' || SSN.charAt(i) > '9')
            throw e;
      }    
      for(int j = HYPHEN1 + 1; j < HYPHEN2; j++)
      {
         if(SSN.charAt(j) < '0' || SSN.charAt(j) > '9')
            throw e;  
      }    
      for(int k = HYPHEN2 + 1; k < SSN.length(); k++)
      {
         if(SSN.charAt(k) < '0' || SSN.charAt(k) > '9')
            throw e;    
      }    
   }        
   
   /**
    * Exits the program after the user has entered the Q command.
    */
   public void quit()
   {
      System.out.println("Thanks for using Banking System. Bye!");
      System.exit(0);
   }           
}
