/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author neefez
 */
public class Simulation
{
   Scanner stdin = new Scanner(System.in); 
   Queue waiting = new Queue();
   int numCustomers = 0;
   
   public void run()
   {
      System.out.println("Simulation of a waiting list starts to work...\n");       
      System.out.println("Please enter \n" +
                         "G to generate a customer,\n" +
                         "S to serve a customer,\n" +
                         "L to list all customers,\n" +
                         "Q to quit.");
      String command = stdin.nextLine();
      while(!command.equals("q") && !command.equals("Q"))
      {    
         if(command.equals("g") || command.equals("G"))
            generate(stdin);
         else if(command.equals("s") || command.equals("S"))
            serve(stdin);
         else if(command.equals("l") || command.equals("L"))
            list();
         
         System.out.println("Please enter \n" +
                            "G to generate a customer,\n" +
                            "S to serve a customer,\n" +
                            "L to list all customers,\n" +
                            "Q to quit.");
         command = stdin.nextLine();
      }
      quit(); 
   }        
   
   public void generate(Scanner stdin)
   {
      if(waiting.isFull())
      {
         System.out.println("The waiting line is full. Please leave.\n");
         return;
      }    
      else
      {
         numCustomers++; 
         System.out.println("Please enter customer name:");
         String name = stdin.nextLine();
         Customer cust = new Customer(numCustomers, name);
         waiting.enqueue(cust);
         System.out.println("The new customer is inline, Id:" + cust.getID() + 
                            " Name: " + name + "\n");
         return;
      }
   }
   
   public void serve(Scanner stdin)
   {
      if(waiting.isEmpty())
      {
         System.out.println("No customer waiting.\n");
         return;
      }    
      else
      {
         Customer decust = (Customer)waiting.dequeue(); 
         System.out.println("Customer Served, Id:" + decust.getID() + 
                            " Name: " + decust.getName() + "\n");
         return;
      }
   }
   
   public void list()
   {
      if(waiting.isEmpty())
      {
         System.out.println("No customer waiting.\n");
         return;
      }  
      else
      {
         waiting.list();
         System.out.println("");
         return;
      }
   }
   
   public void quit()
   {
      System.out.println("End of the simulation.");
      System.exit(0);
   }        
}
