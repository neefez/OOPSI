/**
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/

import java.util.Scanner;

/**
 
 @author yues
 */
public class Student 
{
   private String name;
   private int id;
   private final int MAX_COURSE_NUMBER = 5;
   private float[] gradePoints = new float[MAX_COURSE_NUMBER];
   private int gradePointsNumber = 0;
   private int totalCredits = 0;
   private float highestGradePoint = 9999999;
   
   /**
   Constructor taking two parameters
   @param name student name
   @param id student id
   */  
   public Student(String name, int id)
   {
      this.name = name;
      this.id = id;
   }
   /**
   Copy constructor
   @param std reference to an existing object
   */    
   public Student(Student std)
   {
      this.id = std.id;
      this.name = std.name;
   }
   /**
   Accept user's input for total credits and a list of grade points stored in
   the array gradePoints
   */   
   public void readGrades(Scanner stdin) 
   {  
      System.out.println("Enter total credits: ");
      
      //method nextInt() reads in an integer
      totalCredits = stdin.nextInt();

      System.out.println("Enter grade points, one per line.\n"
              + "Enter some non-digit character followed by Enter to quit: ");
      
      while (gradePointsNumber < gradePoints.length && stdin.hasNextFloat()) 
      {//method nextFloat() reads in a float number
          gradePoints[gradePointsNumber++] = stdin.nextFloat();
          stdin.nextLine();//this line consumes the \n
      }
      
      if(gradePointsNumber < MAX_COURSE_NUMBER)
      {
         //this line consumes the input that is not "next"
         stdin.nextLine();
      }
   }
   /**
    @return the GPA of the student
   */   
   public float calculateGPA() 
   {
      float sumGradePoints = 0.0F;

      if (gradePoints.length == 0 || totalCredits == 0) 
      {
         return 0;
      } 
      for (int i = 0; i < gradePointsNumber; i++) 
      {
         sumGradePoints += gradePoints[i];
      }
      return sumGradePoints / totalCredits;
   }
   /**
    @return the largest grade point in the array gradePoints
   */   
   public float getHighestGradePoint() 
   {
	//TODO1
       float highest = 0;
       if (gradePoints.length < 1)
          return 0;
       else
       {
          for (int i = 0; i < gradePoints.length; i++)
          {
             if (highest < gradePoints[i])
                highest = gradePoints[i];
          }
          return highest;
       }
   } 
   
   /**
    @return the smallest grade point in the array gradePoints
   */
   public float getLowestGradePoint() 
   {
	//TODO2
       float lowest = highestGradePoint;
       if (gradePointsNumber < 1)
          return 0;
       for (int i = 0; i < gradePointsNumber; i++)
       {
          if (lowest > gradePoints[i])
             lowest = gradePoints[i];
       }
       return lowest;
   } 
   
   /**
    @return a string representing current student
   */
   @Override
   public String toString()
   {
      return "name=" + this.name + " and id=" + this.id;
   }
}
