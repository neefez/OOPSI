/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neefez
 */
public class Product 
{
   private String name;
   private int unitPrice;
    
   public Product(String n, int price)
   {
      this.name = n;
      this.unitPrice = price;
   }
   
   public int getPrice()
   {
      return unitPrice;
   }        
   
   public String getName()
   {
      return name;
   }        
}
