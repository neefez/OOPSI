/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * Objects of the type Fraction contain two integers, a numerator and a
 * denominator, which are used to calculate addition, subtraction, and
 * multiplication of fractions. Class Fraction also contains a method to reduce
 * the fraction.
 * @author neefez
 */
public class Fraction 
{
   private int numerator;
   private int denominator;
   
   /**
    * Default constructor that initializes a fraction to (0/1)
    */
   public Fraction()
   {
      this.numerator = 0;
      this.denominator = 1;
   }        
   
   /**
    * Parameterized constructor that instantiates a fraction with the numerator
    * and denominator coming from an inputted String.
    * @param s is the inputted String containing the numerator and denominator
    */
   public Fraction(String s)
   {
      StringTokenizer st = new StringTokenizer(s, "/"); 
      String p1 = st.nextToken();
      String p2 = st.nextToken();
      StringTokenizer noPara1 = new StringTokenizer(p1, "(");
      p1 = noPara1.nextToken();
      StringTokenizer noPara2 = new StringTokenizer(p2, ")");
      p2 = noPara2.nextToken();
      this.numerator = Integer.parseInt(p1);
      this.denominator = Integer.parseInt(p2);
      this.reduce();
   }        
   
   /**
    * Adds two fractions together, with the result being stored in the fraction
    * that gets called.
    * @param f is the fraction that is added to the called fraction
    */
   public void add(Fraction f)
   {  
      if(this.denominator != f.getDenominator())
      {
         int temp1 = this.denominator;
         int temp2 = f.getDenominator();
         this.denominator = this.denominator * temp2;
         this.numerator = this.numerator * temp2;
         f.setDenominator(f.getDenominator() * temp1);
         f.setNumerator(f.getNumerator() * temp1);
      }
      this.numerator = this.numerator + f.getNumerator();
      this.reduce();
   }
   
   /**
    * Subtracts a fraction from the called fraction and stores the result in
    * the called fraction.
    * @param f is the fraction that gets subtracted from the called fraction
    */
   public void subtract(Fraction f)
   {
      if(this.denominator != f.getDenominator())
      {
         int temp1 = this.denominator;
         int temp2 = f.getDenominator();
         this.denominator = this.denominator * temp2;
         this.numerator = this.numerator * temp2;
         f.setDenominator(f.getDenominator() * temp1);
         f.setNumerator(f.getNumerator() * temp1);
      }
      this.numerator = this.numerator - f.getNumerator();
      this.reduce();
   }
   
   /**
    * Multiplies a called fraction by a given fraction and stores the result in
    * the called fraction.
    * @param f is the fraction that is multiplied to the called fraction
    */
   public void multiply(Fraction f)
   {
      this.numerator = this.numerator * f.getNumerator();
      this.denominator = this.denominator * f.getDenominator();
      this.reduce();
   }        
   
   /**
    * Reduces a fraction by finding common factors in the numerator and
    * denominator by using modulus.
    */
   private void reduce()
   {
      int lowest, highest, temp;
      if(Math.abs(numerator) >= Math.abs(denominator))
      {    
         lowest = Math.abs(denominator);
         highest = Math.abs(numerator);
      }
      else
      {
         lowest = Math.abs(numerator);
         highest = Math.abs(denominator);
      }
      while(lowest != 0)
      {
         temp = lowest;
         lowest = highest % lowest;
         highest = temp;
      }    
      numerator = numerator / highest;
      denominator = denominator / highest;  
      
      if(denominator < 0)
      {
         numerator = numerator * (-1);
         denominator = denominator * (-1);        
      }    
   }        
   
   /**
    * Gives the numerator of a fraction
    * @return the numerator for the fraction, an integer
    */
   public int getNumerator()
   {
      return numerator;
   }        
   
   /**
    * Gives the denominator of a fraction
    * @return the denominator for the fraction, an integer
    */
   public int getDenominator()
   {
      return denominator;
   }   
   
   /**
    * Sets the numerator of a fraction to an inputted integer
    * @param num the desired new numerator for the fraction
    */
   public void setNumerator(int num)
   {
      this.numerator = num;
   }        
   
   /**
    * Sets the denominator of a fraction to an inputted integer
    * @param dem the desired new denominator for the fraction
    */
   public void setDenominator(int dem)
   {
      this.denominator = dem;
   }       
   
   /**
    * Provides the information of the fraction in a String format for output
    * @return the String form of the fraction
    */
   @Override
   public String toString()
   {
      this.reduce(); 
      return "(" + numerator + "/" + denominator + ")";
   }        
   
   /**
    * Testbed main for Fraction
    */
   public static void main(String args[])
   {
      System.out.println("Enter two fractions, a numerator, and a denominator"
                         + ", separated by new lines.");
      Scanner stdin = new Scanner(System.in);
      Fraction f1 = new Fraction(stdin.nextLine());
      Fraction f2 = new Fraction(stdin.nextLine());
      int numerator = Integer.parseInt(stdin.nextLine());
      int denominator = Integer.parseInt(stdin.nextLine());
      
      Fraction f4 = new Fraction(f1.toString());
      Fraction f5 = new Fraction(f1.toString());
      f1.add(f2);
      System.out.println("First two fractions added gives: " + f1.toString());
      f4.subtract(f2);
      System.out.println("First two fractions subtracted gives: " + 
                         f4.toString());
      f5.multiply(f2);
      System.out.println("First two fractions multiplied gives: " + 
                         f5.toString());
      f2.setNumerator(numerator);
      f2.setDenominator(denominator);
      System.out.println("Inputted numerator and denominator gives: (" + 
                         f2.getNumerator() + "/" + f2.getDenominator() + ")\n");
      
      System.out.println("end of testbed");
   }        
}
