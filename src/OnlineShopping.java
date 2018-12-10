/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author neefez
 */
public class OnlineShopping 
{
   Scanner stdin = new Scanner(System.in);
   private final int MAX_ORDERS = 100;
   private final int IPAD_PRICE = 500;
   private final int IPHONE_PRICE = 600;
   private final int MACBOOK_PRICE = 1999;
   private final int NEXUS_PRICE = 1100;
   private final int KINDLE_PRICE = 120;
   private ArrayList<Product> productList = new ArrayList<Product>();
   private Order[] orderList = new Order[MAX_ORDERS];
   int numOrders = 0;
   
   public void run()
   {
      preSetProductList();        
      System.out.println("Welcome to the Online Shopping System...\n");       
      System.out.println("Please enter \n" +
                         "O to create an order,\n" +
                         "L to list all orders sorted by totalPrice\n" +
                         "Q to quit.");
      String command = stdin.nextLine();
      while(!command.equals("q") && !command.equals("Q"))
      {    
         if(command.equals("o") || command.equals("O"))
            newOrder(stdin);
         else if(command.equals("l") || command.equals("L"))
            listOrders();
         
         System.out.println("Please enter \n" +
                            "O to create an order,\n" +
                            "L to list all orders sorted by totalPrice\n" +
                            "Q to quit.");
         command = stdin.nextLine();
      }
      quit();    
   }
   
   public void preSetProductList()
   {
      productList.add(new Product("ipad", IPAD_PRICE));
      productList.add(new Product("iphone", IPHONE_PRICE));
      productList.add(new Product("macbook", MACBOOK_PRICE));
      productList.add(new Product("nexus", NEXUS_PRICE));
      productList.add(new Product("kindle", KINDLE_PRICE));
   }      
   
   public void newOrder(Scanner stdin)
   {
      System.out.println("Please enter the name of the product to purchase:");
      String productName = stdin.nextLine();
      int productPrice = 0;
      
      try
      {
         productPrice = checkProduct(productName);
      }
      catch(Exception e)
      {
         System.out.println("No product found! Please try again.\n");
         return;
      }
      
      System.out.println("Please enter the number of products:");
      int quantityProducts;
      
      try
      {
         quantityProducts = Integer.parseInt(stdin.nextLine());    
      }
      catch(Exception e)
      {
         System.out.println("Input error: " + e + "\n");
         return;
      } 
      
      Product p = new Product(productName, productPrice); 
      orderList[numOrders] = new Order(p, quantityProducts, numOrders+1);    
      System.out.println("The new order is created, " + 
                         orderList[numOrders].toString() + "\n");
      numOrders++;    
   }        
   
   public void listOrders()
   {
      sort(); 
      if(numOrders < 1)
         System.out.println("Order list is empty.\n");
      else
      {    
         for(int i = 0; i < numOrders; i++)
         {
            System.out.println(orderList[i].toString());
         }
         System.out.println("");
      }   
   }        
   
   public void sort()
   {
      boolean valid = false; 
      while(!valid)
      {    
         valid = true; 
         for(int i = 0; i < numOrders - 1; i++)
         {
            if(orderList[i].compareTo(orderList[i+1]) > 0)
            {    
               Order temp = orderList[i];
               orderList[i] = orderList[i+1];
               orderList[i+1] = temp;
               valid = false;
            }            
         }    
      }   
   }        
   
   public int checkProduct(String name) throws Exception
   {
      if(name.equals("ipad"))
         return IPAD_PRICE;
      else if(name.equals("iphone"))
         return IPHONE_PRICE;
      else if(name.equals("macbook"))
         return MACBOOK_PRICE;
      else if(name.equals("nexus"))
         return NEXUS_PRICE;
      else if(name.equals("kindle"))
         return KINDLE_PRICE;
      else
      {   
         Exception e = new Exception(); 
         throw e;
      }   
   }
   
   public void quit()
   {
      System.out.println("End of the Online Shopping System.");
      System.exit(0);
   }     
}
