/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 @author yues
 */
public class StudentManagement
{
   private final int MAX_STUDENT_NUMBER = 100;
   //An array holding references to Student objects
   private Student[] stdList = new Student[MAX_STUDENT_NUMBER];
   Scanner stdin = new Scanner(System.in);

   /**
    This method is called in Lab1.java.
   */
   public void run()
   {
      DecimalFormat df = new DecimalFormat("#.##");
      
      for(int i = 0; i < stdList.length; i++)
      {
         System.out.println("Please enter student name: ");
         String name = stdin.nextLine();
         System.out.println("Please enter student id: ");
         int id = stdin.nextInt();
         stdList[i] = new Student(name ,id);
         stdList[i].readGrades(stdin);
         System.out.println("The student's GPA is: " 
               + df.format(stdList[i].calculateGPA()));
         System.out.println("The student's highest grade point: " 
               + stdList[i].getHighestGradePoint());
         System.out.println("The student's lowest grade point: " 
               + stdList[i].getLowestGradePoint());
         
         System.out.println("Enter NEXT to continue with next student. "
               + "\nEnter anything else to list all students and quit.");
         String cmd = stdin.nextLine();
         if(!cmd.equalsIgnoreCase("NEXT"))
            break;
      }
      
      listAllStudents();
   }
   /**
    list all students
   */
   public void listAllStudents()
   {
      System.out.println("Student list: ");
      for(int i = 0; i < stdList.length; i++)
      {
         if(stdList[i] != null)
            System.out.println(stdList[i].toString());
         else
            break;
      }
   
   }
   
}
