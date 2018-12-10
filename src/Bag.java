/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Bag is an object used to hold an array of various types of objects.
 * Bag can be grown to fit as many elements as necessary.
 * @author neefez
 */
public class Bag 
{
   public final static int GROW_SIZE = 5;
   public final static int NOT_FOUND = -1;
   
   private Object[] items;
   int numItems = 0;
   
   /**
    * Constructs an instance of Bag by creating a new array.
    */
   public Bag()
   {
      items = new Object[GROW_SIZE];
   }        
    
   /**
    * Checks for the existence of an object inside the Bag.
    * @param item is the item that is being checked for
    * @return either null if the object is not found, or true if it is found
    */ 
   public Object contains(Object item)
   {
      int index = find(item);
      if(index == NOT_FOUND)
         return null;
      return item;
   }        
   
   /**
    * Searches for an object inside the Bag
    * @param item is the item being searched for
    * @return either the index of the item, or -1 if it is not found
    */
   public int find(Object item)
   {
      for(int i = 0; i < numItems; i++)
      {
         if(item instanceof Department && items[i] instanceof Department)
         {    
            Department dep1 = (Department)item;
            Department dep2 = (Department)items[i];
            if(dep1.getName().equals(dep2.getName()))
               return i;   
         }  
         else if(item instanceof Professor && items[i] instanceof Professor)
         {
            Professor prof1 = (Professor)item;
            Professor prof2 = (Professor)items[i];
            if(prof1.getId() == prof2.getId())
               return i;    
         }   
         else if(item instanceof Student && items[i] instanceof Student)
         {
            Student std1 = (Student)item;
            Student std2 = (Student)items[i];
            if(std1.getId() == std2.getId())
               return i;    
         }    
      }    
      return NOT_FOUND;
   }     

   /**
    * Checks to see if the bag is empty
    * @return true if the bag is empty, false if it is not
    */
   public boolean isEmpty()
   {
      return (numItems == 0);
   }        
   
   /**
    * Gives the number of items in bag
    * @return number of items in bag
    */
   public int getItemNumber()
   {
      return numItems;
   }        
   
   /**
    * Checks to see if the bag is full
    * @return true if the bag is full, false if it is not
    */
   public boolean isFull()
   {
      return (numItems == items.length);
   }        
   
   /**
    * Adds an inputted object into the bag. Checks to see if the object is
    * already in the bag first.
    * @param item is the object that is added to the bag
    * @return true if the object is successfully added, false if it isn't added
    */
   public boolean add(Object item)
   {
      if(contains(item) != null)
         return false;
      if(isFull())
         grow();
      items[numItems++] = item;
      
      return true;
   }        
   
   /**
    * Removes and object from the bag. Checks to see if the object is in the
    * bag first.
    * @param item is the object being removed from the bag
    * @return true if the item is successfully removed, false if it isn't
    */
   public boolean remove(Object item)
   {
      int index = find(item);
      if(index == NOT_FOUND)
        return false;
      items[index] = items[--numItems];
      items[numItems] = null;
      
      return true;
   }        
   
   /**
    * Increases the size of the bag so it can hold up to five more objects.
    */
   public void grow()
   {
      Object[] newBag = new Object[items.length + GROW_SIZE];
      for(int i = 0; i < numItems; i++)
      {
         newBag[i] = items[i];
      }    
      
      items = newBag;
   }        
   
   /**
    * Prints the items inside bag to the screen.
    */
   public String print()
   {
      String statement = "";
      for(int i = 0; i < numItems; i++)
      {
         statement = statement + items[i].toString() + "\n";
      }
      return statement;
   }
   
   /**
    * Returns an item based on its id.
    * @param id is the id to identify the item with
    * @return the Object that has the id
    */
   public Object getItem(int id)
   {
      for(int i = 0; i < numItems; i++)
      {
         if(items[i] instanceof Student) 
         {   
            Student std = (Student)items[i]; 
            if(std.getId() == id)
               return std;    
         }   
         else if(items[i] instanceof Professor)
         {
            Professor prof = (Professor)items[i];
            if(prof.getId() == id)
               return prof;    
         }    
      }    
      
      return null;
   }    
   
   /**
    * Returns an Object from the bag based on a string.
    * @param name a string that is inputted to find the item
    * @return the desired Object or null if it is not found
    */
   public Object getFromName(String name)
   {
      for(int i = 0; i < numItems; i++)
      {
         if(items[i] instanceof Department)
         {
            Department dep = (Department)items[i];
            if(dep.getName().equals(name))
                return dep;
         }    
         if(items[i] instanceof Course)
         {
            Course crs = (Course)items[i];
            if(crs.getId().equals(name))
               return crs;    
         }    
      }    
      
      return null;
   }        

   /**
    * Returns an object based on its index in the bag
    * @param index the index of the object
    * @return the object in question
    */
   public Object getFromIndex(int index)
   {
      return items[index];
   }         
}
