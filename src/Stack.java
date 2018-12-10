/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 * Stack is an object that holds an array of objects of the class Object. 
 * Objects are added to the end of the array and removed from the same end of
 * the array.
 * @author neefez
 */
public class Stack 
{
   private final int GROW_SIZE = 5; 
   private int top = 0;
   private Object[] elements;
   
   /**
    * Default constructor for Stack, creates a new array
    */
   public Stack()
   {
      elements = new Object[GROW_SIZE];
   }        
   
   /**
    * Tells whether the Stack is full
    * @return true if full, false if not
    */
   public boolean isFull()
   {
      return top == elements.length;
   }        
   
   /**
    * Tells whether the Stack is empty
    * @return true if empty, false if not
    */
   public boolean isEmpty()
   {
      return top == 0;
   }        
   
   /**
    * Gives the current number of items in the Stack
    * @return an integer, the number of items in the array
    */
   public int size()
   {
      return top;
   }        
   
   /**
    * Adds an object to the end of the Stack and increments top
    * @param obj the item added to the end of the array
    */
   public void push(Object obj)
   {
      if(this.isFull())
         this.grow();
      elements[top++] = obj;
   }        
   
   /**
    * Removes an object from the end of the Stack and decrements top
    * @return the object that is removed from the array
    */
   public Object pop()
   {
      if(this.peek() == null)
         return null;    
      return elements [--top];
   }    
   
   /**
    * Looks at the object at the end of the Stack and returns it without 
    * removing the object from the Stack
    * @return the object at the end of the Stack
    */
   public Object peek()
   {
      if (top == 0)
         return null;  
      return elements[top - 1]; 
   }
   
   /**
    * Increases the size of the array in Stack if there needs to be more space
    * for elements.
    */
   private void grow()
   {
      Object[] expandedStack = new Object[elements.length + GROW_SIZE];
      for(int i = 0; i < elements.length; i++)
         expandedStack[i] = elements[i];
      elements = expandedStack;
   }        
   
   /**
    * Testbed main for Stack
    */
   public static void main(String args[])
   {
      Scanner stdin = new Scanner(System.in); 
      Stack s = new Stack();
      if(s.isEmpty())
         System.out.println("The stack is empty.");   
      System.out.println("Enter 6 integers, separated by new lines.");
      int i1 = Integer.parseInt(stdin.nextLine());
      int i2 = Integer.parseInt(stdin.nextLine());
      int i3 = Integer.parseInt(stdin.nextLine());
      int i4 = Integer.parseInt(stdin.nextLine());
      int i5 = Integer.parseInt(stdin.nextLine());
      int i6 = Integer.parseInt(stdin.nextLine());  
      s.push(i1);
      s.push(i2);
      s.push(i3);
      s.push(i4);
      s.push(i5);
      if(s.isFull())
         System.out.println("The stack is full."); 
      s.push(i6);      
      System.out.println("You entered " + s.size() + " integers.");
      System.out.println("Top integer in the stack is: " + s.peek());
      System.out.println("Inputted integers in reverse: " + s.pop() + " " + 
                         s.pop() + " " + s.pop() + " " + s.pop() + " " + s.pop() 
                         + " " + s.pop());
      
      System.out.println("end of testbed");
   }        
}
