/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Student is an object that is held in an instance of Department and can be
 * registered to courses.
 * Since Student extends Person, Student has a name and id.
 * @author neefez
 */
public class Student extends Person
{ 
   /**
    * Constructs an instance of Student by taking 2 parameters.
    * @param name is the student's name, a String
    * @param id is the student's id, an integer
    */ 
   public Student(String name, int id)
   {
      this.name = name;
      this.id = id;
   } 
   
   /**
    * Constructs an instance of Student by taking data from an existing instance
    * of Student.
    * @param std is the existing Student object
    */
   public Student(Student std)
   {
      this.name = std.name;
      this.id = std.id;
   }
   
   /**
    * Gives the name of the student.
    * Used for displaying student information.
    * @return The student's name.
    */
   public String getName()
   {
      return name;    
   }        
    
   /**
    * Gives the id of the student.
    * Used for identifying students and displaying student information.
    * @return The student's id.
    */
   public int getId()
   {
      return id;
   }        
   
   /**
    * Registers a student for a given course.
    * Multiple students can be registered to the same course.
    * @param crs is the course the student is registered to.
    */
   public void register(Course crs)
   {
      crs.addStudent(this);
   }
             
   
   @Override
   public String toString()
   {
      return "Student: name= " + name + " and id= " + id;    
   }        
}
