/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * Queue is an object that holds Object class objects in an array. Items are
 * added to the end of the array and removed from the front of the array.
 * @author neefez
 */
public class Queue 
{
   private final int MAX_ELEMENTS = 100;
   private int front, rear, count;
   private Object[] items;
   
   /**
    * Default constructor for an instance of class Queue, sets all indices to 0
    * and creates a new item array
    */
   public Queue()
   {
      items = new Object[MAX_ELEMENTS];
      front = rear = count = 0;
   }        
   
   /**
    * Enqueues an object into the item array by placing it at the end of the
    * queue, also increments rear and count
    * @param obj is the object being added to the queue
    */
   public void enqueue(Object obj)
   {
      items[rear] = obj;
      rear = (rear + 1) % items.length;
      ++count;
   }
   
   /**
    * Removes an object from the queue, returns it, increments front, and 
    * decrements count
    * @return the object that is removed from the queue
    */
   public Object dequeue()
   {
      Object obj = items[front];
      front = (front + 1) % items.length;
      --count; 
      return obj;
   }        
   
   /**
    * Removes the last object that was added to the queue, and decrements rear
    * and count. Used for checking the type of object at the end of the queue
    * @return the object at the end of the queue
    */
   public Object last()
   {
      if(rear == 0)
         rear = items.length;
      Object obj = items[rear - 1];
      rear--;
      count--;
      return obj;
   }        
   
   /**
    * Tells whether the queue is empty or not
    * @return true if empty, false if not
    */
   public boolean isEmpty()
   {
      return count == 0;
   }        
   
   /**
    * Tells whether the queue is full or not
    * @return true if full, false if not
    */
   public boolean isFull()
   {
      return count == items.length;
   }        
   
   /**
    * Empties the queue by setting all indices to 0
    */
   public void clear()
   {
      front = 0;
      rear = 0;
      count = 0;
   }        
   
   /**
    * Gives the number of items currently in the queue
    * @return an integer, the number of object in the item array
    */
   public int size()
   {
      return count;
   }        
   
   /**
    * Returns a String of all the items in the queue for future output
    * @return a String containing information for all the items in the queue
    */
   public String print()
   {
      String s = "";
      int j = front;
      for(int i = 0; i < count; i++)
      {
         if(j == items.length)
            j = 0;
         if(items[j] instanceof Fraction)    
         {    
            Fraction frac = (Fraction)items[j];
            s = s + frac.toString();
         }
         else if(items[j] instanceof Integer)
         {
             
            s = s + " " + items[j];
         }    
         else
            s = s + (String)items[j];
         
         j++;
      }      
      return s;
   }        
   
   /**
    * Testbed main for Queue
    */
   public static void main(String args[])
   {
      Scanner stdin = new Scanner(System.in);
      Queue q = new Queue();
      System.out.println("Enter 5 integers, separated by new lines.");
      int i1 = Integer.parseInt(stdin.nextLine());
      int i2 = Integer.parseInt(stdin.nextLine());
      int i3 = Integer.parseInt(stdin.nextLine());
      int i4 = Integer.parseInt(stdin.nextLine());
      int i5 = Integer.parseInt(stdin.nextLine());
      q.enqueue(i1);
      q.enqueue(i2);
      q.enqueue(i3);
      q.enqueue(i4);
      q.enqueue(i5);
      if(!q.isFull())
         System.out.println("The queue is not full.");
      System.out.println("You entered " + q.size() + " integers.");
      System.out.println("The last integer added was " + q.last());
      System.out.println("The first integer added was " + q.dequeue());
      System.out.println("The remaining integers are: " + q.print());
      q.clear();
      if(q.isEmpty())
         System.out.println("Queue successfully cleared."); 
      
      System.out.println("end of testbed");
   }        
}
