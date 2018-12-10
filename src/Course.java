/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Course is an object that contains students and a professor.
 * Multiple students can register for each course, but only one professor can
 * be assigned per course. Courses are identified by their IDs, and each course
 * has a name.
 * @author neefez
 */
public class Course 
{
   private String courseID;
   private String courseTitle;
   protected Bag students = new Bag();
   protected int numStudents = 0;
   protected Professor prof;
   private boolean hasProf = false;
   
   /**
    * Constructs an instance of Course using 2 parameters.
    * @param id is the ID of the course, a string.
    * @param title is the title/name of the course, a string.
    */
   public Course(String id, String title)
   {
      this.courseID = id;
      this.courseTitle = title;
   }
   
   /**
    * Overrides the existing method toString() in order to be better suited for
    * the Course class.
    * Is called whenever an output of the course information is needed.
    * @return 
    */
   @Override
   public String toString()
   {
      String statement = ""; 
      statement = statement + "Course information: " + courseTitle + ", " 
                         + this.courseID + "\n";
      if(hasProf)
      {    
         statement = statement + "Professor: name=" + prof.getName() 
                     + " and id=" + prof.getId() + "\n";
      }
      statement = statement + students.print() + "\n";
      return statement;
   }        
   
   /**
    * Adds a student to the course.
    * Used for registering students to a course. Also increments the number of
    * students in the course by one.
    * @param std is the student being added to the course.
    */
   public void addStudent(Student std)
   {
      students.add(std);
      numStudents++;
   }
   
   /**
    * Removes a student from the course.
    * Is used when a student is deleted from the system. Also decrements the
    * number of students in the course by one.
    * @param std is the student that has been deleted.
    */   
   public void removeStudent(Student std)
   {
      for(int i = 0; i < numStudents; i++)
      {    
         if(students.contains(std) != null)
         { 
            numStudents--; 
            students.remove(std);    
         }    
      }    
   }         
   
   /**
    * Adds a professor to the course.
    * Also turns the boolean value hasProf to true in order to activate the
    * output of the professor's information in the course listing.
    * @param professor is the professor being added.
    */
   public void addProf(Professor professor)
   {
      prof = professor;
      hasProf = true;
   }

   /**
    * Removes the course's professor from the course.
    * Turns hasProf to false so, for all intents and purposes, the course does
    * not have a registered professor until addProf is called again.
    * @param professor is the professor that has been deleted.
    */
   public void removeProf(Professor professor)
   {
      hasProf = false;    
   }        
   
   /**
    * Gives the id of the course.
    * Is used for identifying courses and displaying course information.
    * @return The id of the course.
    */
   public String getId()
   {
      return courseID;
   }
   
   /**
    * Gives the title of the course.
    * Is used for displaying course information.
    * @return The title/name of the course.
    */
   public String getTitle()
   {
      return courseTitle;
   }         
}
