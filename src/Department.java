/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Department is an object that contains courses and people.
 * A list of courses and a list of people are maintained within Department.
 * Department contains various methods for altering the lists.
 * @author neefez
 */
public class Department
{
   private String depName;
   protected Bag courseList = new Bag();
   protected Bag peopleList = new Bag();
   //an array of the people in the department
   protected static int numPeople = 0;
   protected static int numCourses = 0;
   
   /**
    * Constructor that creates an instance of Department using information from
    * an existing instance of Department.
    * @param dep is the existing department used for the copy
    */
   public Department(String dep)
   {
      this.depName = dep;
   }
   
   /**
    * Gives the name of the department.
    * Used for identifying the department.
    * @return the name of the department
    */ 
   public String getName()
   {
      return depName;
   }     
}
