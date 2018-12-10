/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * RpnEvaluator is the main class of this program. It contains the basic 
 * structure of the program and instantiates objects of the other classes, as
 * well as calling their methods, when required.
 * @author neefez
 */
class RpnEvaluator 
{
    Scanner stdin = new Scanner(System.in);
    private int num = 0;
    
    public void run() 
    {
       while(stdin.hasNextLine())
       {    
          Stack fracStack = new Stack();
          Queue start = new Queue();
          Queue results = new Queue();
          boolean valid = true;
          boolean calc = false;
          boolean operator = false;
          String init = stdin.nextLine();
          num++;
          if(init.equals("") || init.equals(" "))
          {
             System.out.println("Expression " + num + " is:"); 
             System.out.println("Invalid Expression");
             System.out.println("Intermediate results:");
          }       
          else
          {    
             StringTokenizer spacing = new StringTokenizer(init, " ");
             
             while(spacing.hasMoreTokens() && valid)
             {
                String input1 = spacing.nextToken();
                if(input1.equals("+"))
                {    
                   operator = true; 
                   Object obj1 = start.last();
                   Object obj2 = start.last();
                   if(obj1 instanceof Fraction && obj2 instanceof Fraction)
                   {    
                      calc = true;    
                      start.enqueue(obj2);
                      start.enqueue(obj1);
                   }
                   else
                   {
                      if(obj1 instanceof Fraction || obj2 instanceof Fraction)
                      {
                         if(obj1 instanceof Fraction)
                         {    
                            start.enqueue((String)obj2);    
                            start.enqueue((Fraction)obj1);
                         }
                         else
                         {
                            start.enqueue((Fraction)obj2);
                            start.enqueue((String)obj1);
                         }    
                      }    
                      else
                      {
                         start.enqueue((String)obj2);
                         start.enqueue((String)obj1);
                      }                          
                   }
                   start.enqueue(input1);
                }   
                else if(input1.equals("-"))
                {    
                   operator = true; 
                   Object obj1 = start.last();
                   Object obj2 = start.last();
                   if(obj1 instanceof Fraction && obj2 instanceof Fraction)
                   {    
                      calc = true;    
                      start.enqueue(obj2);
                      start.enqueue(obj1);
                   }
                   else
                   {
                      if(obj1 instanceof Fraction || obj2 instanceof Fraction)
                      {
                         if(obj1 instanceof Fraction)
                         {    
                            start.enqueue((String)obj2);    
                            start.enqueue((Fraction)obj1);
                         }
                         else
                         {
                            start.enqueue((Fraction)obj2);
                            start.enqueue((String)obj1);
                         }    
                      }    
                      else
                      {
                         start.enqueue((String)obj2);
                         start.enqueue((String)obj1);
                      }                          
                   } 
                   start.enqueue(input1);
                }   
                else if(input1.equals("*"))
                {  
                   operator = true;
                   Object obj1 = start.last();
                   Object obj2 = start.last();
                   if(obj1 instanceof Fraction && obj2 instanceof Fraction)
                   {    
                      calc = true;    
                      start.enqueue(obj2);
                      start.enqueue(obj1);
                   }
                   else
                   {
                      if(obj1 instanceof Fraction || obj2 instanceof Fraction)
                      {
                         if(obj1 instanceof Fraction)
                         {    
                            start.enqueue((String)obj2);    
                            start.enqueue((Fraction)obj1);
                         }
                         else
                         {
                            start.enqueue((Fraction)obj2);
                            start.enqueue((String)obj1);
                         }    
                      }    
                      else
                      {
                         start.enqueue((String)obj2);
                         start.enqueue((String)obj1);
                      }                          
                   } 
                   start.enqueue(input1);
                }   
                else if(input1.equals("#"))
                {
                   Object obj = start.last();
                   if(!(obj instanceof Fraction))
                   {
                      String s = (String)obj;
                      start.enqueue(s);   
                   }    
                   else
                   {    
                       if(calc || !operator)
                          start.enqueue(obj);
                   }
                   System.out.println("Expression " + num + " is: " + 
                                      start.print());
                   start.enqueue(input1);
                }   
                else
                {
                   try
                   {    
                      Fraction f = new Fraction(input1);
                      start.enqueue(f);
                   }
                   catch(Exception e)
                   {
                      valid = false; 
                      start.enqueue(input1);
                      System.out.println("Expression " + num + " is: " + 
                                         start.print());
                   }    
                }   
             }               
             
             while(!start.isEmpty() && valid)
             {
                Object obj = start.dequeue();
                String input1 = "";
                Fraction frac = new Fraction();
                if(obj instanceof String)
                   input1 = (String)obj; 
                else if(obj instanceof Fraction)
                   frac = (Fraction)obj;   
                
                if(input1.equals("+"))
                {
                   try
                   {    
                      Fraction f1 = (Fraction)fracStack.pop();
                      Fraction f2 = (Fraction)fracStack.pop();
                      f1.add(f2);
                      Fraction f3 = new Fraction(f1.toString());
                      results.enqueue(f3);
                      fracStack.push(f1);
                   }
                   catch(Exception e)
                   {
                      valid = false;
                   }                       
                }
                else if(input1.equals("-"))
                {
                   try
                   {
                      Fraction f1 = (Fraction)fracStack.pop();
                      Fraction f2 = (Fraction)fracStack.pop();
                      f2.subtract(f1);
                      Fraction f3 = new Fraction(f2.toString());
                      results.enqueue(f3);
                      fracStack.push(f2);
                   }
                   catch(Exception e)
                   {
                      valid = false;
                   }    
                }
                else if(input1.equals("*"))
                {
                   try
                   {    
                      Fraction f1 = (Fraction)fracStack.pop();
                      Fraction f2 = (Fraction)fracStack.pop();
                      f1.multiply(f2);
                      Fraction f3 = new Fraction(f1.toString());
                      results.enqueue(f3);
                      fracStack.push(f1);
                   }
                   catch(Exception e)
                   {
                      valid = false;
                   }    
                }
                else if(input1.equals("#"))
                {
                   if(fracStack.peek() instanceof Fraction &&
                      fracStack.size() == 1)
                   {    
                      Fraction resultFrac = (Fraction)fracStack.pop(); 
                      System.out.println("The value is: " + 
                                         resultFrac.toString());
                   }
                   else
                   {
                      System.out.println("Invalid Expression");
                   }
                   System.out.println("Intermediate results: " + 
                                      results.print());
                   results.clear();
                }   
                else
                {
                   try
                   {    
                      fracStack.push(frac);
                   }
                   catch(Exception e)
                   {
                      System.out.println("Invalid Expression");
                      valid = false;
                   }    
                }    
             } 
             
             if(!valid)
             {
                System.out.println("Invalid Expression");
                System.out.println("Intermediate results: " + results.print());
             }    
             
          }   
       }
       
       System.out.println("Normal Termination of Program 4.");    
    }  
}
