/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class Person is a class used as a base for the classes Professor and Student.
 * Person contains the variables and methods that are shared by classes
 * Professor and Student.
 * @author neefez
 */
public abstract class Person 
{
   protected String name;
   protected int id;
   
   /**
    * Registers a person for a provided course.
    * @param crs is the course the person is added to.
    */
   public abstract void register(Course crs);
  
   /**
    * Gives the id value of the person.
    * Method is often called for identifying a person by their id.
    * @return The id value of the person.
    */
   public abstract int getId();
   
   /**
    * Gives the name of the person.
    * Is used to output the name of a person in a department.
    * @return The name of the person.
    */
   public abstract String getName();  
}
