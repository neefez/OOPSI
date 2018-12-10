/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author neefez
 */
public class Order implements Comparable
{
   private int id;
   private int quantity;
   private int totalPrice;
   private Product product;
   
   public Order(Product p, int quan, int newID)
   {
      this.product = p;
      this.quantity = quan;
      this.id = newID;
      totalPrice = quantity * product.getPrice();
   }        
   
   @Override 
   public int compareTo(Object obj)
   {
      if(obj instanceof Order)
      {
         Order ord = (Order)obj; 
         if(this.getTotalPrice() > ord.getTotalPrice())
            return 1;
         else if(this.getTotalPrice() < ord.getTotalPrice())
            return -1;
      }    
      return 0;
   }    
   
   public int getTotalPrice()
   {
      return totalPrice;
   }        
   
   @Override
   public String toString()
   { 
      return "Id: " + this.id + ", Product: " + this.product.getName() + 
             ", Quantity: " + this.quantity + ", total price: " + 
             this.totalPrice + ".0";
   }
}
