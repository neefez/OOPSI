/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.InputMismatchException;

/**
 * DepartmentManagement is an object that contains menus that are outputted and
 * maintains a list of departments.
 * Outputs menus for the user and contains the Department objects.
 * @author neefez
 */
public class DepartmentManagement 
{   
   /**
    * Checks to see if an inputted id has already been used by a person in
    * another department.
    * Is a static method so that it can be accessed in Department without
    * instantiating DepartmentManagement.
    * @param id is the inputted id.
    * @return true if the id has not been used by an existing person, false if
    *         there is already a person with the id
    */        
   public static boolean idCheck(int id) throws InputMismatchException
   {
      for (int i = 0; i < StartFrame.numDeps; i++)
      {
         Department dep = (Department)StartFrame.depList.getFromIndex(i); 
         for(int j = 0; j < dep.numPeople; j++)
         {    
            if(dep.peopleList.getFromIndex(j) instanceof Student)
            {
               Student s = (Student)dep.peopleList.getFromIndex(j);   
               if(s.getId() == id)
               {
                  throw (new InputMismatchException("already exists"));     
               }   
            }    
            else if(dep.peopleList.getFromIndex(j) instanceof Professor)
            {
               Professor p = (Professor)dep.peopleList.getFromIndex(j);
               if(p.getId() == id)
                  throw (new InputMismatchException("already exists"));     
            }    
         }   
      }    
      return true;
   }         
}
