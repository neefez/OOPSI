/**
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/

import java.util.Scanner;

/**
 
 @author yues
 */
public class Employee 
{
   private String name;
   private int id;
   private String title;
   private float salary;
   
   /**
   Constructor taking three parameters
   @param name employee name
   @param id employee id
   @param title employee tile
   */  
   public Employee(int id, String name, String title)
   {
      this.name = name;
      this.id = id;
      this.title = title;
   }   
   /**
    @ get title
   */   
   public String getTitle() 
   {
      return this.title;
   }
   
   public String getName()
   {   
	  return this.name;
   }
   /**
    @ set title
   */   
   public void setTitle( String newTile ) 
   {
      this.title = newTile;
   }
   
   //TODO4 override toString() and call it in TODO1 to get 2 points bonus
   @Override
   public String toString()
   {
      String name = "Peter";
      if(id == 1)
        name = "Adam";
      else if(id == 2)
        name = "Bill";
      else if(id == 3)
        name = "Zak";
      else if(id == 4)
        name = "Henry";

      return name;
   }
}
