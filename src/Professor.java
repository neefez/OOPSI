/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Professor is an object that is held in an instance of Department and can be 
 * registered to courses.
 * Since Professor extends Person, it contains an id and name. It also 
 * implements the abstract methods getId, getName, register, and unRegister.
 * @author neefez
 */
public class Professor extends Person
{  
   /**
    * Constructs an instance of Professor by taking 2 parameters.
    * @param name is the professor's name
    * @param id is the professor's id
    */
   public Professor(String name, int id)
   {
      this.name = name;
      this.id = id;
   }
   
   /**
    * Constructs an instance of Professor by using the data from an existing
    * instance of Professor.
    * @param prof is an existing instance of class Professor used to copy
    */
   public Professor(Professor prof)
   {
      this.name = prof.name;
      this.id = prof.id;
   }
   
   /**
    * Gives the name of the professor.
    * Used for displaying information about a professor.
    * @return the professor's name
    */
   public String getName()
   {
      return name;
   }
   
   /**
    * Gives the id of a professor.
    * Used for identifying professors or displaying their information.
    * @return the professor's id
    */
   public int getId()
   {
      return id;
   }
   
   /**
    * Registers a professor for a given course.
    * Only one professor can be registered per course.
    * @param crs is the course the professor is registered on
    */
   public void register(Course crs)
   {
      crs.addProf(this);
   }           
   
   /**
    * Turns an instance of Professor into a string with relevant data
    * @return a string with the professor's information
    */
   @Override
   public String toString()
   {
      return "Professor: name=" + name + " and id=" + id;
   }        
}
