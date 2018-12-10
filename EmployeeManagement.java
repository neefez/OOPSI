/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.StringTokenizer;
/**
 @author yues
 */
public class EmployeeManagement
{
   private final int MAX_EMPLOYEE_NUMBER = 50;
   //An array holding references to employee objects
   private Employee[] empList = new Employee[MAX_EMPLOYEE_NUMBER];
   private int employeeNumber = 0;
   private Scanner stdin = new Scanner(System.in);

   /**
    This method is called in Lab2.java.
   */
   public void run()
   {
      preSetData();
      System.out.println("Employee Management System is running...!");
      System.out.println("Please enter L to list all employees, "
            + "S to swap job titles of two employees, "
            + "Q to quit!");
      String command = stdin.nextLine();
      while (!command.equalsIgnoreCase("Q"))//Quit
      {
         if (command.equalsIgnoreCase("L"))//List employees
            listEmployee();
         else if (command.equalsIgnoreCase("S"))//Swap job titles
            swapTitle();

         else
         {  
            System.out.println("Invalid command!");
         }          
         System.out.println("Please enter L to list all employees, "
            + "S to swap job titles of two employees, "
            + "Q to quit!");
         command = stdin.nextLine(); 
      }
      System.out.println("Thanks for using Employee Management System!");
   }
   /**
    list all students
   */
   public void listEmployee()
   {
     //TODO1
      System.out.println("Employee list:");
      for(int i = 0; i < employeeNumber; i++)
      {
         System.out.println(empList[i].toString() + " : " + 
                            empList[i].getTitle());
      }
   }
   
   public void swapTitle()
   {
      System.out.println("Please select any two employees by"
            + " entering their indices,separated by comma: \n" 
            + "1.Adam, 2.Bill, 3.Zak, 4.Henry, 5.Peter ");

      String input = stdin.nextLine();
      StringTokenizer st = new StringTokenizer(input, ",");
      int index1 = Integer.parseInt(st.nextToken());
      int index2 = Integer.parseInt(st.nextToken());
      
      if(index1<1 || index1>5 || index2<1 || index2>5 || index1==index2)
      {
         System.out.println("Invalid index! Please try again");
         return;
      }
   
      //TODO3 call the method you implemented for TODO2 
	  //to swap the titles of two given employees
	  
      swap(index1, index2);
      
      System.out.println("Job titles have been swapped.");
      listEmployee();
   
   }
   
   //TODO2 Please implement a method to swap the titles of two given employees
   public void swap(int i1, int i2)
   { 
      String title1 = empList[i1 - 1].getTitle();
      String title2 = empList[i2 - 1].getTitle();
      empList[i1 - 1].setTitle(title2);
      empList[i2 - 1].setTitle(title1);
   }
   
   public void preSetData()
   {
      empList[0] = new Employee(001, "Adam", "Software Engineer");
      empList[1] = new Employee(002, "Bill", "Team Leader");
      empList[2] = new Employee(003, "Zak", "Project Manager");
      empList[3] = new Employee(004, "Henry", "Director");
      empList[4] = new Employee(005, "Peter", "VP");
      
      employeeNumber = 5;
   }        
   
   
  
}
