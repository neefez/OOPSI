/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**

 @author yues
 */
public class Lab2
{

    /**
    @param args the command line arguments
    */
   public static void main(String[] args)
   {
      try
      {
         EmployeeManagement empMngmnt = new EmployeeManagement();
         empMngmnt.run();
      }
      catch (Exception e)
      {
         System.out.println("Program Error!" + e);
      }
   }
   
}
